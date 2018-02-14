/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
/**
 *
 * @author axelm
 */
public class Factory {
    public static DMR creerDMR(Patient p){
        DMR dmr = new DMR(p);
        return dmr;
    }  
    public static boolean creerPatient(String name, String surname, Gender gender, String address, Date birthday){
        boolean j = false;
        try {
            String requete = "SELECT * FROM dpi ";
            requete += " AND nomdenaissance = ?";
            requete += " AND prenom = ?";
            requete += " AND datedenaissance = ?";

            PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
            state.setString(1, name);
            state.setString(2, surname);
            state.setDate(3, birthday.getSQLDate());
            state.execute();
            ResultSet res = state.getResultSet();
            if (res.next()) {
                j = false;

            } else {
                String insertion = " INSERT INTO dpi(nom, prenom, datedenaissance,"
                        + "genre, adresse) "
                        + " VALUES( ? , ? , ? , ? , ? );";

                PreparedStatement insert = ConnBD.getInstance().prepareStatement(insertion);
                insert.setString(1, name);
                insert.setString(2, surname);
                insert.setDate(3, birthday.getSQLDate());
                insert.setString(4, gender.toString());
                insert.setString(5, address);
//                java.util.Date now = new java.util.Date();
//                java.sql.Timestamp nownow = new java.sql.Timestamp(now.getTime());
//                insert.setTimestamp(14, nownow);
                int i = insert.executeUpdate();
                if (i == 1) {
                    j = true;
                    Patient p = new Patient (name, surname, gender, address, birthday);
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

    private static ArrayList getListePatient() {
        ArrayList<Patient> liste = new ArrayList();
        try {
            String requete = "SELECT * FROM patient";
            PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
            state.execute();
            ResultSet res = state.getResultSet();
            res.next();
            String name = res.getString("nom");
            String surname = res.getString("prenom");
            java.sql.Date birthday = res.getDate("datedenaissance");
            sir.nf.Date birth = new sir.nf.Date(birthday);
            String genre = "";
            genre = res.getString("genre");
            String adresse = res.getString("adresse");
            String id = res.getString("Id");
            Patient p = new Patient (name,surname,genre,adresse,birth);
            liste.add(p);
            state.close();
            res.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liste;
    }
      
    
    public static Examen creerExam(Date date, ExamenType type, MedicalStaff prescripteur, MedicalStaff resposableRadio){
        Examen exam = new Examen(date, type, prescripteur,resposableRadio);
        return exam;
    }
    
//    public static Examen creerExam(ExamenType type, MedicalStaff prescripteur, MedicalStaff resposableRadio){
//        DateFormat dateFormat = new SimpleDateFormat();
//        Calendar date = Calendar.getInstance();
//        Examen e = new Examen(date, type, prescripteur,resposableRadio);
//        return e;
//    }
    public static boolean creerStaff(String name, String surname, Function function){
        boolean j = false;
        try {
            String requete = "SELECT * FROM dpi ";
            requete += " AND nomdenaissance = ?";
            requete += " AND prenom = ?";
            requete += " AND fonction= ?";

            PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
            state.setString(1, name);
            state.setString(2, surname);
            state.setString(3, function.name());
            state.execute();
            ResultSet res = state.getResultSet();
            if (res.next()) {
                j = false;

            } else {
                String insertion = " INSERT INTO dpi(nom, prenom, fonction) "
                        + " VALUES( ? , ? , ?);";

                PreparedStatement insert = ConnBD.getInstance().prepareStatement(insertion);
                insert.setString(1, name);
                insert.setString(2, surname);
                insert.setString(3, function.name());
//                java.util.Date now = new java.util.Date();
//                java.sql.Timestamp nownow = new java.sql.Timestamp(now.getTime());
//                insert.setTimestamp(14, nownow);
                int i = insert.executeUpdate();
                if (i == 1) {
                    j = true;
                    MedicalStaff medecin = new MedicalStaff(name,surname,function);
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

    private static ArrayList getListeMedecin() {
                ArrayList<MedicalStaff> liste = new ArrayList();
        try {
            String requete = "SELECT * FROM personnel";
            PreparedStatement state = ConnBD.getInstance().prepareStatement(requete);
            state.execute();
            ResultSet res = state.getResultSet();
            res.next();
            String name = res.getString("nom");
            String surname = res.getString("prenom");
            String function = res.getString("fonction");
            MedicalStaff m = new MedicalStaff (name,surname,function);
            liste.add(m);
            state.close();
            res.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liste;
    }
}
