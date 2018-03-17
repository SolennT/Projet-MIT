/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import javax.imageio.ImageIO;
import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.dcm4che3.data.VR;
import org.dcm4che3.io.DicomOutputStream;

public class ConvertToDicom {

    /**
     * Méthode permettant la conversion d'une image au format P2 vers le format DICOM
     * Prend en paramètre le ficher d'entrée et de sortie, ainsi que les données patient et de l'examen nécéssaire à remplir
     * les tags d'informations DICOM.
     *
     */
    public void fileToDcm(File file, File fileOutput, String nomPatient, String prenomPatient, Date dateNaissance, String genre, String idPatient, Date date, String typeExamen, String compteRendu) {
        try {
            //Lecture de l'image placé en paramètre (png,jpeg,pgm) --> PGM, NetPPM P2
            BufferedImage img = ImageIO.read(file);
            if (img == null) {
                throw new Exception("Fichier Invalide");
            }

            //Un fichier DICOM est constitué de nombreux champs, ou Tag, qui doivent être remplis pour créer le dcm
            //La première étape est la création du FileMetaInformation, pour les propriétés du dcm
            Attributes FMI = new Attributes();

            FMI.setString(Tag.FileMetaInformationVersion, VR.OB, "1");
            FMI.setString(Tag.TransferSyntaxUID, VR.UI, "1.2.840.10008.1.2.1");
            FMI.setString(Tag.ImplementationVersionName, VR.SH, "DCM4CHE3");

            //Les autres champs sont remplis et notamment quelues caractéristiques
            Attributes dicom = new Attributes();

            dicom.setString(Tag.SpecificCharacterSet, VR.CS, "ISO_IR 100");
            dicom.setString(Tag.ImageType, VR.CS, "ORIGINAL\\PRIMARY");
            dicom.setString(Tag.SOPClassUID, VR.UI, "1.2.840.10008.5.1.4.1.1.7");
            dicom.setDate(Tag.StudyDate, VR.DA, date);
            dicom.setDate(Tag.SeriesDate, VR.DA, date);
            dicom.setDate(Tag.AcquisitionDate, VR.DA, date);
            dicom.setString(Tag.AccessionNumber, VR.SH, "LienPacsBD");
            dicom.setString(Tag.Modality, VR.CS, typeExamen); // [http://www.dicomlibrary.com/dicom/modality/]
            dicom.setString(Tag.ConversionType, VR.CS, "WSD"); //[https://www.dabsoft.ch/dicom/3/C.8.6/]
            dicom.setString(Tag.ResultsComments, VR.CS, compteRendu);

            //Attributs et Tag convernant le patient
            String nom = nomPatient + " " + prenomPatient;
            
            dicom.setString(Tag.PatientName, VR.PN, nom);
            dicom.setString(Tag.PatientID, VR.IS, idPatient);
            dicom.setDate(Tag.PatientBirthDate, VR.DA, dateNaissance);
            dicom.setString(Tag.PatientSex, VR.CS, genre);

            dicom.setString(Tag.StudyID, VR.IS, "1");
            dicom.setString(Tag.AcquisitionNumber, VR.IS, "1");
            dicom.setString(Tag.InstanceNumber, VR.IS, "1");

            dicom.setInt(Tag.SamplesPerPixel, VR.US, 3);
            dicom.setString(Tag.PhotometricInterpretation, VR.CS, "RGB");  // [https://www.dabsoft.ch/dicom/3/C.7.6.3.1.2/]

            dicom.setInt(Tag.PlanarConfiguration, VR.US, 0); // [https://www.medicalconnections.co.uk/kb/Planar_configuration]
            dicom.setInt(Tag.Rows, VR.US, img.getHeight());
            dicom.setInt(Tag.Columns, VR.US, img.getWidth());
            dicom.setInt(Tag.BitsAllocated, VR.US, 8);
            dicom.setInt(Tag.BitsStored, VR.US, 8);
            dicom.setInt(Tag.HighBit, VR.US, 7);
            dicom.setInt(Tag.PixelRepresentation, VR.US, 0); //[0 = non signé, 1 = signé]


            // ATTR VIDE
            //on peut maintenant remplir un nouveau fichier DICOM
            DicomOutputStream dos = new DicomOutputStream(fileOutput);
            //on écrit les attributs dans le fichier Dicom 
            dos.writeDataset(FMI, dicom);

            //création de l'attribut pixelData qui contient l'image 
            byte[] data = new byte[img.getHeight() * img.getWidth() * 3];
            int c = 0;
            for (int j = 0; j < img.getHeight(); j++) {
                for (int i = 0; i < img.getWidth(); i++) {
                    byte col = (byte) (img.getRGB(i, j) & 255);
                    data[c++] = col;
                    data[c++] = col;
                    data[c++] = col;
                }
            }
            //on remplit l'attribut pixel data du fichier Dicom
            dos.writeAttribute(Tag.PixelData, VR.OW, data);
            //on remplie l'entête du fichier Dicom
            dos.writeHeader(Tag.SequenceDelimitationItem, null, 0);
            //et on signale qu'on a terminé de remplir le fichier dicom
            dos.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}