/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "AppMoviles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppMoviles.findAll", query = "SELECT a FROM AppMoviles a"),
    @NamedQuery(name = "AppMoviles.findByIdAppMovil", query = "SELECT a FROM AppMoviles a WHERE a.idAppMovil = :idAppMovil"),
    @NamedQuery(name = "AppMoviles.findByNombre", query = "SELECT a FROM AppMoviles a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "AppMoviles.findByDescripcion", query = "SELECT a FROM AppMoviles a WHERE a.descripcion = :descripcion")})
public class AppMoviles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdAppMovil")
    private Integer idAppMovil;
    @Size(max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @Lob
    @Column(name = "Logo")
    private byte[] logo;
    @JoinTable(name = "AppPorPerfiles", joinColumns = {
        @JoinColumn(name = "IdAppMovil", referencedColumnName = "IdAppMovil")}, inverseJoinColumns = {
        @JoinColumn(name = "IdPerfilMovil", referencedColumnName = "IdPerfilMovil")})
    @ManyToMany
    private List<PerfilesMoviles> perfilesMovilesList;
    @OneToMany(mappedBy = "idAppMovil")
    private List<OpcionesAppMoviles> opcionesAppMovilesList;

    public AppMoviles() {
    }

    public AppMoviles(Integer idAppMovil) {
        this.idAppMovil = idAppMovil;
    }

    public Integer getIdAppMovil() {
        return idAppMovil;
    }

    public void setIdAppMovil(Integer idAppMovil) {
        this.idAppMovil = idAppMovil;
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

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    @XmlTransient
    public List<PerfilesMoviles> getPerfilesMovilesList() {
        return perfilesMovilesList;
    }

    public void setPerfilesMovilesList(List<PerfilesMoviles> perfilesMovilesList) {
        this.perfilesMovilesList = perfilesMovilesList;
    }

    @XmlTransient
    public List<OpcionesAppMoviles> getOpcionesAppMovilesList() {
        return opcionesAppMovilesList;
    }

    public void setOpcionesAppMovilesList(List<OpcionesAppMoviles> opcionesAppMovilesList) {
        this.opcionesAppMovilesList = opcionesAppMovilesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAppMovil != null ? idAppMovil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppMoviles)) {
            return false;
        }
        AppMoviles other = (AppMoviles) object;
        if ((this.idAppMovil == null && other.idAppMovil != null) || (this.idAppMovil != null && !this.idAppMovil.equals(other.idAppMovil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rudysorto.jpa.AppMoviles[ idAppMovil=" + idAppMovil + " ]";
    }
    
}
