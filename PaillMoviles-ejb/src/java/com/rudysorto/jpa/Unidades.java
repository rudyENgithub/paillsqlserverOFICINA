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
@Table(name = "Unidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidades.findAll", query = "SELECT u FROM Unidades u"),
    @NamedQuery(name = "Unidades.findByIdUnidad", query = "SELECT u FROM Unidades u WHERE u.idUnidad = :idUnidad"),
    @NamedQuery(name = "Unidades.findByNombre", query = "SELECT u FROM Unidades u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Unidades.findByDecimales", query = "SELECT u FROM Unidades u WHERE u.decimales = :decimales"),
    @NamedQuery(name = "Unidades.findByActiva", query = "SELECT u FROM Unidades u WHERE u.activa = :activa"),
    @NamedQuery(name = "Unidades.findByBitacora", query = "SELECT u FROM Unidades u WHERE u.bitacora = :bitacora"),
    @NamedQuery(name = "Unidades.findByCUomId", query = "SELECT u FROM Unidades u WHERE u.cUomId = :cUomId")})
public class Unidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "IdUnidad")
    private String idUnidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Decimales")
    private short decimales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Activa")
    private boolean activa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "Bitacora")
    private String bitacora;
    @Column(name = "c_uom_id")
    private Integer cUomId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidad")
    private List<Productos> productosList;

    public Unidades() {
    }

    public Unidades(String idUnidad) {
        this.idUnidad = idUnidad;
    }

    public Unidades(String idUnidad, String nombre, short decimales, boolean activa, String bitacora) {
        this.idUnidad = idUnidad;
        this.nombre = nombre;
        this.decimales = decimales;
        this.activa = activa;
        this.bitacora = bitacora;
    }

    public String getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(String idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getDecimales() {
        return decimales;
    }

    public void setDecimales(short decimales) {
        this.decimales = decimales;
    }

    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public String getBitacora() {
        return bitacora;
    }

    public void setBitacora(String bitacora) {
        this.bitacora = bitacora;
    }

    public Integer getCUomId() {
        return cUomId;
    }

    public void setCUomId(Integer cUomId) {
        this.cUomId = cUomId;
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
        hash += (idUnidad != null ? idUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidades)) {
            return false;
        }
        Unidades other = (Unidades) object;
        if ((this.idUnidad == null && other.idUnidad != null) || (this.idUnidad != null && !this.idUnidad.equals(other.idUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rudysorto.jpa.Unidades[ idUnidad=" + idUnidad + " ]";
    }
    
}
