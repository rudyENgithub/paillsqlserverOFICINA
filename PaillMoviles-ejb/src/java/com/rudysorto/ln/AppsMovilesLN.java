/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.ln;

import com.rudysorto.dao.AppMovilesFacade;
import com.rudysorto.dao.AppMovilesFacadeLocal;
import com.rudysorto.jpa.AppMoviles;
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
    public List<AppMoviles> selectLike(String par) {
        return appMovilesFacade.listaAppsPerfil(par);
       
    }

  
}
