/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.managedbeans;

import com.rudysorto.jpa.AppMoviles;
import com.rudysorto.jpa.Usuarios;
import com.rudysorto.ln.AppsMovilesLNLocal;
import com.rudysorto.ws.LoginWS;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import org.primefaces.context.RequestContext;



/**
 *
 * @author rsorto
 */
@ManagedBean(name="mBSPantallaInicial")
@SessionScoped
public class MBSPantallaInicial  {
    @EJB
    private AppsMovilesLNLocal appsMovilesLN;
    private String username;
    private String password;
      private AppMoviles AppSelected = new AppMoviles();
    
    private List<AppMoviles> appsList;
private boolean islogeado = false;

    public boolean isIslogeado() {
        return islogeado;
    }

    public void setIslogeado(boolean islogeado) {
        this.islogeado = islogeado;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
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
    
    
    
    
public void validUser(){
   // System.out.println("Validar"+ getUsername() + " " +  getPassword() );
     RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
          Usuarios usuario = null;

        if (appsMovilesLN.login(username, password).equals("OK")) {
            System.out.println(appsMovilesLN.login(username, password));
             
             usuario = new Usuarios(username);
              
            islogeado = true;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", usuario.getUid());
        } else if(appsMovilesLN.login(username, password).equals("ERR")) {
              System.out.println(appsMovilesLN.login(username, password));
            islogeado = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Login Error",
                    "Credenciales no válidas");
        }
          FacesContext.getCurrentInstance().addMessage(null, msg);
          HttpSession session = Util.getSession();
            session.setAttribute("username", usuario.getUid());
 
        //    return "home";
       context.addCallbackParam("estaLogeado", islogeado);
        if (islogeado) {
          //  context.addCallbackParam("view", "menuprincipal.xhtml");
             navigation("loginSuccess");
        }
}   public void navigation(String rule) {
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        nav.performNavigation(rule);
    }
    /**
     * Creates a new instance of MBSPantallaInicial
     */
    public MBSPantallaInicial() {
        
        
    }
}