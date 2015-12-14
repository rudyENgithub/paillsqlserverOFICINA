/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.dao;

import com.rudysorto.jpa.PerfilesMoviles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rsorto
 */
@Stateless
public class PerfilesMovilesFacade extends AbstractFacade<PerfilesMoviles> implements PerfilesMovilesFacadeLocal {
    @PersistenceContext(unitName = "PaillMoviles-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerfilesMovilesFacade() {
        super(PerfilesMoviles.class);
    }
    
}
