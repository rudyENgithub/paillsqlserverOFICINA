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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rsorto
 */
@Entity
@Table(name = "OpcionesAppMoviles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpcionesAppMoviles.findAll", query = "SELECT o FROM OpcionesAppMoviles o"),
    @NamedQuery(name = "OpcionesAppMoviles.findByIdOpcionesAppMoviles", query = "SELECT o FROM OpcionesAppMoviles o WHERE o.idOpcionesAppMoviles = :idOpcionesAppMoviles"),
    @NamedQuery(name = "OpcionesAppMoviles.findByNombre", query = "SELECT o FROM OpcionesAppMoviles o WHERE o.nombre = :nombre"),
    @NamedQuery(name = "OpcionesAppMoviles.findByDescripcion", query = "SELECT o FROM OpcionesAppMoviles o WHERE o.descripcion = :descripcion"),
     @NamedQuery(name = "OpcionesAppMoviles.findByIdEmpleado", query = "SELECT o FROM OpcionesAppMoviles o WHERE o.IdEmpleado = :IdEmpleado"),
    @NamedQuery(name = "OpcionesAppMoviles.findByLogo", query = "SELECT o FROM OpcionesAppMoviles o WHERE o.logo = :logo")})
public class OpcionesAppMoviles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdOpcionesAppMoviles")
    private Integer idOpcionesAppMoviles;
    @Size(max = 100)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 50)
    @Column(name = "Logo")
    private String logo;
    @JoinColumn(name = "IdAppMovil", referencedColumnName = "IdAppMovil")
    @ManyToOne
    private AppMoviles idAppMovil;
     @Size(max = 100)
    @Column(name = "IdEmpleado")
    private String IdEmpleado;
    
    public OpcionesAppMoviles() {
    }

    public String getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(String IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }
    
    

    public OpcionesAppMoviles(Integer idOpcionesAppMoviles) {
        this.idOpcionesAppMoviles = idOpcionesAppMoviles;
    }

    public Integer getIdOpcionesAppMoviles() {
        return idOpcionesAppMoviles;
    }

    public void setIdOpcionesAppMoviles(Integer idOpcionesAppMoviles) {
        this.idOpcionesAppMoviles = idOpcionesAppMoviles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public AppMoviles getIdAppMovil() {
        return idAppMovil;
    }

    public void setIdAppMovil(AppMoviles idAppMovil) {
        this.idAppMovil = idAppMovil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOpcionesAppMoviles != null ? idOpcionesAppMoviles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionesAppMoviles)) {
            return false;
        }
        OpcionesAppMoviles other = (OpcionesAppMoviles) object;
        if ((this.idOpcionesAppMoviles == null && other.idOpcionesAppMoviles != null) || (this.idOpcionesAppMoviles != null && !this.idOpcionesAppMoviles.equals(other.idOpcionesAppMoviles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rudysorto.jpa.OpcionesAppMoviles[ idOpcionesAppMoviles=" + idOpcionesAppMoviles + " ]";
    }
    
}
