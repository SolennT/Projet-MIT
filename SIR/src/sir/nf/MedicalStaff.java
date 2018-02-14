/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;

/*!
 *
 *  @class MedicalStaff
 *
 *  @brief Classe representant un staff medical.
 *
 */
public class MedicalStaff {

    private String name;
    private String surname;
    private Function function;
    private String identifiant;
    private String mdp;
    private boolean medecin_traitant;

    /*!
         *
         *  @brief Constructeur d'un staff medical.
         *
         *  @param function Fonction du satff medical
         *  @param name Prenom du staff medical
         *  @param surname Nom du satff medical
         *  @param identifiant Identifiant du satff medical
     */
    public MedicalStaff(String identifiant, Function function, String mdp) {
        this.function = function;
        this.name = name;
        this.surname = surname;
        this.identifiant = identifiant;
        this.mdp = mdp;
    }
    public MedicalStaff(String name, String surname, Function function) {
        this.function = function;
        this.name = name;
        this.surname = surname;
        identifiant = name + surname;
    }
    public MedicalStaff(String name, String surname) {
        this.medecin_traitant=true;
        this.name = name;
        this.surname = surname;
        identifiant = name + surname;
    }

    
    public MedicalStaff(String name, String surname, Function function, String mdp) {
        this.function = function;
        this.name = name;
        this.surname = surname;
        identifiant = name + surname;
        this.mdp = mdp;
    }

    MedicalStaff(String name, String surname, String function) {
        this.function = Function.valueOf(function);
        this.name = name;
        this.surname = surname;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @return the function
     */
    public Function getFunction() {
        return function;
    }

    /**
     * @return the identifiant
     */
    public String getIdentifiant() {
        return identifiant;
    }

    /*!
         *
         *  \brief Methode de description du staff medical.
         *
         *  @return Retourne le descriptif du staff medical.
         *
     */
    @Override
    public String toString() {
        return getSurname().toUpperCase() + " " + getName() + ", " + getFunction();
    }
    
    /*!
         *
         *  \brief Methode de test d'egalite de deux staffs medicaux.
         *
         *  @return Retourne true si les deux staffs médicaux sont les memes, false sinon.
         *
         */
    @Override
    public boolean equals(Object o) {
        if (o instanceof MedicalStaff) {
            MedicalStaff m = (MedicalStaff) o;
            return getIdentifiant().equals(m.getIdentifiant());
        } else {
            return false;
        }
    }

}
