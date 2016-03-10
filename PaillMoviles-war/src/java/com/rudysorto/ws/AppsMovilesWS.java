/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.ws;

import com.rudysorto.jpa.AppMoviles;
import com.rudysorto.jpa.Clientes;
import com.rudysorto.jpa.Clientesfv;
import com.rudysorto.jpa.Doctoress;
import com.rudysorto.jpa.Escalas;
import com.rudysorto.jpa.Vendedores;
import com.rudysorto.jpa.OpcionesAppMoviles;
import com.rudysorto.jpa.ProductoMM;
import com.rudysorto.jpa.Productos;
import com.rudysorto.jpa.RegistrosMM;
import com.rudysorto.jpa.RegistrosMMdet;
import com.rudysorto.jpa.Transacciones;
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
    public List<OpcionesAppMoviles> selectLike(@WebParam(name = "par") String par) {
        return ejbRef.selectLike(par);
    }

    @WebMethod(operationName = "selectOpcionesXapp")
    public List<OpcionesAppMoviles> selectOpcionesXapp(@WebParam(name = "par") int par) {
        return ejbRef.selectOpcionesXapp(par);
    }
    
    @WebMethod(operationName = "productosLike")
    public List<Productos> productosLike(@WebParam(name = "par") String par, @WebParam(name = "id") String id) {
        return ejbRef.productosLike(par, id);
    }
    
      @WebMethod(operationName = "clientesLike")
    public List<Clientes> clientesLike(@WebParam(name = "par") String par,  @WebParam(name = "IdEmpleado") String IdEmpleado) {
        return ejbRef.clientesLike(par, IdEmpleado);
    }
      
         @WebMethod(operationName = "productosBodega")
    public List<ProductoMM> productosBodega(@WebParam(name = "par") String par) {
        return ejbRef.productosBodega(par);
    }
         
               @WebMethod(operationName = "registrosMMPorVendedor")
    public List<RegistrosMM> registrosMMPorVendedor(@WebParam(name = "par") String par) {
        return ejbRef.registrosMMPorVendedor(par);
    }
               
                           @WebMethod(operationName = "selectAllEjecutivos")
    public List<Vendedores> selectAllEjecutivos() {
        return ejbRef.selectAllEjecutivos();
    }

                           
                                    @WebMethod(operationName = "likeEjecutivos")
    public List<Vendedores> likeEjecutivos(@WebParam(name = "par") String par) {
        return ejbRef.likeEjecutivos(par);
    }
 
                              @WebMethod(operationName = "clientesporvendedor")
    public List<RegistrosMMdet> clientesporvendedor(@WebParam(name = "idvendedor") String idvendedor) {
        return ejbRef.clientesporvendedor(idvendedor);
    }
    
                              
    @WebMethod(operationName = "productoLikePedido")
    public List<Productos> productoLikePedido(@WebParam(name = "par") String par) {
        return ejbRef.productoLikePedido(par);
    }
    
     @WebMethod(operationName = "escalaPorProducto")
    public List<Escalas> escalaPorProducto(@WebParam(name = "par") String par) {
        return ejbRef.escalaPorProducto(par);
    }
     
      @WebMethod(operationName = "checkexistencias")
    public List<Productos> checkexistencias(@WebParam(name = "par") String par) {
        return ejbRef.checkexistencias(par);
    }
      
      
       @WebMethod(operationName = "clientesPedidosLike")
    public List<Clientes> clientesPedidosLike(@WebParam(name = "par") String par) {
        return ejbRef.clientesPedidoLike(par);
    }
       
        @WebMethod(operationName = "productosPorVendedor")
    public List<Productos> productosPorVendedor(@WebParam(name = "par") String par) {
        return ejbRef.productosPorVendedor(par);
    }
        
         @WebMethod(operationName = "transaccionesmedicosmm")
    public List<Transacciones> transaccionesmedicosmm(@WebParam(name = "par") String par) {
        return ejbRef.transaccionesmedicosmm(par);
    }
         
    @WebMethod(operationName = "clientesXVendedor")
    public List<Doctoress> clientesXVendedor(@WebParam(name = "par") String par) {
        return ejbRef.clientesXVendedor(par);
    }
    
    
              @WebMethod(operationName = "precioPorEscala")
    public List<Escalas> precioPorEscala(@WebParam(name = "par") String par,  @WebParam(name = "esca") String esca) {
        return ejbRef.precioPorEscala(par, esca);
    }
              
              
}
