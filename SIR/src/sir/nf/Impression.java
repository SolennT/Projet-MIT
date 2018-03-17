/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JPanel;

/**
 *
 * @author solenn
 */
public class Impression implements Printable {

    private static DMR dmr;
    private static Examen exam;
    private static Image img;

    public Impression(DMR dmr, Examen exam) throws IOException {
        this.dmr = dmr;
        this.exam = exam;
        img = ImageIO.read(new File("src/sir/ui/Ressources/CHUPP.jpg"));
    }

    public void Impression() throws IOException {
        PrinterJob job = PrinterJob.getPrinterJob();
        HashPrintRequestAttributeSet printRequestSet = new HashPrintRequestAttributeSet();
        printRequestSet.add(OrientationRequested.LANDSCAPE);

        job.setPrintable(new Impression(dmr, exam));
        if (job.printDialog(printRequestSet)) {
            try {
                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int i) throws PrinterException {
        int retValue = Printable.NO_SUCH_PAGE;
        switch (i) {
            case 0: {
                int x = (int)pageFormat.getImageableX();
                int y = (int)pageFormat.getImageableY();
                int w = (int)pageFormat.getImageableWidth();
                int h = (int)pageFormat.getImageableHeight();
                
                int marge = 30;
                
                graphics.setColor(Color.LIGHT_GRAY);
                graphics.drawRect(x+10, y+10, w-20, h-20);

                graphics.drawImage(img, x+marge , y+marge, new JPanel());
                Font font = new Font(" TimesRoman ",Font.BOLD,12);
                graphics.setFont(font);
                graphics.setColor(Color.BLACK);
                graphics.drawString("Compte rendu", x+marge+150, y+marge+110);

                Font font3 = new Font(" TimesRoman ",Font.BOLD, 8);
                graphics.setFont(font3);
                graphics.drawString("Patient : ", x+marge, y+marge+140);
                Font font2 = new Font(" TimesRoman ",Font.PLAIN, 8);
                graphics.setFont(font2);
                String s = dmr.getName() + " " + dmr.getSurname() + " (" + dmr.getGender().toString() + ")";
                graphics.drawString(s, x+marge, y+marge+160);
                s = "Né(e) le " + dmr.getBirthday().afficherDateN();
                graphics.drawString(s, x+marge, y+marge+180);
                s = dmr.getAddress();
                graphics.drawString(s, x+marge, y+marge+200);
                s = "Examen " + exam.getExamenType().toString() + " fait le " + exam.getDate().toString() + " par " + exam.getResponsableRadio();
                graphics.drawString(s, x+marge, y+marge+240);
                graphics.setFont(font3);
                s = "Compte Rendu : ";
                graphics.drawString(s, x+marge+50, y+marge+280);
                graphics.setFont(font2);
                s = exam.getReport();
                graphics.drawString(s, x+marge, y+marge+310);

                // La page est valide
                retValue = Printable.PAGE_EXISTS;
                break;
            }
        }
        return retValue;
    }
}
