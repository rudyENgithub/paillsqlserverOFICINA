/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.ws;

import com.rudysorto.ln.Connectionr;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author rsorto
 */
@WebService(serviceName = "LoginWS")
public class LoginWS {
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
   @WebMethod(operationName = "login")
    public String login(@WebParam(name = "uid") String uid, @WebParam(name = "password") String password) {
       String resp;
       Connectionr conex = Connectionr.getInstance() ;
       resp = conex.conectar(uid, password);
       /*  try {
        Class.forName(SQL_JDBC_DRIVER);// Register jdbc driver
        System.out.println("****Connect to Database****");
        //4. open a connection
        connection = DriverManager.getConnection(URL, uid, password);
        System.out.println("DataBase connect to: "+ connection.getMetaData().getDriverName());
        System.out.println("URL: "+ connection.getMetaData().getURL());
        resp = "OK";
       // setConnectionClose();
        System.out.println("Database Connection Closed");
    } catch (Exception e) {
        e.printStackTrace();
        System.err.println("Exception in getLocalConeection() "+e.getMessage());
        resp = "ERR";
    }*/
        
        return resp;
    }
}
