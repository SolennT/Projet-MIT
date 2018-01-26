/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;

import java.util.ArrayList;


/**
 *
 * @author axelm
 */

public class DMR {
    private ArrayList<Examen> listExamens;
    private Patient patient;
    
    public DMR (Patient patient){
        this.patient = patient;
        this.listExamens = new ArrayList<Examen>();
    }
    
    public void ajouterExamen (Examen examen){
        listExamens.add(examen);
        
    }
}
