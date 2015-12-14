/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.ws;

import com.rudysorto.jpa.AppMoviles;
import com.rudysorto.ln.AppsMovilesLNLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author rsorto
 */
@WebService(serviceName = "AppsMovilesWS")
public class AppsMovilesWS {
    @EJB
    private AppsMovilesLNLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "guardar")
    @Oneway
    public void guardar(@WebParam(name = "producto") AppMoviles producto) {
        ejbRef.guardar(producto);
    }

    @WebMethod(operationName = "eliminar")
    @Oneway
    public void eliminar(@WebParam(name = "producto") AppMoviles producto) {
        ejbRef.eliminar(producto);
    }

    @WebMethod(operationName = "actualizar")
    @Oneway
    public void actualizar(@WebParam(name = "producto") AppMoviles producto) {
        ejbRef.actualizar(producto);
    }

    @WebMethod(operationName = "selectAll")
    public List<AppMoviles> selectAll() {
        return ejbRef.selectAll();
    }

    @WebMethod(operationName = "selectLike")
    public List<AppMoviles> selectLike(@WebParam(name = "par") String par) {
        return ejbRef.selectLike(par);
    }
    
}
