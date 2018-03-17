/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import javax.imageio.ImageIO;
import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Sequence;
import org.dcm4che3.data.Tag;
import org.dcm4che3.data.UID;
import org.dcm4che3.data.VR;
import org.dcm4che3.io.DicomOutputStream;
import org.dcm4che3.util.UIDUtils;

/**
 * Create jpeg to dcm
 *
 * @author Dimitri
 */
public class Test2 {

    private static int jpgLen;
    private String transferSyntax = UID.JPEGBaseline1;

    public Test2(File file, File fileOutput, String nomPatient, String prenomPatient, Date dateNaissance, String genre, String idPatient, Date date, String typeExamen, String compteRendu, String RespoRadio) {
        try {
            jpgLen = (int) file.length();

            BufferedImage img = ImageIO.read(file);
            if (img == null) {
                throw new Exception("Invalid file.");
            }

            int colorComponents = img.getColorModel().getNumColorComponents();
            int bitsPerPixel = img.getColorModel().getPixelSize();
            int bitsAllocated = (bitsPerPixel / colorComponents);
            int samplesPerPixel = colorComponents;

            Attributes dicom = new Attributes();
            dicom.setString(Tag.SpecificCharacterSet, VR.CS, "ISO_IR 100");
            dicom.setString(Tag.PhotometricInterpretation, VR.CS, samplesPerPixel == 3 ? "YBR_FULL_422" : "MONOCHROME2");
            //dicom.setString(Tag.PhotometricInterpretation, VR.CS, "RGB");

            dicom.setInt(Tag.SamplesPerPixel, VR.US, samplesPerPixel);
            dicom.setInt(Tag.PlanarConfiguration, VR.US, 0);
            dicom.setInt(Tag.Rows, VR.US, img.getHeight());
            dicom.setInt(Tag.Columns, VR.US, img.getWidth());
            dicom.setInt(Tag.BitsAllocated, VR.US, bitsAllocated);
            dicom.setInt(Tag.BitsStored, VR.US, bitsAllocated);
            dicom.setInt(Tag.HighBit, VR.US, bitsAllocated - 1);
            dicom.setInt(Tag.PixelRepresentation, VR.US, 0);

            dicom.setDate(Tag.InstanceCreationDate, VR.DA, new Date());
            dicom.setDate(Tag.InstanceCreationTime, VR.TM, new Date());

            dicom.setString(Tag.StudyInstanceUID, VR.UI, UIDUtils.createUID());
            dicom.setString(Tag.SeriesInstanceUID, VR.UI, UIDUtils.createUID());
            dicom.setString(Tag.SOPInstanceUID, VR.UI, UIDUtils.createUID());
            dicom.setString(Tag.StudyInstanceUID, VR.UI, UIDUtils.createUID());
            dicom.setString(Tag.SeriesInstanceUID, VR.UI, UIDUtils.createUID());
            dicom.setString(Tag.SOPInstanceUID, VR.UI, UIDUtils.createUID());

            dicom.setString(Tag.ImageType, VR.CS, "ORIGINAL\\PRIMARY");
            dicom.setString(Tag.SOPClassUID, VR.UI, "1.2.840.10008.5.1.4.1.1.7");
            dicom.setDate(Tag.StudyDate, VR.DA, date);
            dicom.setDate(Tag.SeriesDate, VR.DA, date);
            dicom.setDate(Tag.AcquisitionDate, VR.DA, date);
            dicom.setString(Tag.AccessionNumber, VR.SH, "LienPacsBD");
            dicom.setString(Tag.Modality, VR.CS, typeExamen);
            dicom.setString(Tag.ConversionType, VR.CS, "WSD");
            dicom.setString(Tag.ResultsComments, VR.CS, compteRendu);
            dicom.setString(Tag.PerformingPhysicianName, VR.PN, RespoRadio);
            dicom.setString(Tag.AdmittingDiagnosesDescription, VR.LO, "CHUPP");

            String nom = nomPatient + " " + prenomPatient;
            dicom.setString(Tag.PatientName, VR.PN, nom);
            dicom.setString(Tag.PatientID, VR.IS, idPatient);
            dicom.setDate(Tag.PatientBirthDate, VR.DA, dateNaissance);
            dicom.setString(Tag.PatientSex, VR.CS, genre);

            Sequence seq = dicom.newSequence(Tag.AnatomicRegionSequence, 0);
            Attributes dicom2 = new Attributes();

            //dicom2.setString(Tag.CodingSchemeDesignator, VR.SH, "SRT");
            //dicom2.setString(Tag.CodeValue, VR.SH, "T-AA000");
            //dicom2.setString(Tag.CodeMeaning, VR.LO, "Eye");
            //seq.add(dicom2);

            /*Our Dicom header is almost done. 
	      * The following command initiates Dicom metafile information considering JPEGBaseline1 as transfer syntax.
	      * This means this file has Jpeg data encapsulated instead common medical image pixel data. 
	      * The most common Jpeg files use a subset of the Jpeg standard called baseline Jpeg. 
	      * A baseline Jpeg file contains a single image compressed with the baseline discrete cosine transformation (DCT) and Huffman encoding.
             */
            // dicom.initFileMetaInformation(UID.JPEGBaseline1);  
            /*After initiate the header we can open an output stream for saving our Dicom dataset as follows:*/
            Attributes fmi = new Attributes();

            fmi.setString(Tag.ImplementationVersionName, VR.SH, "DCM4CHE3");
            fmi.setString(Tag.ImplementationClassUID, VR.UI, UIDUtils.createUID());
            fmi.setString(Tag.TransferSyntaxUID, VR.UI, transferSyntax);
            fmi.setString(Tag.MediaStorageSOPClassUID, VR.UI, transferSyntax);
            fmi.setString(Tag.MediaStorageSOPInstanceUID, VR.UI, UIDUtils.createUID());
            fmi.setString(Tag.FileMetaInformationVersion, VR.OB, "1");
            fmi.setInt(Tag.FileMetaInformationGroupLength, VR.UL, dicom.size() + fmi.size());

            DicomOutputStream dos = new DicomOutputStream(fileOutput);
            dos.writeDataset(fmi, dicom);
            dos.writeHeader(Tag.PixelData, VR.OB, -1);
                    
            dos.writeHeader(Tag.Item, null, 0);
            
            dos.writeHeader(Tag.Item, null, (jpgLen + 1) & ~1);
            
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);

            byte[] buffer = new byte[65536];
            int b;
            while ((b = dis.read(buffer)) > 0) {
                dos.write(buffer, 0, b);
            }
            /*Finally, the Dicom Standard tells that we have to put a last Tag: 
	      * a Sequence Delimiter Item (FFFE,E0DD) with length equals to zero.*/

            if ((jpgLen & 1) != 0) {
                dos.write(0);
            }
            dos.writeHeader(Tag.SequenceDelimitationItem, null, 0);
            dos.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
