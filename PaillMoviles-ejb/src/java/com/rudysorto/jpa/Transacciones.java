/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Transacciones")
@XmlRootElement
@NamedQueries({
    
  }) 
public class Transacciones  implements Serializable{
        @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "idRegMMdet")
    private String idRegMMdet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "IdCliente")
    private String IdCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nombre")
    private String Nombre;
   @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "IdProducto")
    private String IdProducto;
   @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NombreProducto")
    private String NombreProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Cantidad")
    private String Cantidad;
   @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Guardado")
    private String Guardado;

    public Transacciones() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.IdCliente != null ? this.IdCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transacciones other = (Transacciones) obj;
        if ((this.IdCliente == null) ? (other.IdCliente != null) : !this.IdCliente.equals(other.IdCliente)) {
            return false;
        }
        return true;
    }
   
   

    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getGuardado() {
        return Guardado;
    }

    public void setGuardado(String Guardado) {
        this.Guardado = Guardado;
    }
   
   
}
