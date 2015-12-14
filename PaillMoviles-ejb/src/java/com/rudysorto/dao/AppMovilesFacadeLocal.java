/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.dao;

import com.rudysorto.jpa.AppMoviles;
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
    
   public List<AppMoviles> listaAppsPerfil(String par);


    
}
