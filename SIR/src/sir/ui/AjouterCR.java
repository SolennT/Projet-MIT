/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.ui;

import java.util.ArrayList;
import sir.nf.DMR;
import sir.nf.Examen;
import sir.nf.Factory;

/**
 *
 * @author solenn
 */
public class AjouterCR extends javax.swing.JFrame {

    private Examen exam;
    private DMR dmr;

    /**
     * Creates new customizer AjouterCR
     */
    public AjouterCR(Examen exam, DMR dmr) {
        initComponents();
        this.setTitle("CompleterExamen");
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(500, 450);
        this.exam = exam;
        this.dmr = dmr;
        jTextFieldIdPatient.setText(Integer.toString(dmr.getId()));
        jTextFieldIdExam.setText("" + exam.getId_examen());
        if (exam.getPacsID().equals("DMR Papier")) {
            jTextFieldPACS.setText(exam.getPacsID());
        }
    }

    public AjouterCR() {
        initComponents();
        this.setTitle("CompleterExamen");
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(500, 450);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonEnregistrer = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldIdPatient = new javax.swing.JTextField();
        jTextFieldIdExam = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldPACS = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CR = new javax.swing.JTextArea();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(174, 203, 248));
        jLabel1.setText("Compléter Examen");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(157, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(145, 145, 145))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jButtonEnregistrer.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButtonEnregistrer.setText("Enregistrer");
        jButtonEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnregistrerActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("Identifiant Patient :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setText("Identifiant Examen :");

        jTextFieldIdPatient.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextFieldIdPatient.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIdPatient.setText("Identifiant");
        jTextFieldIdPatient.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldIdPatientFocusGained(evt);
            }
        });

        jTextFieldIdExam.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextFieldIdExam.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldIdExam.setText("Identifiant");
        jTextFieldIdExam.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldIdExamFocusGained(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setText("Lien PACS :");

        jTextFieldPACS.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextFieldPACS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPACS.setText("Lien");
        jTextFieldPACS.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldPACSFocusGained(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setText("Compte rendu :");

        CR.setColumns(20);
        CR.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        CR.setRows(10);
        jScrollPane1.setViewportView(CR);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addComponent(jButtonEnregistrer)
                .addGap(195, 195, 195))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldIdPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldIdExam, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldPACS, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldIdPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldIdExam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldPACS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEnregistrer)
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnregistrerActionPerformed
        // TODO add your handling code here:
        int id_patient = Integer.parseInt(jTextFieldIdPatient.getText());
        int id_exam = Integer.parseInt(jTextFieldIdExam.getText());
        String lienPACS;
        if (exam.getPacsID().equals("DMR Papier")) {
            lienPACS = "DMR Papier";
        } else {
            lienPACS = jTextFieldPACS.getText();
        }
        Factory.ecrireCRPACS(id_patient, id_exam, CR.getText(), lienPACS);
        this.dispose();
    }//GEN-LAST:event_jButtonEnregistrerActionPerformed

    private void jTextFieldIdPatientFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIdPatientFocusGained
        // TODO add your handling code here:
        jTextFieldIdPatient.setText("");
    }//GEN-LAST:event_jTextFieldIdPatientFocusGained

    private void jTextFieldIdExamFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIdExamFocusGained
        // TODO add your handling code here:
        jTextFieldIdExam.setText("");
    }//GEN-LAST:event_jTextFieldIdExamFocusGained

    private void jTextFieldPACSFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPACSFocusGained
        // TODO add your handling code here:
        jTextFieldPACS.setText("");
    }//GEN-LAST:event_jTextFieldPACSFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CR;
    private javax.swing.JButton jButtonEnregistrer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldIdExam;
    private javax.swing.JTextField jTextFieldIdPatient;
    private javax.swing.JTextField jTextFieldPACS;
    // End of variables declaration//GEN-END:variables
}
