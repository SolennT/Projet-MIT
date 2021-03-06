/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.ui;

import com.pixelmed.dicom.DicomException;
import com.pixelmed.display.SingleImagePanel;
import com.pixelmed.display.SourceImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author solenn
 */
public class AfficherImage extends javax.swing.JFrame {

    public AfficherImage(SingleImagePanel image) throws IOException, DicomException {
        initComponents();
        this.setTitle("Radiographie");
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(370, 370);

        FrameImage.add(image);
        FrameImage.setBackground(Color.BLACK);
        FrameImage.setSize(550, 550);
        FrameImage.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FrameImage = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonEnregistrer = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jButtonRotationD = new javax.swing.JButton();
        jButtonRotationG = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(174, 203, 248));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Radiographie");
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Medical Imaging Technology - Radiology Information System Exploitation   ");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel11.add(jLabel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel11, java.awt.BorderLayout.SOUTH);

        jPanel2.setBackground(new java.awt.Color(174, 203, 248));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 450));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jButtonEnregistrer.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButtonEnregistrer.setText("Enregistrer");
        jButtonEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnregistrerActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonEnregistrer, java.awt.BorderLayout.PAGE_END);

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(174, 203, 248)));
        jPanel12.setMinimumSize(new java.awt.Dimension(168, 200));
        jPanel12.setPreferredSize(new java.awt.Dimension(100, 200));
        jPanel12.setLayout(new java.awt.GridLayout(4, 2));

        jButtonRotationD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sir/ui/Ressources/RotationD.png"))); // NOI18N
        jButtonRotationD.setContentAreaFilled(false);
        jPanel12.add(jButtonRotationD);

        jButtonRotationG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sir/ui/Ressources/RotationG.png"))); // NOI18N
        jButtonRotationG.setContentAreaFilled(false);
        jPanel12.add(jButtonRotationG);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sir/ui/Ressources/Luminosité+.png"))); // NOI18N
        jButton4.setContentAreaFilled(false);
        jPanel12.add(jButton4);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sir/ui/Ressources/Contraste.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jPanel12.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sir/ui/Ressources/Miroir.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jPanel12.add(jButton3);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sir/ui/Ressources/Luminosité-.png"))); // NOI18N
        jButton5.setContentAreaFilled(false);
        jPanel12.add(jButton5);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sir/ui/Ressources/Texte.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jPanel12.add(jButton1);

        jPanel2.add(jPanel12, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnregistrerActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonEnregistrerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame FrameImage;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonEnregistrer;
    private javax.swing.JButton jButtonRotationD;
    private javax.swing.JButton jButtonRotationG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
