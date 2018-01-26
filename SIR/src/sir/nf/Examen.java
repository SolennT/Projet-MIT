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
    private Date date;
    private MedicalStaff prescripteur;
    private MedicalStaff responsableRadio;
            
    
    public Examen(Date date, ExamenType type, MedicalStaff prescripteur, MedicalStaff resposableRadio) {
        this.date = date;
        this.examenType = type;
        this.prescripteur = prescripteur;
        this.responsableRadio = responsableRadio;
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
    
    public void EcrireCR(String cr){
        if (this.report == null){
            report = cr;
        }
    }
    
}

    