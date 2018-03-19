/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;

import java.util.Calendar;
import java.util.GregorianCalendar;


/*!
 *
 *  @class Dates
 *
 *  @brief Classe representant une date composee des jour, mois, annee, heure et minute.
 *
 */
public class Dates implements Comparable {

    private int jour;
    private int mois;
    private int annee;
    private int heure;
    private int minute;
    private boolean valide;

    /*!
         *
         *  @brief Constructeur surcharge d'une Dates comprenant tous les parametres.
         *
         *  @param jour Jour correspondant a la date.
         *  @param mois Mois correspondant a la date.
         *  @param annee Annee correspondant a la date.
         *  @param heure Heure correspondant a la date.
         *  @param minute Minute correspondant a la date.
     */
    public Dates(int jours, int mois, int annee) {
        java.util.GregorianCalendar calendar = new GregorianCalendar();
	java.util.Date time  = calendar.getTime();
        if (jours>0 && jours<32){
            this.jour = jours;
        }
        if (mois>0 && mois<=12){
            this.mois = mois;
        }
        if (annee>=1900 && annee<=time.getYear()+1900){
            this.annee = annee;
        }
        this.heure =0;
        this.minute=0;
    }
            
        public Dates(int jours, int mois, int annee, int heure, int minute) {
        java.util.GregorianCalendar calendar = new GregorianCalendar();
	java.util.Date time  = calendar.getTime();
        if (jours>0 && jours<32){
            this.jour = jours;
        }
        if (mois>0 && mois<=12){
            this.mois = mois;
        }
        if (annee>=1900 && annee<=time.getYear()+1900){
            this.annee = annee;
        }
        if (heure>=0 && heure<=23){
            this.heure = heure;
        }
        if (minute>=0 && minute<=59){
            this.minute = minute;
        }
        
    }
    public Dates(java.sql.Date d) {
        int an = d.getYear();
        if (an<=1900){
        this.annee=an+1900;}
        else{
            this.annee =an;
        }
        this.mois=d.getMonth()+1;
        this.jour=d.getDate();
    }
    public Dates(java.sql.Date d, int heure, int minute) {
        int an = d.getYear();
        if (an<=1900){
        this.annee=an+1900;}
        else{
            this.annee =an;
        }
        this.mois=d.getMonth()+1;
        this.jour=d.getDate();
        if(heure>=0 && heure<=23 && minute>=0 && minute<=59){
            this.heure = heure;
            this.minute= minute;
        }
        else{
            this.heure = 0;
            this.minute = 0;
            this.valide =false;
        }
        
        
    }
    /*!
         *
         *  @brief Constructeur surcharge d'une Dates.
         *
         *  @param jour Jour correspondant a la date.
         *  @param mois Mois correspondant a la date.
         *  @param annee Ann�e correspondant a la date.
     */
    
    public Dates() {
        java.util.GregorianCalendar calendar = new GregorianCalendar();
	java.util.Date time  = calendar.getTime();
        this.annee=time.getYear()+1900;
        this.mois=time.getMonth();
        this.jour=time.getDay();
        this.heure=time.getHours();
        this.minute=time.getMinutes();
    }
    
    public java.sql.Date getSQLDate(){
        java.sql.Date D = new java.sql.Date(this.getAnnee()-1900, this.getMois(), this.getJour());
        
        return D;
    }
    
    public java.util.Date getJavaDate(){
        java.util.Date D = new java.util.Date(this.getAnnee() -1900, this.getMois(), this.getJour(), this.getHeure(), this.getMinute());
        
        return D;
    }
    

    
    /*!
         *
         *  \brief Methode de description d'une date.
         *
         *  @return Retourne le descriptif de la date.
         *
     */
    @Override
    public String toString() {
        String s = "";
        if (getJour() < 10) {
            s += "0" + getJour() + "/";
        } else {
            s += getJour() + "/";
        }
        if (getMois() < 10) {
            s += "0" + getMois() + "/";
        } else {
            s += getMois() + "/";
        }
        s += getAnnee() + " à ";
        if (getHeure() < 10) {
            s += "0" + getHeure() + ":";
        } else {
            s += getHeure() + ":";
        }
        if (getMinute() < 10) {
            s += "0" + getMinute();
        } else {
            s += getMinute();
        }
        return s;
    }

    /*!
         *
         *  \brief Methode d'affichage d'une date de naissance.
         *
         *  @return Retourne la date de naissance.
         *
     */
    public String afficherDateN() {
        if (getMois() < 10 && getJour() < 10) {
            return "0" + getJour() + "/0" + getMois() + "/" + getAnnee();
        }
        if (getMois() < 10) {
            return getJour() + "/0" + getMois() + "/" + getAnnee();
        }
        if (getJour() < 10) {
            return "0" + getJour() + "/" + getMois() + "/" + getAnnee();
        } else {
            return +getJour() + "/" + getMois() + "/" + getAnnee();
        }
    }

    /*!
         *
         *  @brief Methode de comparaison de dates.
         *
         *  @param o Object correspondant a la date a comparer
         *
         *  @return Retourne true si les dates sont egales, false sinon.
         *
     */
    public boolean equals(Object o) {
        if (o instanceof sir.nf.Dates) {
            sir.nf.Dates d = (sir.nf.Dates) o;
            return (getAnnee() == d.getAnnee()) && (getMois() == d.getMois()) && (getJour() == d.getJour());
        } else {
            return false;
        }
    }

    public boolean equalsMinute(Object o) {
        if (o instanceof sir.nf.Dates) {
            sir.nf.Dates d = (sir.nf.Dates) o;
            return (getAnnee() == d.getAnnee()) && (getMois() == d.getMois()) && (getJour() == d.getJour()) && (getHeure() == d.getHeure()) && (getMinute() == d.getMinute());
        } else {
            return false;
        }
    }
    // precondition : 'o' est une instance de 'Dates' :
     /*!
         *
         *  @brief Difference entre deux dates.
         *
         *  @param o Object correspondant a la date a comparer
         *
         *  @return Retourne le temps de difference entre les deux dates.
         *
         */
    public int compareTo(Object o) {
        sir.nf.Dates d = (sir.nf.Dates) o;
        if (getAnnee() != d.getAnnee()) {
            return getAnnee() - d.getAnnee();
        }
        // ici on a forcement annee == d.annee :
        if (getMois() != d.getMois()) {
            return getMois() - d.getMois();
        }
        // ici on a forcement annee == d.annee et mois == d.mois :
        //return jour - d.jour;
        if (getJour() != d.getJour()) {
            return getJour() - d.getJour();
        }
        // ici on a annee == d.annee , mois == d.mois et jour=d.jour :
        if (getHeure() != d.getHeure()) {
            return getHeure() - d.getHeure();
        }
        // ici on a annee == d.annee , mois == d.mois et jour=d.jour et heure=d.heure:
        return getMinute() - d.getMinute();
    }

    /**
     * @return the jour
     */
    public int getJour() {
        return jour;
    }

    /**
     * @return the mois
     */
    public int getMois() {
        return mois;
    }

    /**
     * @return the annee
     */
    public int getAnnee() {
        return this.annee;
    }

    /**
     * @return the heure
     */
    public int getHeure() {
        return heure;
    }

    /**
     * @return the minute
     */
    public int getMinute() {
        return minute;
    }

    /**
     * @return the valide
     */
    public boolean isValide() {
        return valide;
    }

}
