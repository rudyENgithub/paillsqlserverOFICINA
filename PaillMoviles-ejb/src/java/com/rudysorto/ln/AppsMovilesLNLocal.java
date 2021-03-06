/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.ln;

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
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rsorto
 */
@Local
public interface AppsMovilesLNLocal {
    public void guardar(AppMoviles producto);

    public void eliminar(AppMoviles producto);

    public void actualizar(AppMoviles producto);

    public List<AppMoviles> selectAll();

    public List<OpcionesAppMoviles> selectLike(String par);
    
    public List<OpcionesAppMoviles> selectOpcionesXapp(int par);
    
    public List<Productos> productosLike(String par, String id);
    
     public List<Clientes> clientesLike(String par, String IdEmpleado);
     public List<Clientes> clientesPedidoLike(String par);
     
     
     public List<ProductoMM> productosBodega(String par);
     
     public List<RegistrosMM> registrosMMPorVendedor(String par);
     
     public List<Vendedores> selectAllEjecutivos();
     
     public List<Vendedores> likeEjecutivos(String par);
     
      public List<RegistrosMMdet> clientesporvendedor(String idvendedor);
     
     public String login(String uid, String password);
     
     public List<Productos> productoLikePedido(String par);
     
     public List<Escalas> escalaPorProducto(String par);
     
     public List<Productos> checkexistencias(String par);
     
     public List<Productos> productosPorVendedor(String par);
     
       public List<Transacciones> transaccionesmedicosmm(String par);
       
     public List<Doctoress> clientesXVendedor(String par);  
     
   public List<Escalas> precioPorEscala(String par, String esca);  
}
