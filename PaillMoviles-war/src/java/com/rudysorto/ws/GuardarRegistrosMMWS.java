/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.ws;

import com.rudysorto.jpa.RegistrosMMdet;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

/**
 *
 * @author rsorto
 */
@WebService(serviceName = "GuardarRegistrosMMWS")
public class GuardarRegistrosMMWS {

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
    @WebMethod(operationName = "guardarRegistrosMM")
     public String guardarRegistrosMM(@WebParam(name = "detalles") String detalles)  {
   // public String guardarRegistrosMM(@WebParam(name = "detalles") ArrayList<RegistrosMMdet> detalles)  {
        try {
            //TODO write your implementation code here:
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       

    Connection con = null;
   
            con = DriverManager.getConnection("jdbc:sqlserver://192.168.16.3\\SILDEGRA;databaseName=V3GrupoPlanillas",
     "rsorto", "Paill999");
        

    CallableStatement proc_stmt = null;
          String res = null;
          JSONArray jsonarr = null;
 
          //  jsonarr = new JSONArray("[{\"IdProducto\":3216, \"Cantidad\":24, \"Notas\":\"ee\"}, {\"IdProducto\":3216, \"Cantidad\":78, \"Notas\":\"ee\"}] ");
             jsonarr = new JSONArray( detalles);

    StringBuilder sqlBuilder = new StringBuilder("DECLARE @RegistrosMMdett dbo.RegistrosMMdet;");
        sqlBuilder.append("DECLARE @IdRegMM INT;");
        
        for (int i = 0; i <  jsonarr.length(); ++i) {
        sqlBuilder.append(
            "INSERT INTO @RegistrosMMdett (IdProducto, Cantidad, Notas) VALUES(?, ?, ?);");
    }
        
        
        
      //  sqlBuilder.append("INSERT INTO @RegistrosMMdett VALUES('3216',25,'le faltan la mitad', GETDATE());");
      //  sqlBuilder.append("INSERT INTO @RegistrosMMdett VALUES('3057',50,'le entregue mas de lo acordado', GETDATE());");
    //EXEC dbo.RegistrosMMInsert '1122','1133',  '-20.1225','89.45566', 'notas master', @RegistrosMMdet,@IdRegMM OUTPUT;
        sqlBuilder.append("EXEC [dbo].[RegistrosMMInsert] '1122' ,'1133',  '-20.1225','89.45566', 'notas master', @RegistrosMMdett, @IdRegMM OUTPUT;");
        PreparedStatement stmt = con.prepareStatement(sqlBuilder.toString());
   for (int i = 0; i <  jsonarr.length(); ++i) {
       JSONObject jsonobj = null;          
                  jsonobj = jsonarr.getJSONObject(i);
                  
        stmt.setString(i * 2 + 1, jsonobj.getString("IdProducto") );
        stmt.setString(i * 2 + 2,  jsonobj.getString("Cantidad") );
        stmt.setString(i * 2 + 3, jsonobj.getString("Notas") );

    }
    
        ResultSet resultSet = stmt.executeQuery();
    resultSet.close();    
          //  proc_stmt = con.prepareCall("{ call guardarRegistroMM() }");
       

  //  proc_stmt.setString(1, "employee");
    ResultSet rs = null;
            rs = proc_stmt.executeQuery();
       
     
            if (rs.next()) {
              //int employeeId = rs.getInt(1);
             // System.out.println("Generated employeeId: " + employeeId);
                System.out.println("OK");
            } else {
              //System.out.println("Stored procedure couldn't generate new Id");
                System.out.println("ERROR");
            }
     
        
         } catch (ClassNotFoundException ex) {
            Logger.getLogger(GuardarRegistrosMMWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GuardarRegistrosMMWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(GuardarRegistrosMMWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return detalles;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "decodejson")
    public String decodejson(@WebParam(name = "json") String json) {
        //TODO write your implementation code here:
        String res = null;
          JSONArray jsonarr = null;
        try {
          //  jsonarr = new JSONArray("[{\"IdProducto\":3216, \"Cantidad\":24, \"Notas\":\"ee\"}, {\"IdProducto\":3216, \"Cantidad\":78, \"Notas\":\"ee\"}] ");
             jsonarr = new JSONArray( json);
    for(int i = 0; i < jsonarr.length(); i++){
    JSONObject jsonobj = null;          
                  jsonobj = jsonarr.getJSONObject(i);
                  // get course_slug
                  String str_course_slug=jsonobj.getString("IdProducto");
                  // get course_description
                  String str_course_description=jsonobj.getString("Cantidad");
                  res += jsonobj.getString("Cantidad");
                   //... for other elements         
    }
    
     } catch (JSONException ex) {
            Logger.getLogger(GuardarRegistrosMMWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return res;
    }


   
   
}
