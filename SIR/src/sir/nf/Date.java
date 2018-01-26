/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;

/*!
 *
 *  @class Date
 *
 *  @brief Classe representant une date composee des jour, mois, annee, heure et minute.
 *
 */
public class Date implements Comparable {

    private int jour;
    private int mois;
    private int annee;
    private int heure;
    private int minute;

    /*!
         *
         *  @brief Constructeur surcharge d'une Date comprenant tous les parametres.
         *
         *  @param jour Jour correspondant a la date.
         *  @param mois Mois correspondant a la date.
         *  @param annee Annee correspondant a la date.
         *  @param heure Heure correspondant a la date.
         *  @param minute Minute correspondant a la date.
     */
    public Date(int jour, int mois, int annee, int heure, int minute) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        this.heure = heure;
        this.minute = minute;
    }

    /*!
         *
         *  @brief Constructeur surcharge d'une Date.
         *
         *  @param jour Jour correspondant a la date.
         *  @param mois Mois correspondant a la date.
         *  @param annee Ann�e correspondant a la date.
     */
    public Date(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
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
        if (jour < 10) {
            s += "0" + jour + "/";
        } else {
            s += jour + "/";
        }
        if (mois < 10) {
            s += "0" + mois + "/";
        } else {
            s += mois + "/";
        }
        s += annee + " à ";
        if (heure < 10) {
            s += "0" + heure + ":";
        } else {
            s += heure + ":";
        }
        if (minute < 10) {
            s += "0" + minute;
        } else {
            s += minute;
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
        if (mois < 10 && jour < 10) {
            return "0" + jour + "/0" + mois + "/" + annee;
        }
        if (mois < 10) {
            return jour + "/0" + mois + "/" + annee;
        }
        if (jour < 10) {
            return "0" + jour + "/" + mois + "/" + annee;
        } else {
            return +jour + "/" + mois + "/" + annee;
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
        if (o instanceof Date) {
            Date d = (Date) o;
            return (annee == d.annee) && (mois == d.mois) && (jour == d.jour) && (heure == d.heure) && (minute == d.minute);
        } else {
            return false;
        }
    }

    // precondition : 'o' est une instance de 'Date' :
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
        Date d = (Date) o;
        if (annee != d.annee) {
            return annee - d.annee;
        }
        // ici on a forcement annee == d.annee :
        if (mois != d.mois) {
            return mois - d.mois;
        }
        // ici on a forcement annee == d.annee et mois == d.mois :
        //return jour - d.jour;
        if (jour != d.jour) {
            return jour - d.jour;
        }
        // ici on a annee == d.annee , mois == d.mois et jour=d.jour :
        if (heure != d.heure) {
            return heure - d.heure;
        }
        // ici on a annee == d.annee , mois == d.mois et jour=d.jour et heure=d.heure:
        return minute - d.minute;
    }

}
