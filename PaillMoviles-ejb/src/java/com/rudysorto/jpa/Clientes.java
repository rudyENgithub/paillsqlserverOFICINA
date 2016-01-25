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
@Table(name = "Clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByIdCliente", query = "SELECT c FROM Clientes c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Clientes.findByNombre", query = "SELECT c FROM Clientes c WHERE c.nombre = :nombre"),
  /*  @NamedQuery(name = "Clientes.findByRazonSocial", query = "SELECT c FROM Clientes c WHERE c.razonSocial = :razonSocial"),
    @NamedQuery(name = "Clientes.findByRegFiscal", query = "SELECT c FROM Clientes c WHERE c.regFiscal = :regFiscal"),
    @NamedQuery(name = "Clientes.findByNit", query = "SELECT c FROM Clientes c WHERE c.nit = :nit"),
    @NamedQuery(name = "Clientes.findByDui", query = "SELECT c FROM Clientes c WHERE c.dui = :dui"),
    @NamedQuery(name = "Clientes.findByTipoIVA", query = "SELECT c FROM Clientes c WHERE c.tipoIVA = :tipoIVA"),
    @NamedQuery(name = "Clientes.findByGiro", query = "SELECT c FROM Clientes c WHERE c.giro = :giro"),
    @NamedQuery(name = "Clientes.findByCadena", query = "SELECT c FROM Clientes c WHERE c.cadena = :cadena"),
    @NamedQuery(name = "Clientes.findByFechaIni", query = "SELECT c FROM Clientes c WHERE c.fechaIni = :fechaIni"),
    @NamedQuery(name = "Clientes.findByBonificacion", query = "SELECT c FROM Clientes c WHERE c.bonificacion = :bonificacion"),
    @NamedQuery(name = "Clientes.findByTasaDesc", query = "SELECT c FROM Clientes c WHERE c.tasaDesc = :tasaDesc"),
    @NamedQuery(name = "Clientes.findByLimite", query = "SELECT c FROM Clientes c WHERE c.limite = :limite"),
    @NamedQuery(name = "Clientes.findByVencimiento", query = "SELECT c FROM Clientes c WHERE c.vencimiento = :vencimiento"),
    @NamedQuery(name = "Clientes.findByEnviarA", query = "SELECT c FROM Clientes c WHERE c.enviarA = :enviarA"),
    @NamedQuery(name = "Clientes.findByFacturarA", query = "SELECT c FROM Clientes c WHERE c.facturarA = :facturarA"),
    @NamedQuery(name = "Clientes.findByCCNombre", query = "SELECT c FROM Clientes c WHERE c.cCNombre = :cCNombre"),
    @NamedQuery(name = "Clientes.findByCCNumero", query = "SELECT c FROM Clientes c WHERE c.cCNumero = :cCNumero"),
    @NamedQuery(name = "Clientes.findByCCVerificador", query = "SELECT c FROM Clientes c WHERE c.cCVerificador = :cCVerificador"),
    @NamedQuery(name = "Clientes.findByCCExpira", query = "SELECT c FROM Clientes c WHERE c.cCExpira = :cCExpira"),
    @NamedQuery(name = "Clientes.findByCCBanco", query = "SELECT c FROM Clientes c WHERE c.cCBanco = :cCBanco"),
    @NamedQuery(name = "Clientes.findByIdPromotor", query = "SELECT c FROM Clientes c WHERE c.idPromotor = :idPromotor"),
    @NamedQuery(name = "Clientes.findByUid", query = "SELECT c FROM Clientes c WHERE c.uid = :uid"),
    @NamedQuery(name = "Clientes.findByPwd", query = "SELECT c FROM Clientes c WHERE c.pwd = :pwd"),
    @NamedQuery(name = "Clientes.findByActivo", query = "SELECT c FROM Clientes c WHERE c.activo = :activo"),
    @NamedQuery(name = "Clientes.findByIdCtaCont1", query = "SELECT c FROM Clientes c WHERE c.idCtaCont1 = :idCtaCont1"),
    @NamedQuery(name = "Clientes.findByIdCtaCont2", query = "SELECT c FROM Clientes c WHERE c.idCtaCont2 = :idCtaCont2"),
    @NamedQuery(name = "Clientes.findByIdCtaCont3", query = "SELECT c FROM Clientes c WHERE c.idCtaCont3 = :idCtaCont3"),
    @NamedQuery(name = "Clientes.findByIdCtaCont4", query = "SELECT c FROM Clientes c WHERE c.idCtaCont4 = :idCtaCont4"),
    @NamedQuery(name = "Clientes.findByIdCtaCont5", query = "SELECT c FROM Clientes c WHERE c.idCtaCont5 = :idCtaCont5"),
    @NamedQuery(name = "Clientes.findByIdCtaCont6", query = "SELECT c FROM Clientes c WHERE c.idCtaCont6 = :idCtaCont6"),
    @NamedQuery(name = "Clientes.findByIdCtaCont7", query = "SELECT c FROM Clientes c WHERE c.idCtaCont7 = :idCtaCont7"),
    @NamedQuery(name = "Clientes.findByIdCtaCont8", query = "SELECT c FROM Clientes c WHERE c.idCtaCont8 = :idCtaCont8"),
    @NamedQuery(name = "Clientes.findByAviso", query = "SELECT c FROM Clientes c WHERE c.aviso = :aviso"),
    @NamedQuery(name = "Clientes.findByNotas", query = "SELECT c FROM Clientes c WHERE c.notas = :notas"),
    @NamedQuery(name = "Clientes.findByBitacora", query = "SELECT c FROM Clientes c WHERE c.bitacora = :bitacora"),
    @NamedQuery(name = "Clientes.findByIdClasificacion", query = "SELECT c FROM Clientes c WHERE c.idClasificacion = :idClasificacion"),
    @NamedQuery(name = "Clientes.findByFechaInactivo", query = "SELECT c FROM Clientes c WHERE c.fechaInactivo = :fechaInactivo"),
    @NamedQuery(name = "Clientes.findByObservaciones", query = "SELECT c FROM Clientes c WHERE c.observaciones = :observaciones"),
    @NamedQuery(name = "Clientes.findByIdEstatusCliente", query = "SELECT c FROM Clientes c WHERE c.idEstatusCliente = :idEstatusCliente"),
    @NamedQuery(name = "Clientes.findByIdGarantia", query = "SELECT c FROM Clientes c WHERE c.idGarantia = :idGarantia"),
    @NamedQuery(name = "Clientes.findByMontoGarantia", query = "SELECT c FROM Clientes c WHERE c.montoGarantia = :montoGarantia"),
    @NamedQuery(name = "Clientes.findByFechaUltFactura", query = "SELECT c FROM Clientes c WHERE c.fechaUltFactura = :fechaUltFactura"),
    @NamedQuery(name = "Clientes.findByIdGestor", query = "SELECT c FROM Clientes c WHERE c.idGestor = :idGestor")})
    * */
     })
