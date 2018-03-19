/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;

import java.util.ArrayList;

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
    private String mdp;
    private int id;
    private boolean medecin_traitant;

    /*!
         *
         *  @brief Constructeur d'un staff medical.
         *
         *  @param function Fonction du satff medical
         *  @param name Prenom du staff medical
         *  @param surname Nom du satff medical
        
     */
   

    public MedicalStaff(String name, String surname, Function function) {
        this.function = function;
        this.name = name;
        this.surname = surname;
        
    }

    public MedicalStaff(String name, String prenom) {
        this.medecin_traitant = true;
        this.name = name;
        this.surname = prenom;
        this.mdp = "tagada";
    }

    public MedicalStaff(String name, String surname, Function function, String mdp) {
        this.function = function;
        this.name = name;
        this.surname = surname;
        this.mdp = mdp;
    }

    public MedicalStaff(int id, String name, String surname, Function function, String mdp) {
        this.function = function;
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.mdp = mdp;
    }

<<<<<<< HEAD
    MedicalStaff(String name, String surname, String function) {
        this.function = Function.valueOf(function);
        this.name = name;
        this.surname = surname;
    }

    MedicalStaff(int id, String name, String surname, String function) {
        this.id = id;
        this.function = Function.valueOf(function);
        this.name = name;
        this.surname = surname;
    }

    public ArrayList recupPatient() {
        return Factory.getListePatient();
    }

=======
>>>>>>> 31a58b45bd02c9bf3572c85069b991ff81f9cf12
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
     * @return the function (String)
     */
    public String getFunctionStr() {
        return function.name();
    }

  

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the mdp
     */
    public String getMdp() {
        return mdp;
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
            return (getId() == (m.getId()));
        } else {
            return false;
        }
    }

    /**
     * @param function the function to set
     */
    public void setFunction(Function function) {
        this.function = function;
    }

    /**
     * @return the medecin_traitant
     */
    public boolean isMedecin_traitant() {
        return medecin_traitant;
    }
}
