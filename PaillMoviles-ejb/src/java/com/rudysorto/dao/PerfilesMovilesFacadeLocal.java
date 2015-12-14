/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.dao;

import com.rudysorto.jpa.PerfilesMoviles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rsorto
 */
@Local
public interface PerfilesMovilesFacadeLocal {

    void create(PerfilesMoviles perfilesMoviles);

    void edit(PerfilesMoviles perfilesMoviles);

    void remove(PerfilesMoviles perfilesMoviles);

    PerfilesMoviles find(Object id);

    List<PerfilesMoviles> findAll();

    List<PerfilesMoviles> findRange(int[] range);

    int count();
    
}
