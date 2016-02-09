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
@Table(name = "TiposProd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposProd.findAll", query = "SELECT t FROM TiposProd t"),
    @NamedQuery(name = "TiposProd.findByTipoProd", query = "SELECT t FROM TiposProd t WHERE t.tipoProd = :tipoProd"),
    @NamedQuery(name = "TiposProd.findByNombre", query = "SELECT t FROM TiposProd t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TiposProd.findByActivo", query = "SELECT t FROM TiposProd t WHERE t.activo = :activo")})
public class TiposProd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "TipoProd")
    private String tipoProd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Activo")
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoProd")
    private List<Productos> productosList;

    public TiposProd() {
    }

    public TiposProd(String tipoProd) {
        this.tipoProd = tipoProd;
    }

    public TiposProd(String tipoProd, String nombre, boolean activo) {
        this.tipoProd = tipoProd;
        this.nombre = nombre;
        this.activo = activo;
    }

    public String getTipoProd() {
        return tipoProd;
    }

    public void setTipoProd(String tipoProd) {
        this.tipoProd = tipoProd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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
        hash += (tipoProd != null ? tipoProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposProd)) {
            return false;
        }
        TiposProd other = (TiposProd) object;
        if ((this.tipoProd == null && other.tipoProd != null) || (this.tipoProd != null && !this.tipoProd.equals(other.tipoProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rudysorto.jpa.TiposProd[ tipoProd=" + tipoProd + " ]";
    }
    
}