public class Clientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
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
    /*
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "RazonSocial")
    private String razonSocial;
    @Size(max = 20)
    @Column(name = "RegFiscal")
    private String regFiscal;
    @Size(max = 20)
    @Column(name = "NIT")
    private String nit;
    @Size(max = 20)
    @Column(name = "DUI")
    private String dui;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "TipoIVA")
    private String tipoIVA;
    @Size(max = 1073741823)
    @Column(name = "Giro")
    private String giro;
    @Size(max = 15)
    @Column(name = "Cadena")
    private String cadena;
    @Column(name = "FechaIni")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Bonificacion")
    private boolean bonificacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "TasaDesc")
    private BigDecimal tasaDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Limite")
    private BigDecimal limite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Vencimiento")
    private int vencimiento;
    @Size(max = 15)
    @Column(name = "EnviarA")
    private String enviarA;
    @Size(max = 15)
    @Column(name = "FacturarA")
    private String facturarA;
    @Size(max = 100)
    @Column(name = "CCNombre")
    private String cCNombre;
    @Size(max = 20)
    @Column(name = "CCNumero")
    private String cCNumero;
    @Size(max = 4)
    @Column(name = "CCVerificador")
    private String cCVerificador;
    @Column(name = "CCExpira")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cCExpira;
    @Size(max = 15)
    @Column(name = "CCBanco")
    private String cCBanco;
    @Size(max = 15)
    @Column(name = "IdPromotor")
    private String idPromotor;
    @Size(max = 15)
    @Column(name = "UID")
    private String uid;
    @Size(max = 15)
    @Column(name = "PWD")
    private String pwd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "IdCtaCont1")
    private String idCtaCont1;
    @Size(max = 15)
    @Column(name = "IdCtaCont2")
    private String idCtaCont2;
    @Size(max = 15)
    @Column(name = "IdCtaCont3")
    private String idCtaCont3;
    @Size(max = 15)
    @Column(name = "IdCtaCont4")
    private String idCtaCont4;
    @Size(max = 15)
    @Column(name = "IdCtaCont5")
    private String idCtaCont5;
    @Size(max = 15)
    @Column(name = "IdCtaCont6")
    private String idCtaCont6;
    @Size(max = 15)
    @Column(name = "IdCtaCont7")
    private String idCtaCont7;
    @Size(max = 15)
    @Column(name = "IdCtaCont8")
    private String idCtaCont8;
    @Size(max = 1073741823)
    @Column(name = "Aviso")
    private String aviso;
    @Size(max = 1073741823)
    @Column(name = "Notas")
    private String notas;
    @Lob
    @Column(name = "Foto")
    private byte[] foto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "Bitacora")
    private String bitacora;
    @Column(name = "IdClasificacion")
    private Integer idClasificacion;
    @Column(name = "FechaInactivo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInactivo;
    @Size(max = 1073741823)
    @Column(name = "Observaciones")
    private String observaciones;
    @Column(name = "IdEstatusCliente")
    private Integer idEstatusCliente;
    @Column(name = "IdGarantia")
    private Integer idGarantia;
    @Column(name = "MontoGarantia")
    private BigDecimal montoGarantia;
    @Column(name = "FechaUltFactura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltFactura;
    @Size(max = 15)
    @Column(name = "IdGestor")
    private String idGestor;
    @JoinColumn(name = "IdCobrador", referencedColumnName = "IdVendedor")
    @ManyToOne(optional = false)
    private Vendedores idCobrador;
    @JoinColumn(name = "IdVendedor", referencedColumnName = "IdVendedor")
    @ManyToOne(optional = false)
    private Vendedores idVendedor;
    @JoinColumn(name = "TipoVineta", referencedColumnName = "TipoVineta")
    @ManyToOne(optional = false)
    private TiposVineta tipoVineta;
    @JoinColumn(name = "CCTipo", referencedColumnName = "CCTipo")
    @ManyToOne
    private TiposCC cCTipo;
    @JoinColumn(name = "IdTerritorio", referencedColumnName = "IdTerritorio")
    @ManyToOne(optional = false)
    private Territorios idTerritorio;
    @JoinColumn(name = "IdTermino", referencedColumnName = "IdTermino")
    @ManyToOne(optional = false)
    private Terminos idTermino;
    @JoinColumn(name = "IdSucursal", referencedColumnName = "IdSucursal")
    @ManyToOne(optional = false)
    private Sucursales idSucursal;
    @JoinColumn(name = "IdRuta", referencedColumnName = "IdRuta")
    @ManyToOne(optional = false)
    private Rutas idRuta;
    @JoinColumn(name = "IdEscala", referencedColumnName = "IdEscala")
    @ManyToOne(optional = false)
    private Escalas idEscala;
    @JoinColumn(name = "IdCategoria", referencedColumnName = "IdCategoria")
    @ManyToOne(optional = false)
    private Categorias idCategoria;
*/
    public Clientes() {
    }

    public Clientes(String idCliente) {
        this.idCliente = idCliente;
    }
  public Clientes(String idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
       
    }

   /* public Clientes(String idCliente, String nombre, String razonSocial, String tipoIVA, boolean bonificacion, BigDecimal tasaDesc, BigDecimal limite, int vencimiento, boolean activo, String idCtaCont1, String bitacora) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.tipoIVA = tipoIVA;
        this.bonificacion = bonificacion;
        this.tasaDesc = tasaDesc;
        this.limite = limite;
        this.vencimiento = vencimiento;
        this.activo = activo;
        this.idCtaCont1 = idCtaCont1;
        this.bitacora = bitacora;
    }
*/
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/*
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRegFiscal() {
        return regFiscal;
    }

    public void setRegFiscal(String regFiscal) {
        this.regFiscal = regFiscal;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getTipoIVA() {
        return tipoIVA;
    }

    public void setTipoIVA(String tipoIVA) {
        this.tipoIVA = tipoIVA;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public boolean getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(boolean bonificacion) {
        this.bonificacion = bonificacion;
    }

    public BigDecimal getTasaDesc() {
        return tasaDesc;
    }

    public void setTasaDesc(BigDecimal tasaDesc) {
        this.tasaDesc = tasaDesc;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public int getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(int vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getEnviarA() {
        return enviarA;
    }

    public void setEnviarA(String enviarA) {
        this.enviarA = enviarA;
    }

    public String getFacturarA() {
        return facturarA;
    }

    public void setFacturarA(String facturarA) {
        this.facturarA = facturarA;
    }

    public String getCCNombre() {
        return cCNombre;
    }

    public void setCCNombre(String cCNombre) {
        this.cCNombre = cCNombre;
    }

    public String getCCNumero() {
        return cCNumero;
    }

    public void setCCNumero(String cCNumero) {
        this.cCNumero = cCNumero;
    }

    public String getCCVerificador() {
        return cCVerificador;
    }

    public void setCCVerificador(String cCVerificador) {
        this.cCVerificador = cCVerificador;
    }

    public Date getCCExpira() {
        return cCExpira;
    }

    public void setCCExpira(Date cCExpira) {
        this.cCExpira = cCExpira;
    }

    public String getCCBanco() {
        return cCBanco;
    }

    public void setCCBanco(String cCBanco) {
        this.cCBanco = cCBanco;
    }

    public String getIdPromotor() {
        return idPromotor;
    }

    public void setIdPromotor(String idPromotor) {
        this.idPromotor = idPromotor;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getIdCtaCont1() {
        return idCtaCont1;
    }

    public void setIdCtaCont1(String idCtaCont1) {
        this.idCtaCont1 = idCtaCont1;
    }

    public String getIdCtaCont2() {
        return idCtaCont2;
    }

    public void setIdCtaCont2(String idCtaCont2) {
        this.idCtaCont2 = idCtaCont2;
    }

    public String getIdCtaCont3() {
        return idCtaCont3;
    }

    public void setIdCtaCont3(String idCtaCont3) {
        this.idCtaCont3 = idCtaCont3;
    }

    public String getIdCtaCont4() {
        return idCtaCont4;
    }

    public void setIdCtaCont4(String idCtaCont4) {
        this.idCtaCont4 = idCtaCont4;
    }

    public String getIdCtaCont5() {
        return idCtaCont5;
    }

    public void setIdCtaCont5(String idCtaCont5) {
        this.idCtaCont5 = idCtaCont5;
    }

    public String getIdCtaCont6() {
        return idCtaCont6;
    }

    public void setIdCtaCont6(String idCtaCont6) {
        this.idCtaCont6 = idCtaCont6;
    }

    public String getIdCtaCont7() {
        return idCtaCont7;
    }

    public void setIdCtaCont7(String idCtaCont7) {
        this.idCtaCont7 = idCtaCont7;
    }

    public String getIdCtaCont8() {
        return idCtaCont8;
    }

    public void setIdCtaCont8(String idCtaCont8) {
        this.idCtaCont8 = idCtaCont8;
    }

    public String getAviso() {
        return aviso;
    }

    public void setAviso(String aviso) {
        this.aviso = aviso;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getBitacora() {
        return bitacora;
    }

    public void setBitacora(String bitacora) {
        this.bitacora = bitacora;
    }

    public Integer getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Integer idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public Date getFechaInactivo() {
        return fechaInactivo;
    }

    public void setFechaInactivo(Date fechaInactivo) {
        this.fechaInactivo = fechaInactivo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getIdEstatusCliente() {
        return idEstatusCliente;
    }

    public void setIdEstatusCliente(Integer idEstatusCliente) {
        this.idEstatusCliente = idEstatusCliente;
    }

    public Integer getIdGarantia() {
        return idGarantia;
    }

    public void setIdGarantia(Integer idGarantia) {
        this.idGarantia = idGarantia;
    }

    public BigDecimal getMontoGarantia() {
        return montoGarantia;
    }

    public void setMontoGarantia(BigDecimal montoGarantia) {
        this.montoGarantia = montoGarantia;
    }

    public Date getFechaUltFactura() {
        return fechaUltFactura;
    }

    public void setFechaUltFactura(Date fechaUltFactura) {
        this.fechaUltFactura = fechaUltFactura;
    }

    public String getIdGestor() {
        return idGestor;
    }

    public void setIdGestor(String idGestor) {
        this.idGestor = idGestor;
    }

    public Vendedores getIdCobrador() {
        return idCobrador;
    }

    public void setIdCobrador(Vendedores idCobrador) {
        this.idCobrador = idCobrador;
    }

    public Vendedores getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Vendedores idVendedor) {
        this.idVendedor = idVendedor;
    }

    public TiposVineta getTipoVineta() {
        return tipoVineta;
    }

    public void setTipoVineta(TiposVineta tipoVineta) {
        this.tipoVineta = tipoVineta;
    }

    public TiposCC getCCTipo() {
        return cCTipo;
    }

    public void setCCTipo(TiposCC cCTipo) {
        this.cCTipo = cCTipo;
    }

    public Territorios getIdTerritorio() {
        return idTerritorio;
    }

    public void setIdTerritorio(Territorios idTerritorio) {
        this.idTerritorio = idTerritorio;
    }

    public Terminos getIdTermino() {
        return idTermino;
    }

    public void setIdTermino(Terminos idTermino) {
        this.idTermino = idTermino;
    }

    public Sucursales getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursales idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Rutas getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Rutas idRuta) {
        this.idRuta = idRuta;
    }

    public Escalas getIdEscala() {
        return idEscala;
    }

    public void setIdEscala(Escalas idEscala) {
        this.idEscala = idEscala;
    }

    public Categorias getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categorias idCategoria) {
        this.idCategoria = idCategoria;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rudysorto.jpa.Clientes[ idCliente=" + idCliente + " ]";
    }
    
}
