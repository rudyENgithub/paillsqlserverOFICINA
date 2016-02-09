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
@Table(name = "Grupos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupos.findAll", query = "SELECT g FROM Grupos g"),
    @NamedQuery(name = "Grupos.findByIdGrupo", query = "SELECT g FROM Grupos g WHERE g.idGrupo = :idGrupo"),
    @NamedQuery(name = "Grupos.findByNombre", query = "SELECT g FROM Grupos g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "Grupos.findByActivo", query = "SELECT g FROM Grupos g WHERE g.activo = :activo"),
    @NamedQuery(name = "Grupos.findByCtaContable", query = "SELECT g FROM Grupos g WHERE g.ctaContable = :ctaContable")})
public class Grupos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "IdGrupo")
    private String idGrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Activo")
    private boolean activo;
    @Size(max = 25)
    @Column(name = "CtaContable")
    private String ctaContable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupo")
    private List<Subgrupos> subgruposList;

    public Grupos() {
    }

    public Grupos(String idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Grupos(String idGrupo, String nombre, boolean activo) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.activo = activo;
    }

    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
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

    public String getCtaContable() {
        return ctaContable;
    }

    public void setCtaContable(String ctaContable) {
        this.ctaContable = ctaContable;
    }

    @XmlTransient
    public List<Subgrupos> getSubgruposList() {
        return subgruposList;
    }

    public void setSubgruposList(List<Subgrupos> subgruposList) {
        this.subgruposList = subgruposList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupos)) {
            return false;
        }
        Grupos other = (Grupos) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rudysorto.jpa.Grupos[ idGrupo=" + idGrupo + " ]";
    }
    
}
