/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rsorto
 */
@Entity
@Table(name = "Presentaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presentaciones.findAll", query = "SELECT p FROM Presentaciones p"),
    @NamedQuery(name = "Presentaciones.findByIdPresenta", query = "SELECT p FROM Presentaciones p WHERE p.idPresenta = :idPresenta"),
    @NamedQuery(name = "Presentaciones.findByNombre", query = "SELECT p FROM Presentaciones p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Presentaciones.findByActiva", query = "SELECT p FROM Presentaciones p WHERE p.activa = :activa")})
public class Presentaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "IdPresenta")
    private String idPresenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Activa")
    private boolean activa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPresenta")
    private List<Productos> productosList;

    public Presentaciones() {
    }

    public Presentaciones(String idPresenta) {
        this.idPresenta = idPresenta;
    }

    public Presentaciones(String idPresenta, String nombre, boolean activa) {
        this.idPresenta = idPresenta;
        this.nombre = nombre;
        this.activa = activa;
    }

    public String getIdPresenta() {
        return idPresenta;
    }

    public void setIdPresenta(String idPresenta) {
        this.idPresenta = idPresenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    @XmlTransient
    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPresenta != null ? idPresenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presentaciones)) {
            return false;
        }
        Presentaciones other = (Presentaciones) object;
        if ((this.idPresenta == null && other.idPresenta != null) || (this.idPresenta != null && !this.idPresenta.equals(other.idPresenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rudysorto.jpa.Presentaciones[ idPresenta=" + idPresenta + " ]";
    }
    
}
