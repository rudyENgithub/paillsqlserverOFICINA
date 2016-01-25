/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.ln;

import com.rudysorto.dao.AppMovilesFacade;
import com.rudysorto.dao.AppMovilesFacadeLocal;
import com.rudysorto.jpa.AppMoviles;
import com.rudysorto.jpa.Clientes;
import com.rudysorto.jpa.OpcionesAppMoviles;
import com.rudysorto.jpa.ProductoMM;
import com.rudysorto.jpa.Productos;
import com.rudysorto.jpa.RegistrosMM;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author rsorto
 */
@Stateful
public class AppsMovilesLN implements AppsMovilesLNLocal {
    @EJB
    private AppMovilesFacadeLocal appMovilesFacade;


    @Override
    public void guardar(AppMoviles appmovil) {
        appMovilesFacade.create(appmovil);
    }

    @Override
    public void eliminar(AppMoviles appmovil) {
        appMovilesFacade.remove(appmovil);
       
    }

    @Override
    public void actualizar(AppMoviles appmovil) {
        appMovilesFacade.edit(appmovil);
    }

    @Override
    public List<AppMoviles> selectAll() {
        return appMovilesFacade.findAll();
    }

   
    @Override
    public List<OpcionesAppMoviles> selectLike(String par) {
        return appMovilesFacade.listaAppsPerfil(par);
       
    }

    @Override
    public List<OpcionesAppMoviles> selectOpcionesXapp(int par) {
       
       return appMovilesFacade.listaOpcionesApp(par);
    
    }

    @Override
    public List<Productos> productosLike(String par, String id) {
        return appMovilesFacade.productosLike(par, id);
    }

    @Override
    public List<Clientes> clientesLike(String par) {
      return appMovilesFacade.clientesLike(par);
        
        
    }

    @Override
    public List<ProductoMM> productosBodega(String par) {
       
        return appMovilesFacade.productosBodegaVirtual(par);
    }

    @Override
    public List<RegistrosMM> registrosMMPorVendedor(String par) {
        return appMovilesFacade.registrosMMPorVendedor(par);
        
    }

  
}
