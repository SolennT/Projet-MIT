/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;

import java.io.IOException;
import javax.xml.stream.XMLStreamException;
import sir.ui.Connexion;

/**
 *
 * @author Axel
 */
public class Main {

    private static boolean logged = false;
    private static MedicalStaff med = null;
    private static Patient p = null;
    private static DMR dm = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connexion c = new Connexion();
        c.setVisible(true);
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
    public static Patient getP() {
        return p;
    }

    /**
     * @param aP the p to set
     */
    public static void setP(Patient aP) {
        p = aP;
    }

    /**
     * @return the dm
     */
    public static DMR getDMR() {
        return dm;
    }

    /**
     * @param aDm the dm to set
     */
    public static void setDm(DMR dmr) {
        dm = dmr;
    }
}
