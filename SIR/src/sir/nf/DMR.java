/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;

import java.util.ArrayList;

/*!
 *
 *  @class DMR
 *
 *  @brief Classe representant un patient.
 *
 */
public class DMR {

    private int id; //id crée auto
    private String name;
    private String surname;
    private Gender gender;
    private String address;
    private Dates birthday;
    private ArrayList<Examen> listExamens;
    private int ipp;

    /*!
         *
         *  @brief Constructeur surcharge d'un DMR.
         *
         *  @param nom Nom du patient
         *  @param prenom Prenom du patient
         *  @param genre Genre du patient
         *  @param adresse Adresse du patient
         *  @param birthday Dates de naissance du patient
     */
    public DMR(String name, String surname, Gender gender, String address, Dates birthday) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;

    }

    public DMR(String name, String surname, Gender gender, String address, Dates birthday, int id, int ipp) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
        this.ipp = ipp;
        this.id = id;

    }

    public DMR(String name, String surname, Gender gender, String address, Dates birthday, int id) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
        this.id = id;
    }

    public DMR(String name, String surname, String gender, String address, Dates birthday, int id) {
        this.name = name;
        this.surname = surname;
        this.gender = Gender.valueOf(gender);
        this.address = address;
        this.birthday = birthday;
        this.id = id;
    }

    public DMR(String name, String surname, String gender, String address, Dates birthday) {
        this.name = name;
        this.surname = surname;
        this.gender = Gender.valueOf(gender);
        this.address = address;
        this.birthday = birthday;
    }

    public DMR(String name, String surname, String gender, String address, Dates birthday, int id, int ipp) {
        this.name = name;
        this.surname = surname;
        this.gender = Gender.valueOf(gender);
        this.address = address;
        this.birthday = birthday;
        this.id = id;
    }

    /**
     * @return the id on donne son numéro de patient par ordre chronologique
     * exemple : c'est le 18ème patient enregistré dans la BDD, donc son id sera
     * 18.
     */
//    
//    public void creerExamen(ArrayList<Examen> list){
//        
//    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
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
    public Dates getBirthday() {
        return birthday;
    }

    public ArrayList<Examen> recupExamen() {
        return Factory.getListeExam(this.id);
    }

    public ArrayList<Examen> rechercheListType(ExamenType type) {
        ArrayList<Examen> trie = new ArrayList<Examen>();
        for (Examen e : this.recupExamen()) {
            if (e.getExamenType().equals(type)) {
                trie.add(e);
            }
        }
        return trie;
    }

    public Dates dernierExamen() {
        ArrayList<Examen> exams = new ArrayList();
        exams = this.recupExamen();
        Dates d = null;
        if (!exams.isEmpty()) {
            d = exams.get(0).getDate();
            for (Examen e : this.recupExamen()) {
                if (d.compareTo(e.getDate()) < 0) {
                    d = e.getDate();
                }
            }
        }

        return d;
    }

    public ArrayList<Examen> rechercheListDate(int jour, int mois, int annee) {
        ArrayList<Examen> trie = new ArrayList<Examen>();
        Dates d = new Dates(jour, mois, annee);
        for (Examen e : this.recupExamen()) {
            if (e.getDate().equals(d)) {
                trie.add(e);
            }
        }
        return trie;
    }

    public Examen rechercheExam(String idExam) {
        Examen e = null;
        int i = 0;
        while (i < listExamens.size() && e == null) {
            if (listExamens.get(i).getId_examen() == idExam) {
                e = listExamens.get(i);
            }
        }
        return e;
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
        if (o instanceof DMR) {
            DMR p = (DMR) o;
            return getId() == (p.getId());
        } else {
            return false;
        }
    }

}
