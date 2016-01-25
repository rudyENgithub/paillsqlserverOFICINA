/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "RegistrosMM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistrosMM.findAll", query = "SELECT r FROM RegistrosMM r"),
    @NamedQuery(name = "RegistrosMM.findByIdRegMM", query = "SELECT r FROM RegistrosMM r WHERE r.idRegMM = :idRegMM"),
    @NamedQuery(name = "RegistrosMM.findByIdVendedor", query = "SELECT r FROM RegistrosMM r WHERE r.idVendedor = :idVendedor"),
    @NamedQuery(name = "RegistrosMM.findByIdCliente", query = "SELECT r FROM RegistrosMM r WHERE r.idCliente = :idCliente"),
      @NamedQuery(name = "RegistrosMM.findByNombre", query = "SELECT r FROM RegistrosMM r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "RegistrosMM.findByLatitud", query = "SELECT r FROM RegistrosMM r WHERE r.latitud = :latitud"),
    @NamedQuery(name = "RegistrosMM.findByLongitud", query = "SELECT r FROM RegistrosMM r WHERE r.longitud = :longitud"),
    @NamedQuery(name = "RegistrosMM.findByGuardado", query = "SELECT r FROM RegistrosMM r WHERE r.guardado = :guardado")})
public class RegistrosMM implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdRegMM")
    private Integer idRegMM;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "IdVendedor")
    private String idVendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "IdCliente")
    private String idCliente;
     @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Latitud")
    private String latitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Longitud")
    private String longitud;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Notas")
    private String notas;
    @Column(name = "Guardado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date guardado;
      @Basic(optional = false)
    @NotNull
    @Column(name = "totalmm")
    private double totalmm;

    public RegistrosMM() {
    }

    public double getTotalmm() {
        return totalmm;
    }

    public void setTotalmm(double totalmm) {
        this.totalmm = totalmm;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    public RegistrosMM(Integer idRegMM) {
        this.idRegMM = idRegMM;
    }

    public RegistrosMM(Integer idRegMM, String idVendedor, String idCliente, String nombre, String latitud, String longitud, String notas, Date guardado) {
        this.idRegMM = idRegMM;
        this.idVendedor = idVendedor;
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.notas = notas;
        this.guardado = guardado;
    }
  /*  public RegistrosMM(Integer idRegMM, String idVendedor, String idCliente, String latitud, String longitud) {
        this.idRegMM = idRegMM;
        this.idVendedor = idVendedor;
        this.idCliente = idCliente;
        this.latitud = latitud;
        this.longitud = longitud;
    }*/
    public Integer getIdRegMM() {
        return idRegMM;
    }

    public void setIdRegMM(Integer idRegMM) {
        this.idRegMM = idRegMM;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegMM != null ? idRegMM.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistrosMM)) {
            return false;
        }
        RegistrosMM other = (RegistrosMM) object;
        if ((this.idRegMM == null && other.idRegMM != null) || (this.idRegMM != null && !this.idRegMM.equals(other.idRegMM))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rudysorto.jpa.RegistrosMM[ idRegMM=" + idRegMM + " ]";
    }
    
}
