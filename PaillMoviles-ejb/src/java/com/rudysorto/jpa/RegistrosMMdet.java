/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "RegistrosMMdet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistrosMMdet.findAll", query = "SELECT r FROM RegistrosMMdet r"),
    @NamedQuery(name = "RegistrosMMdet.findByIdRegMMdet", query = "SELECT r FROM RegistrosMMdet r WHERE r.idRegMMdet = :idRegMMdet"),
    @NamedQuery(name = "RegistrosMMdet.findByCantidad", query = "SELECT r FROM RegistrosMMdet r WHERE r.cantidad = :cantidad"),
    @NamedQuery(name = "RegistrosMMdet.findByGuardado", query = "SELECT r FROM RegistrosMMdet r WHERE r.guardado = :guardado")})
public class RegistrosMMdet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdRegMMdet")
    private Integer idRegMMdet;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private BigDecimal cantidad;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Notas")
    private String notas;
    @Column(name = "Guardado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date guardado;
    @JoinColumn(name = "IdRegMM", referencedColumnName = "IdRegMM")
    @ManyToOne(optional = false)
    private RegistrosMM idRegMM;
    @JoinColumn(name = "IdProducto", referencedColumnName = "IdProducto")
    @ManyToOne(optional = false)
    private Productos idProducto;

    public RegistrosMMdet() {
    }

    public RegistrosMMdet(Integer idRegMMdet) {
        this.idRegMMdet = idRegMMdet;
    }

    public RegistrosMMdet(Integer idRegMMdet, BigDecimal cantidad) {
        this.idRegMMdet = idRegMMdet;
        this.cantidad = cantidad;
    }

    public Integer getIdRegMMdet() {
        return idRegMMdet;
    }

    public void setIdRegMMdet(Integer idRegMMdet) {
        this.idRegMMdet = idRegMMdet;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Date getGuardado() {
        return guardado;
    }

    public void setGuardado(Date guardado) {
        this.guardado = guardado;
    }

    public RegistrosMM getIdRegMM() {
        return idRegMM;
    }

    public void setIdRegMM(RegistrosMM idRegMM) {
        this.idRegMM = idRegMM;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegMMdet != null ? idRegMMdet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistrosMMdet)) {
            return false;
        }
        RegistrosMMdet other = (RegistrosMMdet) object;
        if ((this.idRegMMdet == null && other.idRegMMdet != null) || (this.idRegMMdet != null && !this.idRegMMdet.equals(other.idRegMMdet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rudysorto.jpa.RegistrosMMdet[ idRegMMdet=" + idRegMMdet + " ]";
    }
    
}
