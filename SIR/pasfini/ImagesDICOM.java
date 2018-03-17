/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;

import com.pixelmed.dicom.Attribute;
import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.DicomException;
import com.pixelmed.dicom.TagFromName;
import com.pixelmed.display.SingleImagePanel;
import com.pixelmed.display.SourceImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;

/**
 *
 * @author Solenn
 */
public class ImagesDICOM {

    private Vector<AttributeList> listTag = new Vector<>();
    private AttributeList list1 = new AttributeList();
    private AttributeList list2 = new AttributeList();
    private AttributeList list3 = new AttributeList();
    private Vector<SingleImagePanel> listImage;
    private SingleImagePanel image1;
    private SingleImagePanel image2;
    private SingleImagePanel image3;

    public ImagesDICOM() throws IOException, DicomException {
        listImage = new Vector<>();
        this.list1.read(new File("src/sir/ui/Ressources/dicom/image1.dcm"));
        this.listTag.add(list1);
        image1 = new SingleImagePanel(new SourceImage("src/sir/ui/Ressources/dicom/image1.dcm"));
        listImage.add(image1);
        image2 = new SingleImagePanel(new SourceImage("src/sir/ui/Ressources/dicom/image2.dcm"));
        this.list2.read(new File("src/sir/ui/Ressources/dicom/image2.dcm"));
        listImage.add(image2);
        this.listTag.add(list2);
        image3 = new SingleImagePanel(new SourceImage("src/sir/ui/Ressources/dicom/image3.dcm"));
        this.list3.read(new File("src/sir/ui/Ressources/dicom/image3.dcm"));
        listImage.add(image3);
        this.listTag.add(list3);
    }

    /**
     *
     * Affichiage d'une image DICOM
     */
    public void afficherDICOM(SingleImagePanel image) throws IOException, DicomException {
        JFrame p = new JFrame();
        p.add(image);
        p.setBackground(Color.BLACK);
        p.setSize(1024, 1024);
        p.setVisible(true);

    }

    /**
     *
     * Récupère la date de l'examen du fichier DICOM
     */
    public String getDate(int i) throws DicomException, IOException {
        return Attribute.getSingleStringValueOrNull(getListTag().get(i), TagFromName.StudyDate);
    }

    /**
     *
     * Récupère le nom du PH responsable de l'examen du fichier DICOM
     */
    public String getNomPh(int i) {
        return Attribute.getSingleStringValueOrNull(getListTag().get(i), TagFromName.OperatorName);
    }

    /**
     *
     * Récupère le type de l'examen du fichier DICOM
     */
    public String getTypeExamen(int i) {
        return Attribute.getSingleStringValueOrNull(getListTag().get(i), TagFromName.Modality);
    }

    /**
     *
     * Récupère le compte-rendu de l'examen du fichier DICOM
     */
    public String getCompteRendu(int i) {
        return Attribute.getSingleStringValueOrNull(getListTag().get(i), TagFromName.ResultsComments);
    }

    /**
     *
     * Récupère le line vers le PACS de l'examen du fichier DICOM
     */
    public String getLienPACS(int i) {
        return Attribute.getSingleStringValueOrNull(getListTag().get(i), TagFromName.TransferSyntaxUID);
    }

    /**
     * @return the listImage
     */
    public List<SingleImagePanel> getListImage() {
        return listImage;
    }

    /**
     * @param listImage the listImage to set
     */
    public void setListImage(Vector<SingleImagePanel> listImage) {
        this.listImage = listImage;
    }

    /**
     * @return the image1
     */
    public SingleImagePanel getImage1() {
        return image1;
    }

    /**
     * @param image1 the image1 to set
     */
    public void setImage1(SingleImagePanel image1) {
        this.image1 = image1;
    }

    /**
     * @return the listTag
     */
    public List<AttributeList> getListTag() {
        return listTag;
    }

    /**
     * @param listTag the listTag to set
     */
    public void setListTag(Vector<AttributeList> listTag) {
        this.listTag = listTag;
    }

    /**
     * @return the image4
     */
    public SingleImagePanel getImage2() {
        return image2;
    }

    /**
     * @return the image3
     */
    public SingleImagePanel getImage3() {
        return image3;
    }
}
