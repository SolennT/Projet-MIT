/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.ui;

import static java.lang.Boolean.TRUE;
import sir.nf.DMR;
import sir.nf.Dates;
import sir.nf.Factory;
import sir.nf.Gender;

/**
 *
 * @author Utilisateur
 */
public class AjouterPatient extends javax.swing.JFrame {
    
    /**
     * Creates new customizer AjouterPatient
     */
    public AjouterPatient() {
        initComponents();
        this.setTitle("AjouterPatient");
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(500,450);
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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nomPatient = new javax.swing.JTextField();
        prenomPatient = new javax.swing.JTextField();
        adressePatient = new javax.swing.JTextField();
        jComboBoxGenre = new javax.swing.JComboBox<Gender>(Gender.values());
        jButtonEnregistrer = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldAnnee = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldMois = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldJour = new javax.swing.JTextField();
        jButtonEnregistrerAjouterExam = new javax.swing.JButton();

        setBackground(new java.awt.Color(174, 203, 248));
        setMaximumSize(new java.awt.Dimension(500, 450));
        setMinimumSize(new java.awt.Dimension(500, 450));
        setPreferredSize(new java.awt.Dimension(500, 450));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(174, 203, 248));
        jLabel1.setText("Ajouter Patient");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(169, 169, 169))
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
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 450));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel8.setText("Nom:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel9.setText("Prénom:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel10.setText("Date de naissance:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel11.setText("Genre:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel12.setText("Adresse");

        nomPatient.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        nomPatient.setText("Nom");
        nomPatient.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nomPatientFocusGained(evt);
            }
        });

        prenomPatient.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        prenomPatient.setText("Prénom");
        prenomPatient.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                prenomPatientFocusGained(evt);
            }
        });

        adressePatient.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        adressePatient.setText("Adresse");
        adressePatient.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adressePatientFocusGained(evt);
            }
        });

        jComboBoxGenre.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jButtonEnregistrer.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButtonEnregistrer.setText("Enregistrer");
        jButtonEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnregistrerActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sir/ui/Ressources/ajouterPatientGrand.png"))); // NOI18N

        jTextFieldAnnee.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAnnee.setText("AAAA");
        jTextFieldAnnee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldAnneeFocusGained(evt);
            }
        });

        jLabel6.setText("/");

        jTextFieldMois.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldMois.setText("MM");
        jTextFieldMois.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldMoisFocusGained(evt);
            }
        });

        jLabel5.setText("/");

        jTextFieldJour.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldJour.setText("JJ");
        jTextFieldJour.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldJourFocusGained(evt);
            }
        });

        jButtonEnregistrerAjouterExam.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButtonEnregistrerAjouterExam.setText("Enregistrer & Ajouter un examen");
        jButtonEnregistrerAjouterExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnregistrerAjouterExamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prenomPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adressePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldJour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMois, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEnregistrer)
                .addGap(35, 35, 35)
                .addComponent(jButtonEnregistrerAjouterExam)
                .addGap(76, 76, 76))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(prenomPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldJour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldMois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addComponent(jLabel10))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(adressePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEnregistrer)
                    .addComponent(jButtonEnregistrerAjouterExam))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnregistrerActionPerformed
        // TODO add your handling code here:
        int jour = Integer.parseInt(jTextFieldJour.getText());
        int mois = Integer.parseInt(jTextFieldMois.getText());
        int annee = Integer.parseInt(jTextFieldAnnee.getText());
        Dates dateN = new Dates(jour, mois, annee);
        boolean res = Factory.creerPatient(nomPatient.getText(), prenomPatient.getText(), (Gender) jComboBoxGenre.getSelectedItem(), adressePatient.getText(), dateN, 0);
        if (res == TRUE){
            System.out.println("Ajout");
            javax.swing.JOptionPane.showMessageDialog(null, "Le patient a bien été ajouté");
        }    
        else {
            System.out.println("Echec Ajout");
            javax.swing.JOptionPane.showMessageDialog(null, "Echec lors de l'ajout du patient");
        }
        this.dispose();
    }//GEN-LAST:event_jButtonEnregistrerActionPerformed

    private void nomPatientFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomPatientFocusGained
        // TODO add your handling code here:
        nomPatient.setText("");
    }//GEN-LAST:event_nomPatientFocusGained

    private void prenomPatientFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prenomPatientFocusGained
        // TODO add your handling code here:
        prenomPatient.setText("");
    }//GEN-LAST:event_prenomPatientFocusGained

    private void adressePatientFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adressePatientFocusGained
        // TODO add your handling code here:
        adressePatient.setText("");
    }//GEN-LAST:event_adressePatientFocusGained

    private void jButtonEnregistrerAjouterExamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnregistrerAjouterExamActionPerformed
        // TODO add your handling code here:
        int jour = Integer.parseInt(jTextFieldJour.getText());
        int mois = Integer.parseInt(jTextFieldMois.getText());
        int annee = Integer.parseInt(jTextFieldAnnee.getText());
        Dates dateN = new Dates(jour, mois, annee);
        DMR dmr = new DMR(nomPatient.getText(), prenomPatient.getText(), (Gender) jComboBoxGenre.getSelectedItem(), adressePatient.getText(), dateN);
        boolean res = Factory.creerPatient(nomPatient.getText(), prenomPatient.getText(), (Gender) jComboBoxGenre.getSelectedItem(), adressePatient.getText(), dateN, 0);
        if (res == TRUE){
            System.out.println("Ajout");
            javax.swing.JOptionPane.showMessageDialog(null, "Le patient a bien été ajouté");
        }    
        else {
            System.out.println("Echec Ajout");
            javax.swing.JOptionPane.showMessageDialog(null, "Echec lors de l'ajout du patient");
        }
        AjouterExamen addExamen= new AjouterExamen(dmr);
        addExamen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonEnregistrerAjouterExamActionPerformed

    private void jTextFieldJourFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldJourFocusGained
        // TODO add your handling code here:
        jTextFieldJour.setText("");
    }//GEN-LAST:event_jTextFieldJourFocusGained

    private void jTextFieldMoisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldMoisFocusGained
        // TODO add your handling code here:
        jTextFieldMois.setText("");
    }//GEN-LAST:event_jTextFieldMoisFocusGained

    private void jTextFieldAnneeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAnneeFocusGained
        // TODO add your handling code here:
        jTextFieldAnnee.setText("");
    }//GEN-LAST:event_jTextFieldAnneeFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adressePatient;
    private javax.swing.JButton jButtonEnregistrer;
    private javax.swing.JButton jButtonEnregistrerAjouterExam;
    private javax.swing.JComboBox<Gender> jComboBoxGenre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldAnnee;
    private javax.swing.JTextField jTextFieldJour;
    private javax.swing.JTextField jTextFieldMois;
    private javax.swing.JTextField nomPatient;
    private javax.swing.JTextField prenomPatient;
    // End of variables declaration//GEN-END:variables
}