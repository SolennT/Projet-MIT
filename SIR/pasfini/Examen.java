/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;

import java.util.ArrayList;

/**
 *
 * @brief classe comportant un lien avec le PACS et un compte rendu d'examen.
 */
public class Examen {
    
    private String pacsID;
    private String report;
    private ExamenType examenType;
    private Dates date;
    private MedicalStaff responsableRadio;
    private MedicalStaff prescripteur;
    private ArrayList<String> Paths;
    private int id_examen;//id crée automatiquement par la bdd
    private boolean prioritaire = false;
   
            
    
    public Examen(Dates date, ExamenType type, MedicalStaff responsableRadio, MedicalStaff prescripteur, boolean prioritaire) {
        this.date = date;
        this.examenType = type;
        this.responsableRadio = responsableRadio;
        this.prioritaire = prioritaire;
        this.prescripteur = prescripteur;
        
    }

    public Examen(java.sql.Date date,int id_examen, int id_patient, String type, String id_responsableRadio) {
        this.id_examen=id_examen;
        // patient = Factory.getPatient(id_patient)
        // this.responsableRadio = Factory.getMedicalStaff(id_responsableRadio)
        this.date = new Dates(date);
        this.responsableRadio = responsableRadio;
        this.examenType = ExamenType.valueOf(type);
        
    }
    public Examen(Dates date,int id_examen, int id_patient, String type, int id_responsableRadio, int id_prescripteur, String pacs, String cr, boolean prio, String path) {
        this.id_examen=id_examen;
        // patient = Factory.getPatient(id_patient)
        this.date = date;
        this.prescripteur = Factory.rechercheMedicalStaffId(id_prescripteur);
        this.responsableRadio = Factory.rechercheMedicalStaffId(id_responsableRadio);
        this.examenType = ExamenType.valueOf(type);
        this.pacsID = pacs;
        this.report = cr;
        this.prioritaire = prio;
        this.Paths = new ArrayList<String>();
        this.Paths.add(path);
    }
    
    public Examen(Dates date,int id_examen, int id_patient, String type, String id_responsableRadio, String lienPacs) {
        this.id_examen=id_examen;
        // patient = Factory.getPatient(id_patient)
        // this.responsableRadio = Factory.getMedicalStaff(id_responsableRadio)
        this.date = date;
        this.responsableRadio = responsableRadio;
        this.examenType = ExamenType.valueOf(type);
        
    }
    
    /**
     * @return the prescripteur
     */
    public MedicalStaff getPrescripteur() {
        return prescripteur;
    }

    /**
     * @return the prioritaire
     */
    public boolean isPrioritaire() {
        return prioritaire;
    }

    /**
     * @return the examenType
     */
    public ExamenType getExamenType() {
        return examenType;
    }

    /**
     * @return the date
     */
    public Dates getDate() {
        return date;
    }

    /**
     * @return the responsableRadio
     */
    public MedicalStaff getResponsableRadio() {
        return responsableRadio;
    }

    /**
     * @return the id_examen
     */
    public int getId_examen() {
        return id_examen;
    }

    /**
     * @return the pacsID
     */
    public String getPacsID() {
        return pacsID;
    }

    /**
     * @return the report
     */
    public String getReport() {
        return report;
    }
    
    /**
     * 
     * @ajoute un compte-rendu si il n'y en pas
     */
    public void EcrireCR(String cr){
        if (this.report == null){
            report = cr;
        }
    }

    /**
     * @return the Paths
     */
    public ArrayList<String> getPaths() {
        return Paths;
    }
    
}

    