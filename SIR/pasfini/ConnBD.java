/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sir.nf;


import java.sql.*;


public class ConnBD {
//
//    private static String url = "jdbc:mysql://localhost:3306/epione";
//    private static String user = "java";
//    private static String passwd = "java";
//    private static Connection connect;
    
    private static String url = "jdbc:mysql://mysql-sir-mit.alwaysdata.net:3306/sir-mit_bdd";
    private static String user = "sir-mit_melina";
    private static String passwd = "sir-mit-melina";
    /**
     * @see Connexion
     */
    private static Connection connect;
    
    /**
     * Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
     */
    public static Connection getInstance() {
        if (connect == null) {
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // rajouter un catch qui, en cas d'erreur, ne se connecte juste pas à la 
            // base de données. Demander à nono ou voir sur internet
        }
        return connect;
    }
}