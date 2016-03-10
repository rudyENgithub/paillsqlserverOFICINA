/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.ln;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author rsorto
 */
public class Connectionr {
    
    private static Connectionr instance;
    
       private static Connection connection = null;
        private static String SQL_JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        private static String URL = "jdbc:sqlserver://192.168.16.3\\SILDEGRA;databaseName=V3GrupoPlanillas";

        private static Connectionr singleton = new Connectionr( );
  /* A private Constructor prevents any other 
    * class from instantiating.
    */
   private Connectionr(){ }
   
   /* Static 'instance' method */
   public static Connectionr getInstance( ) {
       if(instance == null){
           instance = new Connectionr();
       }
      return instance;
   }
   /* Other methods protected by singleton-ness */
   public static String conectar(String uid, String password ) {
       
     
       String resp ;
         try {
               if(connection != null){
           connection.close();
            System.out.println("Si habia abierta se cerró");
       }
        Class.forName(SQL_JDBC_DRIVER);// Register jdbc driver
        System.out.println("****Connect to Database****");
        //4. open a connection
        connection =  DriverManager.getConnection(URL, uid, password);
        System.out.println("DataBase connect to: "+ connection.getMetaData().getDriverName());
        System.out.println("URL: "+ connection.getMetaData().getURL());
        resp = "OK";
       // setConnectionClose();
       
        if(connection != null){
           connection.close();
            System.out.println("Cierra la se creo adrede");
       }
    } catch (Exception e) {
        e.printStackTrace();
        System.err.println("Exception in getLocalConeection() "+e.getMessage());
        resp = "ERR";
    }
         return resp;
   }
}
