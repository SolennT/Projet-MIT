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
    
    private static String url = "jdbc:mysql://mysql-epione.alwaysdata.net:3306/epione_db";
    private static String user = "epione_db";
    private static String passwd = "java";
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
        }
        return connect;
    }
}