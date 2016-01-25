/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.dao;

import com.rudysorto.jpa.AppMoviles;
import com.rudysorto.jpa.Clientes;
import com.rudysorto.jpa.OpcionesAppMoviles;
import com.rudysorto.jpa.ProductoMM;
import com.rudysorto.jpa.Productos;
import com.rudysorto.jpa.RegistrosMM;
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
   
   public List<Clientes> clientesLike(String par);
   
   public List<ProductoMM> productosBodegaVirtual(String par);
   
   public List<RegistrosMM> registrosMMPorVendedor(String par);


    
}
