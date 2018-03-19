/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.stream.XMLStreamException;
import sir.ui.AjouterPatient;
import sir.ui.Connexion;

/**
 *
 * @author Axel
 */
public class Main {

    private static boolean logged = false;
    private static MedicalStaff med = null;
    private static DMR p = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        Function statut = Function.Exterieur;
//        System.out.println(statut.name());
        Dates d = new Dates(11, 12, 2011, 7, 30);

        Gender genre = Gender.H;
        //Factory.creerPatient("Dursley","Dudley", Gender.H, "4 private drive", d, 0);
        MedicalStaff lupin = new MedicalStaff("Lupin", "Remus", Function.Manipulateur);
        MedicalStaff ombrage = new MedicalStaff("Ombrage", "Dolores", Function.Secretaire);
        ArrayList<MedicalStaff> test = new ArrayList();
        test = Factory.getListeMedecin();

        int i = 0;
        DMR p = Factory.getPatient(2);
        
        System.out.println(p.getBirthday().afficherDateN());
//        for (MedicalStaff dmr:test){
//            
//            System.out.println(dmr.getFunctionStr());
//            System.out.println(dmr.getMdp());
//            System.out.println(dmr.getSurname());
//            System.out.println(dmr.getName());
//            System.out.println(dmr.getId());
//        }
        ArrayList<Examen> exams = new ArrayList();
        
        String idtest = "4";
        exams = Factory.getListeExam(Integer.parseInt(idtest));
        for (Examen e : exams) {
            
            System.out.println(e.getReport());
            
            
        }
        //Factory.creerExam(13, d, ExamenType.IRM, ombrage , lupin, 0);
//        Connexion c = new Connexion();
//        c.setVisible(true);
//        Menu menu;
//            setLogged(l.getLogged());
//        if( isLogged()){
//            Medecin med= l.getMedecin();
//            menu = new Menu(med);
//            menu.setVisible(true);
//        }
    }

    public static MedicalStaff getMedecin() {
        return med;
    }

    /**
     * @return the logged
     */
    public static boolean isLogged() {
        return logged;
    }

    /**
     * @param aLogged the logged to set
     */
    public static void setLogged(boolean aLogged) {
        logged = aLogged;
    }

    /**
     * @return the med
     */
    public static void setMed(MedicalStaff m) {
        med = m;
    }

    /**
     * @return the p
     */
    public static DMR getP() {
        return p;
    }

    /**
     * @param aP the p to set
     */
    public static void setP(DMR aP) {
        p = aP;
    }
}

/**
 * @return the dm
 */
