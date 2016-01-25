/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rsorto
 */
@Embeddable
public class BodegaVirtualMMPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "IdVendedor")
    private String idVendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "IdProducto")
    private String idProducto;

    public BodegaVirtualMMPK() {
    }

    public BodegaVirtualMMPK(String idVendedor, String idProducto) {
        this.idVendedor = idVendedor;
        this.idProducto = idProducto;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVendedor != null ? idVendedor.hashCode() : 0);
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BodegaVirtualMMPK)) {
            return false;
        }
        BodegaVirtualMMPK other = (BodegaVirtualMMPK) object;
        if ((this.idVendedor == null && other.idVendedor != null) || (this.idVendedor != null && !this.idVendedor.equals(other.idVendedor))) {
            return false;
        }
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rudysorto.jpa.BodegaVirtualMMPK[ idVendedor=" + idVendedor + ", idProducto=" + idProducto + " ]";
    }
    
}
