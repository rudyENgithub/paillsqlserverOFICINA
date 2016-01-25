/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.jpa;

import java.util.Date;

/**
 *
 * @author rsorto
 */
public class RegistrosMMdet {
       private String IdProducto;
    private String Cantidad;
    private String Notas;
    private String Guardado;

    public RegistrosMMdet(String IdProducto, String Cantidad, String Notas, String Guardado) {
        this.IdProducto = IdProducto;
        this.Cantidad = Cantidad;
        this.Notas = Notas;
        this.Guardado = Guardado;
    }
    
    

    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getNotas() {
        return Notas;
    }

    public void setNotas(String Notas) {
        this.Notas = Notas;
    }

    public String getGuardado() {
        return Guardado;
    }

    public void setGuardado(String Guardado) {
        this.Guardado = Guardado;
    }
    
    

}
