/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Subgrupos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subgrupos.findAll", query = "SELECT s FROM Subgrupos s"),
    @NamedQuery(name = "Subgrupos.findByIdSubgrupo", query = "SELECT s FROM Subgrupos s WHERE s.idSubgrupo = :idSubgrupo"),
    @NamedQuery(name = "Subgrupos.findByNombre", query = "SELECT s FROM Subgrupos s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Subgrupos.findByComiVtasVend", query = "SELECT s FROM Subgrupos s WHERE s.comiVtasVend = :comiVtasVend"),
    @NamedQuery(name = "Subgrupos.findByComiAbosVend", query = "SELECT s FROM Subgrupos s WHERE s.comiAbosVend = :comiAbosVend"),
    @NamedQuery(name = "Subgrupos.findByComiVtasProm", query = "SELECT s FROM Subgrupos s WHERE s.comiVtasProm = :comiVtasProm"),
    @NamedQuery(name = "Subgrupos.findByComiAbosProm", query = "SELECT s FROM Subgrupos s WHERE s.comiAbosProm = :comiAbosProm"),
    @NamedQuery(name = "Subgrupos.findByActivo", query = "SELECT s FROM Subgrupos s WHERE s.activo = :activo")})
public class Subgrupos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "IdSubgrupo")
    private String idSubgrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ComiVtasVend")
    private BigDecimal comiVtasVend;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ComiAbosVend")
    private BigDecimal comiAbosVend;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ComiVtasProm")
    private BigDecimal comiVtasProm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ComiAbosProm")
    private BigDecimal comiAbosProm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Activo")
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSubgrupo")
    private List<Productos> productosList;
    @OneToMany(mappedBy = "idFamilia")
    private List<Productos> productosList1;
    @JoinColumn(name = "IdGrupo", referencedColumnName = "IdGrupo")
    @ManyToOne(optional = false)
    private Grupos idGrupo;

    public Subgrupos() {
    }

    public Subgrupos(String idSubgrupo) {
        this.idSubgrupo = idSubgrupo;
    }

    public Subgrupos(String idSubgrupo, String nombre, BigDecimal comiVtasVend, BigDecimal comiAbosVend, BigDecimal comiVtasProm, BigDecimal comiAbosProm, boolean activo) {
        this.idSubgrupo = idSubgrupo;
        this.nombre = nombre;
        this.comiVtasVend = comiVtasVend;
        this.comiAbosVend = comiAbosVend;
        this.comiVtasProm = comiVtasProm;
        this.comiAbosProm = comiAbosProm;
        this.activo = activo;
    }

    public String getIdSubgrupo() {
        return idSubgrupo;
    }

    public void setIdSubgrupo(String idSubgrupo) {
        this.idSubgrupo = idSubgrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getComiVtasVend() {
        return comiVtasVend;
    }

    public void setComiVtasVend(BigDecimal comiVtasVend) {
        this.comiVtasVend = comiVtasVend;
    }

    public BigDecimal getComiAbosVend() {
        return comiAbosVend;
    }

    public void setComiAbosVend(BigDecimal comiAbosVend) {
        this.comiAbosVend = comiAbosVend;
    }

    public BigDecimal getComiVtasProm() {
        return comiVtasProm;
    }

    public void setComiVtasProm(BigDecimal comiVtasProm) {
        this.comiVtasProm = comiVtasProm;
    }

    public BigDecimal getComiAbosProm() {
        return comiAbosProm;
    }

    public void setComiAbosProm(BigDecimal comiAbosProm) {
        this.comiAbosProm = comiAbosProm;
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

    @XmlTransient
    public List<Productos> getProductosList1() {
        return productosList1;
    }

    public void setProductosList1(List<Productos> productosList1) {
        this.productosList1 = productosList1;
    }

    public Grupos getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Grupos idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubgrupo != null ? idSubgrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subgrupos)) {
            return false;
        }
        Subgrupos other = (Subgrupos) object;
        if ((this.idSubgrupo == null && other.idSubgrupo != null) || (this.idSubgrupo != null && !this.idSubgrupo.equals(other.idSubgrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rudysorto.jpa.Subgrupos[ idSubgrupo=" + idSubgrupo + " ]";
    }
    
}
