/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;
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
    public static Patient creerPatient(String name, String surname, Gender gender, String address, Date birthday){
        Patient p = new Patient (name, surname, gender, address, birthday);
        return p;
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
