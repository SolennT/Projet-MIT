/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;

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
    private String id_examen;//id crée automatiquement par la bdd
    private boolean prioritaire = false;
   
            
    
    public Examen(Dates date, ExamenType type, MedicalStaff responsableRadio, MedicalStaff prescripteur, boolean prioritaire) {
        this.date = date;
        this.examenType = type;
        this.responsableRadio = responsableRadio;
        this.prioritaire = prioritaire;
        this.prescripteur = prescripteur;
        
    }

    public Examen(java.sql.Date date,String id_examen, int id_patient, String type, String id_responsableRadio) {
        this.id_examen=id_examen;
        // patient = Factory.getPatient(id_patient)
        // this.responsableRadio = Factory.getMedicalStaff(id_responsableRadio)
        this.date = new Dates(date);
        this.responsableRadio = responsableRadio;
        this.examenType = ExamenType.valueOf(type);
        
    }
    public Examen(Dates date,String id_examen, int id_patient, String type, String id_responsableRadio) {
        this.id_examen=id_examen;
        // patient = Factory.getPatient(id_patient)
        // this.responsableRadio = Factory.getMedicalStaff(id_responsableRadio)
        this.date = date;
        this.responsableRadio = responsableRadio;
        this.examenType = ExamenType.valueOf(type);
        
    }
    
    public Examen(Dates date,String id_examen, int id_patient, String type, String id_responsableRadio, String lienPacs) {
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
    public String getId_examen() {
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
    
}

    