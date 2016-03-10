/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.dao;

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
public interface AppMovilesFacadeLocal {

    void create(AppMoviles appMoviles);

    void edit(AppMoviles appMoviles);

    void remove(AppMoviles appMoviles);

    AppMoviles find(Object id);

    List<AppMoviles> findAll();

    List<AppMoviles> findRange(int[] range);

    int count();
    
   public List<OpcionesAppMoviles> listaAppsPerfil(String par);
   
   public List<OpcionesAppMoviles> listaOpcionesApp(int par);
   
   public List<Productos> productosLike(String par, String id);
   
   public List<Productos> productosPorVendedor(String id);
   
   
   
   public List<Clientes> clientesLike(String par, String idempleado);
   
   public List<ProductoMM> productosBodegaVirtual(String par);
   
   public List<RegistrosMM> registrosMMPorVendedor(String par);


   public List<Vendedores> selectALlEjecutivos();
   
   public List<Vendedores> likeEjecutivos(String par);
   
   public List<RegistrosMMdet> clientesporVendedor(String idempleado);
   
   public List<Productos> productoLikePedido(String par);
   
   public List<Escalas> escalasPorProductos(String par);
   
   public List<Escalas> precioPorEscala(String par, String esca);
   
   public List<Productos> checkexistencias(String par);
   
   public List<Clientes> clientesPedidosLike(String par);
   
   public List<Transacciones> transaccionesmedicosmm(String par);
   
   public List<Doctoress> clientesXVendedor(String par);
   
   
}
//21327476