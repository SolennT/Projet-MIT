/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;

/*!
 *
 *  @class Patient
 *
 *  @brief Classe representant un patient.
 *
 */
public class Patient {

    private String id;
    private String name;
    private String surname;
    private Gender gender;
    private String address;
    private Date birthday;

    /*!
         *
         *  @brief Constructeur surcharge d'un Patient.
         *
         *  @param nom Nom du patient
         *  @param prenom Prenom du patient
         *  @param genre Genre du patient
         *  @param adresse Adresse du patient
         *  @param birthday Date de naissance du patient
     */
    public Patient(String name, String surname, Gender gender, String address, Date birthday) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
    }
    

    /**
     * @return the id
     * on donne son numéro de patient par ordre chronologique 
     * exemple : c'est le 18ème patient enregistré dans la BDD,
     * donc son id sera 18.
     */
    
    private String creerId(){
        //on a besoin de la classe lectureSQL 
        return id;
    }
    
    public String getId() {
        return id;
    }

    /*!
         *
         *  @brief Methode de comparaison de deux patients
         *
         *  @param o Object
         *
         *  @return Retourne true si les deux patients sont egaux, false sinon.
         *
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Patient) {
            Patient p = (Patient) o;
            return getId().equals(p.getId());
        } else {
            return false;
        }
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
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

}
