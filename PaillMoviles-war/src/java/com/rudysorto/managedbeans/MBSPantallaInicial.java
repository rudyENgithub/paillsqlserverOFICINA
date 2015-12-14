/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.managedbeans;

import com.rudysorto.jpa.AppMoviles;
import com.rudysorto.ln.AppsMovilesLNLocal;
import java.util.List;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



/**
 *
 * @author rsorto
 */
@ManagedBean(name="mBSPantallaInicial")
@SessionScoped
public class MBSPantallaInicial  {
    @EJB
    private AppsMovilesLNLocal appsMovilesLN;
    
      private AppMoviles AppSelected = new AppMoviles();
    
    private List<AppMoviles> appsList;

    public AppMoviles getAppSelected() {
        return AppSelected;
    }

    public void setAppSelected(AppMoviles AppSelected) {
        this.AppSelected = AppSelected;
    }
    
    

    public List<AppMoviles> getAppsList() {
      appsList =  appsMovilesLN.selectAll();
        return appsList;
    }

    public void setAppsList(List<AppMoviles> appsList) {
        this.appsList = appsList;
    }
    
    
    
    

    /**
     * Creates a new instance of MBSPantallaInicial
     */
    public MBSPantallaInicial() {
        
        
    }
}