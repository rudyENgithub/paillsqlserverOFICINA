/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rsorto
 */
@Entity
@Table(name = "bodegaVirtualMM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BodegaVirtualMM.findAll", query = "SELECT b FROM BodegaVirtualMM b"),
    @NamedQuery(name = "BodegaVirtualMM.findByIdVendedor", query = "SELECT b FROM BodegaVirtualMM b WHERE b.bodegaVirtualMMPK.idVendedor = :idVendedor"),
    @NamedQuery(name = "BodegaVirtualMM.findByIdProducto", query = "SELECT b FROM BodegaVirtualMM b WHERE b.bodegaVirtualMMPK.idProducto = :idProducto"),
    @NamedQuery(name = "BodegaVirtualMM.findByCantidad", query = "SELECT b FROM BodegaVirtualMM b WHERE b.cantidad = :cantidad"),
    @NamedQuery(name = "BodegaVirtualMM.findByActualizado", query = "SELECT b FROM BodegaVirtualMM b WHERE b.actualizado = :actualizado")})
public class BodegaVirtualMM implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BodegaVirtualMMPK bodegaVirtualMMPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cantidad")
    private String cantidad;
    @Column(name = "Actualizado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizado;
    @JoinColumn(name = "IdProducto", referencedColumnName = "IdProducto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;

    public BodegaVirtualMM() {
    }

    public BodegaVirtualMM(BodegaVirtualMMPK bodegaVirtualMMPK) {
        this.bodegaVirtualMMPK = bodegaVirtualMMPK;
    }

    public BodegaVirtualMM(BodegaVirtualMMPK bodegaVirtualMMPK, String cantidad) {
        this.bodegaVirtualMMPK = bodegaVirtualMMPK;
        this.cantidad = cantidad;
    }

    public BodegaVirtualMM(String idVendedor, String idProducto) {
        this.bodegaVirtualMMPK = new BodegaVirtualMMPK(idVendedor, idProducto);
    }

    public BodegaVirtualMMPK getBodegaVirtualMMPK() {
        return bodegaVirtualMMPK;
    }

    public void setBodegaVirtualMMPK(BodegaVirtualMMPK bodegaVirtualMMPK) {
        this.bodegaVirtualMMPK = bodegaVirtualMMPK;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Date getActualizado() {
        return actualizado;
    }

    public void setActualizado(Date actualizado) {
        this.actualizado = actualizado;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bodegaVirtualMMPK != null ? bodegaVirtualMMPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BodegaVirtualMM)) {
            return false;
        }
        BodegaVirtualMM other = (BodegaVirtualMM) object;
        if ((this.bodegaVirtualMMPK == null && other.bodegaVirtualMMPK != null) || (this.bodegaVirtualMMPK != null && !this.bodegaVirtualMMPK.equals(other.bodegaVirtualMMPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rudysorto.jpa.BodegaVirtualMM[ bodegaVirtualMMPK=" + bodegaVirtualMMPK + " ]";
    }
    
}
