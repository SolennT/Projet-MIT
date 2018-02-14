/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
            state.setDate(3, birthday);
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
                insert.setDate(3, birthday);
                insert.setString(4, gender.toString());
                insert.setString(5, address);
//                java.util.Date now = new java.util.Date();
//                java.sql.Timestamp nownow = new java.sql.Timestamp(now.getTime());
//                insert.setTimestamp(14, nownow);
                int i = insert.executeUpdate();
                if (i == 1) {
                    j = true;
                    Patient p = new Patient (name, surname, gender, address, birthday);
                    this.getListePatient().add(p);
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

    private static Object getListePatient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public static MedicalStaff creerStaff(String name, String surname, Function function){
        MedicalStaff m=new MedicalStaff(name, surname, function);
        return m;
    }
}
