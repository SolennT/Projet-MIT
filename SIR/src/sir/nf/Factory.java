/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;
<<<<<<< HEAD

import java.sql.*;
=======
>>>>>>> 31a58b45bd02c9bf3572c85069b991ff81f9cf12
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author axelm
 */
public class Factory {
<<<<<<< HEAD

    public static boolean creerPatient(String name, String surname, Gender gender, String address, Dates birthday, int id_SIH) {
        boolean j = false;
        String gend = null;
        //je sais pas si il faut que j'utilise id_patient ou pas, vu que id_patient est généré par la bdd
        //je sais pas non plus comment faire un setGender (enfin l'équivalent, vu que la fonction existe pas
        //et au final, je sais pas trop non plus à quoi sert la première partie du if (à verifier si le patient existe déjà je pense
        try {
            String requete = "SELECT * FROM DMR ";
            requete += " WHERE nom = ?";
            requete += " AND prenom = ?";
            requete += " AND date_naissance = ?";
            requete += " AND id_SIH = ?";

            PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
            state.setString(1, name);
            state.setString(2, surname);
            state.setDate(3, birthday.getSQLDate());
            state.setInt(4, id_SIH);
            state.execute();
            ResultSet res = state.getResultSet();
            if (res.next()) {
                j = false;

            } else {
                String insertion = " INSERT INTO DMR(nom, prenom, date_naissance,"
                        + "genre, adresse, id_SIH) "
                        + " VALUES( ? , ? , ? , ? , ? , ?);";

                PreparedStatement insert = ConnBD.getInstance().prepareStatement(insertion);
                insert.setString(1, name);
                insert.setString(2, surname);
                Date birth = new Date(0);
                birth = birthday.getSQLDate();
                insert.setDate(3, birth);

                insert.setString(4, gender.name());
                insert.setString(5, address);
                insert.setInt(6, id_SIH);
//                java.util.Dates now = new java.util.Dates();
//                java.sql.Timestamp nownow = new java.sql.Timestamp(now.getTime());
//                insert.setTimestamp(14, nownow);
                int i = insert.executeUpdate();
                if (i == 1) {
                    j = true;
                    DMR p = new DMR(name, surname, gender, address, birthday);
                    Factory.getListePatient().add(p);
                }
                insert.close();
            }
            res.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return j;
    }

    public static ArrayList getListePatient() {
        ArrayList<DMR> liste = new ArrayList();
        boolean b = true;
        try {
            String requete = "SELECT * FROM DMR;";
            PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
            state.execute();
            ResultSet res = state.getResultSet();
            res.next();
            while (b) {
                if (!res.isLast()) {

                    int id = res.getInt("id");
                    String name = res.getString("nom");
                    String surname = res.getString("prenom");
                    java.sql.Date birthday = res.getDate("date_naissance");
                    sir.nf.Dates birth = new sir.nf.Dates(birthday);
                    String genre = "";
                    genre = res.getString("genre");
                    String adresse = res.getString("adresse");
                    DMR p = new DMR(name, surname, genre, adresse, birth, id);

                    liste.add(p);
                    res.next();
                } else {

                    int id = res.getInt("id");
                    String name = res.getString("nom");
                    String surname = res.getString("prenom");
                    java.sql.Date birthday = res.getDate("date_naissance");
                    sir.nf.Dates birth = new sir.nf.Dates(birthday);
                    String genre = "";
                    genre = res.getString("genre");
                    String adresse = res.getString("adresse");
                    DMR p = new DMR(name, surname, genre, adresse, birth, id);

                    liste.add(p);
                    b = false;
                }
            }
            state.close();
            res.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liste;
    }

    //créer un exam numérique   
    public static boolean creerExam(int id_patient, Dates date, ExamenType type, MedicalStaff prescripteur, MedicalStaff responsableRadio, int prioritaire) {

        boolean j = false;
        boolean dmr_existant = false;
        ArrayList<DMR> list = new ArrayList();
        list = Factory.getListePatient();
        for (DMR d : list) {
            if (d.getId() == (id_patient)) {
                dmr_existant = true;
            }
        }
        if (dmr_existant) {
            try {
                String requete = "SELECT * FROM Examen ";
                requete += " WHERE id_patient = ?";
                requete += " AND date_examen = ?";
                requete += " AND type_examen = ?;";

                PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
                state.setInt(1, id_patient);
                state.setDate(2, date.getSQLDate());
                state.setString(3, type.name());
                state.execute();
                ResultSet res = state.getResultSet();
                if (res.next()) {
                    j = false;

                } else {
                    //String insertion = "SET FOREIGN_KEY_CHECKS=0;";
                    String insertion = " INSERT INTO Examen(id_patient, date_examen, heures, minutes, type_examen, ph_interprete, superviseur, prioritaire)"
                            // + ", les autres trucs) "
                            + " VALUES( ? , ? , ? , ?, ?, ?, ?, ?, ?);";
//                    String remettrefk = " SET FOREIGN_KEY_CHECKS=1;";
//                    insertion.concat(inserer);
//                    insertion.concat(remettrefk);
                    PreparedStatement insert = ConnBD.getInstance().prepareStatement(insertion);

                    insert.setInt(1, id_patient);
                    insert.setDate(2, date.getSQLDate());
                    insert.setInt(3, date.getHeure());
                    insert.setInt(4, date.getMinute());
                    insert.setString(5, type.name());
                    //bon, ya ce truc, mais je sais pas quoi en faire
                    //updateInstructor = ConnBD.prepareStatement("UPDATE Instructor SET BNUMBER = ?, FIRSTNAME = ?, LASTNAME = ? WHERE BNUMBER = ?");
                    insert.setInt(6, 1); //on pourrait faire un toString() qui donnerait id, nom, prenom, type ?
//                java.util.Dates now = new java.util.Dates();
//                java.sql.Timestamp nownow = new java.sql.Timestamp(now.getTime());
//                insert.setTimestamp(14, nownow);
                    insert.setInt(7, 1);
                    insert.setInt(8, 0);
                    insert.setString(9, "ssgdksldkjsdf");
                    int i = insert.executeUpdate();
                    if (i == 1) {
                        j = true;
//                        Examen exam = new Examen(date, type, responsableRadio, prescripteur, prioritaire);
//                        Factory.getListeExam(id_patient).add(exam);
                    }
                    insert.close();
                }
                res.close();
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            j = false;
        }
        return j;
    }

    //créer un examen non numérique
    public static boolean creerExam(int id_patient, Dates date, ExamenType type, MedicalStaff prescripteur, MedicalStaff responsableRadio, boolean prioritaire, String lienPACS) {

        boolean j = false;
        boolean dmr_existant = false;
        ArrayList<DMR> list = new ArrayList();
        list = Factory.getListePatient();
        for (DMR d : list) {
            if (d.getId() == (id_patient)) {
                dmr_existant = true;
            }
        }
        if (dmr_existant) {
            try {
                String requete = "SELECT * FROM Examen ";
                requete += " WHERE id_patient = ?";
                requete += " AND date_examen = ?";
                requete += " AND type_examen = ?;";

                PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
                state.setInt(1, id_patient);
                state.setDate(2, date.getSQLDate());
                state.setString(3, type.name());
                state.execute();
                ResultSet res = state.getResultSet();
                if (res.next()) {
                    j = false;

                } else {
                    String insertion = " INSERT INTO Examen(id_patient,date_examen, heures, minutes, type_examen, ph_interprete, superviseur,prioritaire, id_pacs,)"
                            // + ", les autres trucs) "
                            + " VALUES( ? , ? , ? , ?, ?, ?, ?, ?, ?);";

                    PreparedStatement insert = ConnBD.getInstance().prepareStatement(insertion);

                    insert.setInt(1, id_patient);
                    insert.setDate(2, date.getSQLDate());
                    insert.setInt(3, date.getHeure());
                    insert.setInt(4, date.getMinute());
                    insert.setString(5, type.name());
                    //bon, ya ce truc, mais je sais pas quoi en faire
                    //updateInstructor = ConnBD.prepareStatement("UPDATE Instructor SET BNUMBER = ?, FIRSTNAME = ?, LASTNAME = ? WHERE BNUMBER = ?");
                    insert.setInt(6, responsableRadio.getId()); //on pourrait faire un toString() qui donnerait id, nom, prenom, type ?
//                java.util.Dates now = new java.util.Dates();
//                java.sql.Timestamp nownow = new java.sql.Timestamp(now.getTime());
//                insert.setTimestamp(14, nownow);
                    insert.setInt(7, responsableRadio.getId());
                    insert.setBoolean(8, prioritaire);
                    insert.setString(9, lienPACS);
                    int i = insert.executeUpdate();
                    if (i == 1) {
                        j = true;
                    }
                    insert.close();
                }
                res.close();
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            j = false;
        }
        return j;
    }

    public static ArrayList getListeExam(int id) {
        ArrayList<Examen> liste = new ArrayList();
        boolean b = true;
        try {
            String requete = "SELECT * FROM Examen WHERE id_patient = ?;";
            PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
            state.setInt(1, id);
            state.execute();
            ResultSet res = state.getResultSet();
            
            while (b && res.next()) {

                if (!res.isLast()) {
                    int id_examen = res.getInt("id_examen");
                    int id_responsableRadio = res.getInt("ph_interprete");
                    String type = res.getString("type_examen");
                    java.sql.Date date = res.getDate("date_examen");
                    int heures = res.getInt("heures");
                    int minutes = res.getInt("minutes");
                    int id_prescripteur = res.getInt("superviseur");
                    String cr = res.getString("compte_rendu");
                    String url = res.getString("id_pacs");
                    String path = res.getString("path");
                    Boolean prio = res.getBoolean("prioritaire");
                    Dates d = new Dates(date, heures, minutes);
                     Examen exam = new Examen(d, id_examen, id, type, id_responsableRadio,id_prescripteur, url, cr, prio, path);
                    liste.add(exam);

                } else {
                    int id_examen = res.getInt("id_examen");
                    int id_responsableRadio = res.getInt("ph_interprete");
                    int id_prescripteur = res.getInt("superviseur");
                    String type = res.getString("type_examen");
                    java.sql.Date date = res.getDate("date_examen");
                    int heures = res.getInt("heures");
                    int minutes = res.getInt("minutes");
                    String cr = res.getString("compte_rendu");
                    String path = res.getString("path");
                    String url = res.getString("id_pacs");
                    Boolean prio = res.getBoolean("prioritaire");
                    Dates d = new Dates(date, heures, minutes);
                    Examen exam = new Examen(d, id_examen, id, type, id_responsableRadio,id_prescripteur, url, cr, prio, path);
                    liste.add(exam);
                    b = false;
                }
            }
            state.close();
            res.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liste;
    }

    public static Examen getExamen(String id) {
        Examen examen = null;
        try {
            String requete = "SELECT * FROM Examen WHERE id_examen = ?";
            PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
            state.setString(1, id);
            state.execute();
            ResultSet res = state.getResultSet();
            res.next();
            int id_examen = res.getInt("id_examen");
            int id_patient = res.getInt("id_patient");
            String id_responsableRadio = res.getString("ph_interprete");
            String type = res.getString("type_examen");
            java.sql.Date date = res.getDate("date_examen");

            //sir.nf.Dates date = new sir.nf.Dates(birthday);
            examen = new Examen(date, id_examen, id_patient, type, id_responsableRadio);
            state.close();
            res.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return examen;
    }

    public static DMR getPatient(int id) {
        DMR pat = null;
        try {
            String requete = "SELECT * FROM DMR WHERE id = ?";
            PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
            state.setInt(1, id);
            state.execute();
            ResultSet res = state.getResultSet();
            res.next();
            String name = res.getString("nom");
            String surname = res.getString("prenom");
            java.sql.Date birthday = res.getDate("date_naissance");
            sir.nf.Dates birth = new sir.nf.Dates(birthday);
            String genre = "";
            genre = res.getString("genre");
            String adresse = res.getString("adresse");

            //sir.nf.Dates date = new sir.nf.Dates(birthday);
            pat = new DMR(name, surname, genre, adresse, birth, id);
            state.close();
            res.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pat;
    }

=======
    public static DMR creerDMR(Patient p){
        DMR dmr = new DMR(p);
        return dmr;
    }  
    public static Patient creerPatient(String name, String surname, Gender gender, String address, Date birthday){
        Patient p = new Patient (name, surname, gender, address, birthday);
        return p;
    }
    public static Examen creerExam(Date date, ExamenType type, MedicalStaff prescripteur, MedicalStaff resposableRadio){
        Examen exam = new Examen(date, type, prescripteur,resposableRadio);
        return exam;
    }
    
>>>>>>> 31a58b45bd02c9bf3572c85069b991ff81f9cf12
//    public static Examen creerExam(ExamenType type, MedicalStaff prescripteur, MedicalStaff resposableRadio){
//        DateFormat dateFormat = new SimpleDateFormat();
//        Calendar date = Calendar.getInstance();
//        Examen e = new Examen(date, type,resposableRadio);
//        return e;
//    }
<<<<<<< HEAD
    public static boolean creerStaff(String name, String prenom) {
        boolean j = false;
        Function statut = Function.Exterieur;
        try {
            String requete = "SELECT * FROM Personnel ";
            requete += " WHERE nom = ?";
            requete += " AND prenom = ?";
            requete += " AND statut= ?;";

            PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
            state.setString(1, name);
            state.setString(2, prenom);
            state.setString(3, statut.name());
            state.execute();
            ResultSet res = state.getResultSet();
            if (res.next()) {
                j = false;

            } else {
                String insertion = " INSERT INTO Personnel(nom, prenom, statut, mdp) "
                        + " VALUES( ? ,?, ?, ?);";

                PreparedStatement insert = ConnBD.getInstance().prepareStatement(insertion);
                insert.setString(1, name);
                insert.setString(2, prenom);
                insert.setString(3, statut.name());
                insert.setString(4, "tagada");
//                java.util.Dates now = new java.util.Dates();
//                java.sql.Timestamp nownow = new java.sql.Timestamp(now.getTime());
//                insert.setTimestamp(14, nownow);
                int i = insert.executeUpdate();
                if (i == 1) {
                    j = true;
                    MedicalStaff medecin = new MedicalStaff(name, prenom);
                    Factory.getListeMedecin().add(medecin);
                }
                insert.close();
            }
            res.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return j;

    }

    public static boolean creerStaff(String name, String surname, Function function) {
        boolean j = false;
        try {
            String requete = "SELECT * FROM Personnel ";
            requete += " Where nom = ?";
            requete += " AND prenom = ?";
            requete += " AND statut= ?";

            PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
            state.setString(1, name);
            state.setString(2, surname);
            state.setString(3, function.name());
            state.execute();
            ResultSet res = state.getResultSet();
            if (res.next()) {
                j = false;

            } else {
                String insertion = " INSERT INTO Personnel(nom, prenom, statut) "
                        + " VALUES( ? , ? , ?);";

                PreparedStatement insert = ConnBD.getInstance().prepareStatement(insertion);
                insert.setString(1, name);
                insert.setString(2, surname);
                insert.setString(3, function.name());
//                java.util.Dates now = new java.util.Dates();
//                java.sql.Timestamp nownow = new java.sql.Timestamp(now.getTime());
//                insert.setTimestamp(14, nownow);
                int i = insert.executeUpdate();
                if (i == 1) {
                    j = true;
                }
                insert.close();
            }
            res.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return j;

    }

    public static boolean ecrireCRPACS(int id_patient, int id_examen, String cr, String url) {
        boolean j = false;
        try {
            //ajouter un if compte_rendu et url sont vide
            String requete = "SELECT * FROM Examen ";
            requete += " Where id_patient = ?";
            requete += " AND id_examen = ?";
            requete += " AND compte_rendu = ?";
            requete += " AND id_pacs = ?;";

            PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
            state.setInt(1, id_patient);
            state.setInt(2, id_examen);
            state.setString(3, null);
            state.setString(4, null);

            state.execute();
            ResultSet res = state.getResultSet();
            if (res.next()) {
                j = false;

            } else {
                String insertion = " UPDATE Examen SET compte_rendu = ?, id_pacs = ? WHERE id_examen = ? ;";

                PreparedStatement insert = ConnBD.getInstance().prepareStatement(insertion);
                insert.setString(1, cr);
                insert.setString(2, url);
                insert.setInt(3, id_examen);
//                java.util.Dates now = new java.util.Dates();
//                java.sql.Timestamp nownow = new java.sql.Timestamp(now.getTime());
//                insert.setTimestamp(14, nownow);
                int i = insert.executeUpdate();
                if (i == 1) {
                    j = true;
                }
                insert.close();
            }
            res.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return j;
    }

    public static boolean ecrireCR(int id_patient, int id_examen, String cr) {
        boolean j = false;
        try {
            //ajouter un if compte_rendu et url sont vide
            String requete = "SELECT * FROM Examen ";
            requete += " Where id_patient = ?";
            requete += " AND id_examen = ?";
            requete += " AND compte_rendu = ?";

            PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
            state.setInt(1, id_patient);
            state.setInt(2, id_examen);
            state.setString(3, null);

            state.execute();
            ResultSet res = state.getResultSet();
            if (res.next()) {
                j = false;

            } else {
                String insertion = " UPDATE Examen SET compte_rendu = ? WHERE id_examen = ? ;";

                PreparedStatement insert = ConnBD.getInstance().prepareStatement(insertion);
                insert.setString(1, cr);
                insert.setInt(2, id_examen);
//                java.util.Dates now = new java.util.Dates();
//                java.sql.Timestamp nownow = new java.sql.Timestamp(now.getTime());
//                insert.setTimestamp(14, nownow);
                int i = insert.executeUpdate();
                if (i == 1) {
                    j = true;
                }
                insert.close();
            }
            res.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return j;
    }
    
    public static boolean ajouterPath(int id_patient, int id_examen, String path) {
        boolean j = false;
        try {
            //ajouter un if compte_rendu et url sont vide
            String requete = "SELECT * FROM Examen ";
            requete += " Where id_patient = ?";
            requete += " AND id_examen = ?";
            requete += " AND path = ?";

            PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
            state.setInt(1, id_patient);
            state.setInt(2, id_examen);
            state.setString(3, null);

            state.execute();
            ResultSet res = state.getResultSet();
            if (res.next()) {
                j = false;

            } else {
                String insertion = " UPDATE Examen SET path = ? WHERE id_examen = ? ;";

                PreparedStatement insert = ConnBD.getInstance().prepareStatement(insertion);
                insert.setString(1, path);
                insert.setInt(2, id_examen);
                int i = insert.executeUpdate();
                if (i == 1) {
                    j = true;
                }
                insert.close();
            }
            res.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return j;
    }

    public static ArrayList getListeMedecin() {
        ArrayList<MedicalStaff> liste = new ArrayList();
        boolean b = true;
        try {
            String requete = "SELECT * FROM Personnel";
            PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
            state.execute();
            ResultSet res = state.getResultSet();
            res.next();
            while (b) {
                if (!res.isLast()) {
                    String name = res.getString("nom");
                    String surname = res.getString("prenom");
                    String function = res.getString("statut");
                    int id_personnel = res.getInt("id_personnel");

                    String mdp = res.getString("mdp");
                    Function statut = Function.valueOf(function);
                    MedicalStaff m = new MedicalStaff(id_personnel, name, surname, statut, mdp);
                    liste.add(m);
                    res.next();
                } else {
                    String name = res.getString("nom");
                    String surname = res.getString("prenom");
                    String function = res.getString("statut");
                    int id_personnel = res.getInt("id_personnel");

                    String mdp = res.getString("mdp");
                    Function statut = Function.valueOf(function);
                    MedicalStaff m = new MedicalStaff(id_personnel, name, surname, statut, mdp);
                    liste.add(m);
                    b = false;
                }

            }
            state.close();
            res.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liste;
=======
    public static MedicalStaff creerStaff(String name, String surname, Function function){
        MedicalStaff m=new MedicalStaff(name, surname, function);
        return m;
>>>>>>> 31a58b45bd02c9bf3572c85069b991ff81f9cf12
    }

    public static ArrayList<DMR> rechercheListID(ArrayList<DMR> listPatients, int id) {
        ArrayList<DMR> trie = new ArrayList<DMR>();
        for (DMR p : listPatients) {
            if (p.getId() == id) {
                trie.add(p);
            }
        }
        return trie;
    }

    public static ArrayList<DMR> rechercheListGenre(ArrayList<DMR> listPatients, Gender g) {
        ArrayList<DMR> trie = new ArrayList<DMR>();
        for (DMR p : listPatients) {
            if (p.getGender().equals(g)) {
                trie.add(p);
            }
        }
        return trie;
    }

    public static ArrayList<DMR> rechercheListNom(ArrayList<DMR> listPatients, String nom, String prenom) {
        ArrayList<DMR> trie = new ArrayList<DMR>();
        if (prenom == null) {
            for (DMR p : listPatients) {
                if (p.getName().equals(nom)) {
                    trie.add(p);
                }
            }
        } else {
            if (nom == null) {
                for (DMR p : listPatients) {
                    if (p.getSurname().equals(prenom)) {
                        trie.add(p);
                    }
                }
            } else {
                for (DMR p : listPatients) {
                    if (p.getName().equals(nom) && p.getSurname().equals(prenom)) {
                        trie.add(p);
                    }
                }
            }

        }
        return trie;
    }

    public static ArrayList<DMR> rechercheListDate(ArrayList<DMR> listPatients, Dates d) {
        ArrayList<DMR> trie = new ArrayList<DMR>();
        for (DMR p : listPatients) {
            if (p.getBirthday().equals(d)) {
                trie.add(p);
            }
        }
        return trie;
    }

    public static ArrayList<Examen> rechercheListDateExam(ArrayList<Examen> listeExam, Dates dateE) {
        ArrayList<Examen> newlisteExam = new ArrayList<Examen>();
        for (int i = 0; i < listeExam.size(); i++) {
            if (listeExam.get(i).getDate().equals(dateE)) {
                newlisteExam.add(listeExam.get(i));
            }
        }
        return newlisteExam;
    }

    public static ArrayList<Examen> rechercheListTypeExam(ArrayList<Examen> listeExam, ExamenType e) {
        ArrayList<Examen> newlisteExam = new ArrayList<Examen>();
        for (int i = 0; i < listeExam.size(); i++) {
            if (listeExam.get(i).getExamenType().equals(e)) {
                newlisteExam.add(listeExam.get(i));
            }
        }
        return newlisteExam;
    }

    public static ArrayList<Examen> rechercheListIDExam(ArrayList<Examen> listeExam, int id) {
        ArrayList<Examen> newlisteExam = new ArrayList<Examen>();
        for (int i = 0; i < listeExam.size(); i++) {
            if (listeExam.get(i).getId_examen() == id) {
                newlisteExam.add(listeExam.get(i));
            }
        }
        return newlisteExam;
    }

    public static MedicalStaff rechercheMedicalStaff(String nom) {
        MedicalStaff m = null;
        ArrayList<MedicalStaff> listeMed = getListeMedecin();
        int i = 0;
        while (i < listeMed.size() && m == null) {
            if (listeMed.get(i).getName() == nom) {
                m = listeMed.get(i);
            }
            i++;
        }
        return m;
    }
    public static MedicalStaff rechercheMedicalStaffId(int id) {
        MedicalStaff m = null;
        ArrayList<MedicalStaff> listeMed = getListeMedecin();
        int i = 0;
        while (i < listeMed.size() && m == null) {
            if (listeMed.get(i).getId() == id) {
                m = listeMed.get(i);
            }
            i++;
        }
        return m;
    }

}
