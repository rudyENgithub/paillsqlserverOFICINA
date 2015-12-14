/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.jpa;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "Usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByUid", query = "SELECT u FROM Usuarios u WHERE u.uid = :uid"),
    @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuarios.findByCompras", query = "SELECT u FROM Usuarios u WHERE u.compras = :compras"),
    @NamedQuery(name = "Usuarios.findByContabilidad", query = "SELECT u FROM Usuarios u WHERE u.contabilidad = :contabilidad"),
    @NamedQuery(name = "Usuarios.findByCreditos", query = "SELECT u FROM Usuarios u WHERE u.creditos = :creditos"),
    @NamedQuery(name = "Usuarios.findByInventarios", query = "SELECT u FROM Usuarios u WHERE u.inventarios = :inventarios"),
    @NamedQuery(name = "Usuarios.findByPlanillas", query = "SELECT u FROM Usuarios u WHERE u.planillas = :planillas"),
    @NamedQuery(name = "Usuarios.findByProduccion", query = "SELECT u FROM Usuarios u WHERE u.produccion = :produccion"),
    @NamedQuery(name = "Usuarios.findByVentas", query = "SELECT u FROM Usuarios u WHERE u.ventas = :ventas"),
    @NamedQuery(name = "Usuarios.findBySeguridad", query = "SELECT u FROM Usuarios u WHERE u.seguridad = :seguridad"),
    @NamedQuery(name = "Usuarios.findByIdSucursal", query = "SELECT u FROM Usuarios u WHERE u.idSucursal = :idSucursal"),
    @NamedQuery(name = "Usuarios.findByBitacora", query = "SELECT u FROM Usuarios u WHERE u.bitacora = :bitacora"),
    @NamedQuery(name = "Usuarios.findByMantenimiento", query = "SELECT u FROM Usuarios u WHERE u.mantenimiento = :mantenimiento"),
    @NamedQuery(name = "Usuarios.findByLimite", query = "SELECT u FROM Usuarios u WHERE u.limite = :limite"),
    @NamedQuery(name = "Usuarios.findBySu", query = "SELECT u FROM Usuarios u WHERE u.su = :su"),
    @NamedQuery(name = "Usuarios.findByIdEmpleado", query = "SELECT u FROM Usuarios u WHERE u.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Usuarios.findByIdDepto", query = "SELECT u FROM Usuarios u WHERE u.idDepto = :idDepto"),
    @NamedQuery(name = "Usuarios.findByInformatica", query = "SELECT u FROM Usuarios u WHERE u.informatica = :informatica"),
    @NamedQuery(name = "Usuarios.findByEspeciales", query = "SELECT u FROM Usuarios u WHERE u.especiales = :especiales"),
    @NamedQuery(name = "Usuarios.findByIncluierEn", query = "SELECT u FROM Usuarios u WHERE u.incluierEn = :incluierEn"),
    @NamedQuery(name = "Usuarios.findByFechaExpiracion", query = "SELECT u FROM Usuarios u WHERE u.fechaExpiracion = :fechaExpiracion"),
    @NamedQuery(name = "Usuarios.findByIdPerfil", query = "SELECT u FROM Usuarios u WHERE u.idPerfil = :idPerfil"),
    @NamedQuery(name = "Usuarios.findByEspeciales2", query = "SELECT u FROM Usuarios u WHERE u.especiales2 = :especiales2"),
    @NamedQuery(name = "Usuarios.findByActivo", query = "SELECT u FROM Usuarios u WHERE u.activo = :activo")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "UID")
    private String uid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Compras")
    private int compras;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Contabilidad")
    private int contabilidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Creditos")
    private int creditos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Inventarios")
    private int inventarios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Planillas")
    private int planillas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Produccion")
    private int produccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ventas")
    private int ventas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Seguridad")
    private int seguridad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "IdSucursal")
    private String idSucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "Bitacora")
    private String bitacora;
    @Column(name = "Mantenimiento")
    private Integer mantenimiento;
    @Column(name = "Limite")
    private Integer limite;
    @Column(name = "SU")
    private Integer su;
    @Size(max = 15)
    @Column(name = "IdEmpleado")
    private String idEmpleado;
    @Size(max = 15)
    @Column(name = "IdDepto")
    private String idDepto;
    @Column(name = "Informatica")
    private Integer informatica;
    @Column(name = "Especiales")
    private BigInteger especiales;
    @Size(max = 1073741823)
    @Column(name = "IncluierEn")
    private String incluierEn;
    @Column(name = "FechaExpiracion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaExpiracion;
    @Column(name = "IdPerfil")
    private Integer idPerfil;
    @Column(name = "Especiales2")
    private BigInteger especiales2;
    @Column(name = "Activo")
    private Boolean activo;
    @JoinColumn(name = "IdPerfilMovil", referencedColumnName = "IdPerfilMovil")
    @ManyToOne
    private PerfilesMoviles idPerfilMovil;

    public Usuarios() {
    }

    public Usuarios(String uid) {
        this.uid = uid;
    }

    public Usuarios(String uid, String nombre, int compras, int contabilidad, int creditos, int inventarios, int planillas, int produccion, int ventas, int seguridad, String idSucursal, String bitacora) {
        this.uid = uid;
        this.nombre = nombre;
        this.compras = compras;
        this.contabilidad = contabilidad;
        this.creditos = creditos;
        this.inventarios = inventarios;
        this.planillas = planillas;
        this.produccion = produccion;
        this.ventas = ventas;
        this.seguridad = seguridad;
        this.idSucursal = idSucursal;
        this.bitacora = bitacora;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCompras() {
        return compras;
    }

    public void setCompras(int compras) {
        this.compras = compras;
    }

    public int getContabilidad() {
        return contabilidad;
    }

    public void setContabilidad(int contabilidad) {
        this.contabilidad = contabilidad;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getInventarios() {
        return inventarios;
    }

    public void setInventarios(int inventarios) {
        this.inventarios = inventarios;
    }

    public int getPlanillas() {
        return planillas;
    }

    public void setPlanillas(int planillas) {
        this.planillas = planillas;
    }

    public int getProduccion() {
        return produccion;
    }

    public void setProduccion(int produccion) {
        this.produccion = produccion;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public int getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(int seguridad) {
        this.seguridad = seguridad;
    }

    public String getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getBitacora() {
        return bitacora;
    }

    public void setBitacora(String bitacora) {
        this.bitacora = bitacora;
    }

    public Integer getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Integer mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }

    public Integer getSu() {
        return su;
    }

    public void setSu(Integer su) {
        this.su = su;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(String idDepto) {
        this.idDepto = idDepto;
    }

    public Integer getInformatica() {
        return informatica;
    }

    public void setInformatica(Integer informatica) {
        this.informatica = informatica;
    }

    public BigInteger getEspeciales() {
        return especiales;
    }

    public void setEspeciales(BigInteger especiales) {
        this.especiales = especiales;
    }

    public String getIncluierEn() {
        return incluierEn;
    }

    public void setIncluierEn(String incluierEn) {
        this.incluierEn = incluierEn;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public BigInteger getEspeciales2() {
        return especiales2;
    }

    public void setEspeciales2(BigInteger especiales2) {
        this.especiales2 = especiales2;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public PerfilesMoviles getIdPerfilMovil() {
        return idPerfilMovil;
    }

    public void setIdPerfilMovil(PerfilesMoviles idPerfilMovil) {
        this.idPerfilMovil = idPerfilMovil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rudysorto.jpa.Usuarios[ uid=" + uid + " ]";
    }
    
}
