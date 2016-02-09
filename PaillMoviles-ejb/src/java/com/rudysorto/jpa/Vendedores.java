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
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "Vendedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedores.findAll", query = "SELECT c FROM Vendedores c"),
    @NamedQuery(name = "Vendedores.findByIdVendedor", query = "SELECT c FROM Vendedores c WHERE c.IdVendedor = :IdVendedor"),
    @NamedQuery(name = "Vendedores.findByNombre", query = "SELECT c FROM Vendedores c WHERE c.Nombre = :Nombre"),
        @NamedQuery(name = "Vendedores.findByGrupo", query = "SELECT c FROM Vendedores c WHERE c.Grupo = :Grupo")
  })
public class Vendedores implements Serializable {
    
     @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "IdVendedor")
    private String IdVendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Nombre")
    private String Nombre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Grupo")
    private String Grupo;

    public Vendedores() {
    }

    public String getIdVendedor() {
        return IdVendedor;
    }

    public void setIdVendedor(String IdVendedor) {
        this.IdVendedor = IdVendedor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String Grupo) {
        this.Grupo = Grupo;
    }
    
    

    public Vendedores(String IdVendedor, String Nombre, String Grupo) {
        this.IdVendedor = IdVendedor;
        this.Nombre = Nombre;
        this.Grupo = Grupo;
    }
    
    
      @Override
    public int hashCode() {
        int hash = 0;
        hash += (IdVendedor != null ? IdVendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Vendedores other = (Vendedores) object;
        if ((this.IdVendedor == null && other.IdVendedor != null) || (this.IdVendedor != null && !this.IdVendedor.equals(other.IdVendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rudysorto.jpa.Clientes[ idCliente=" + IdVendedor + " ]";
    }
    
    
    
}