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
import javax.persistence.Lob;
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
@Table(name = "Productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByIdProducto", query = "SELECT p FROM Productos p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Productos.findByNombre", query = "SELECT p FROM Productos p WHERE p.nombre = :nombre"),
  /*  @NamedQuery(name = "Productos.findByDescripcion", query = "SELECT p FROM Productos p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Productos.findByIdSucursal", query = "SELECT p FROM Productos p WHERE p.idSucursal = :idSucursal"),
    @NamedQuery(name = "Productos.findByCosto", query = "SELECT p FROM Productos p WHERE p.costo = :costo"),
    @NamedQuery(name = "Productos.findByCostoAnt", query = "SELECT p FROM Productos p WHERE p.costoAnt = :costoAnt"),
    @NamedQuery(name = "Productos.findByCostoStd", query = "SELECT p FROM Productos p WHERE p.costoStd = :costoStd"),
    @NamedQuery(name = "Productos.findByTipoCosto", query = "SELECT p FROM Productos p WHERE p.tipoCosto = :tipoCosto"),
    @NamedQuery(name = "Productos.findByExistMin", query = "SELECT p FROM Productos p WHERE p.existMin = :existMin"),
    @NamedQuery(name = "Productos.findByConsumoProm", query = "SELECT p FROM Productos p WHERE p.consumoProm = :consumoProm"),
    @NamedQuery(name = "Productos.findByTiempoExistMin", query = "SELECT p FROM Productos p WHERE p.tiempoExistMin = :tiempoExistMin"),
    @NamedQuery(name = "Productos.findByTipoIVA", query = "SELECT p FROM Productos p WHERE p.tipoIVA = :tipoIVA"),
    @NamedQuery(name = "Productos.findByRegSanitario", query = "SELECT p FROM Productos p WHERE p.regSanitario = :regSanitario"),
    @NamedQuery(name = "Productos.findByFormaFarma", query = "SELECT p FROM Productos p WHERE p.formaFarma = :formaFarma"),
    @NamedQuery(name = "Productos.findByConcentracion", query = "SELECT p FROM Productos p WHERE p.concentracion = :concentracion"),
    @NamedQuery(name = "Productos.findByVidaUtil", query = "SELECT p FROM Productos p WHERE p.vidaUtil = :vidaUtil"),
    @NamedQuery(name = "Productos.findByIdProveedor", query = "SELECT p FROM Productos p WHERE p.idProveedor = :idProveedor"),
    @NamedQuery(name = "Productos.findByHomologado", query = "SELECT p FROM Productos p WHERE p.homologado = :homologado"),
    @NamedQuery(name = "Productos.findByControlado", query = "SELECT p FROM Productos p WHERE p.controlado = :controlado"),
    @NamedQuery(name = "Productos.findByCombo", query = "SELECT p FROM Productos p WHERE p.combo = :combo"),
    @NamedQuery(name = "Productos.findByAfectaInv", query = "SELECT p FROM Productos p WHERE p.afectaInv = :afectaInv"),
    @NamedQuery(name = "Productos.findByActivo", query = "SELECT p FROM Productos p WHERE p.activo = :activo"),
    @NamedQuery(name = "Productos.findByPeso", query = "SELECT p FROM Productos p WHERE p.peso = :peso"),
    @NamedQuery(name = "Productos.findByMedida", query = "SELECT p FROM Productos p WHERE p.medida = :medida"),
    @NamedQuery(name = "Productos.findByTalla", query = "SELECT p FROM Productos p WHERE p.talla = :talla"),
    @NamedQuery(name = "Productos.findByColor", query = "SELECT p FROM Productos p WHERE p.color = :color"),
    @NamedQuery(name = "Productos.findByColores", query = "SELECT p FROM Productos p WHERE p.colores = :colores"),
    @NamedQuery(name = "Productos.findByAbc", query = "SELECT p FROM Productos p WHERE p.abc = :abc"),
    @NamedQuery(name = "Productos.findByGarantia", query = "SELECT p FROM Productos p WHERE p.garantia = :garantia"),
    @NamedQuery(name = "Productos.findBySerieLote", query = "SELECT p FROM Productos p WHERE p.serieLote = :serieLote"),
    @NamedQuery(name = "Productos.findBySubstituto1", query = "SELECT p FROM Productos p WHERE p.substituto1 = :substituto1"),
    @NamedQuery(name = "Productos.findBySubstituto2", query = "SELECT p FROM Productos p WHERE p.substituto2 = :substituto2"),
    @NamedQuery(name = "Productos.findByIdCtaCont1", query = "SELECT p FROM Productos p WHERE p.idCtaCont1 = :idCtaCont1"),
    @NamedQuery(name = "Productos.findByIdCtaCont2", query = "SELECT p FROM Productos p WHERE p.idCtaCont2 = :idCtaCont2"),
    @NamedQuery(name = "Productos.findByIdCtaCont3", query = "SELECT p FROM Productos p WHERE p.idCtaCont3 = :idCtaCont3"),
    @NamedQuery(name = "Productos.findByIdCtaCont4", query = "SELECT p FROM Productos p WHERE p.idCtaCont4 = :idCtaCont4"),
    @NamedQuery(name = "Productos.findByIdCtaCont5", query = "SELECT p FROM Productos p WHERE p.idCtaCont5 = :idCtaCont5"),
    @NamedQuery(name = "Productos.findByIdCtaCont6", query = "SELECT p FROM Productos p WHERE p.idCtaCont6 = :idCtaCont6"),
    @NamedQuery(name = "Productos.findByIdCtaCont7", query = "SELECT p FROM Productos p WHERE p.idCtaCont7 = :idCtaCont7"),
    @NamedQuery(name = "Productos.findByIdCtaCont8", query = "SELECT p FROM Productos p WHERE p.idCtaCont8 = :idCtaCont8"),
    @NamedQuery(name = "Productos.findByBitacora", query = "SELECT p FROM Productos p WHERE p.bitacora = :bitacora"),
    @NamedQuery(name = "Productos.findByDescontinuado", query = "SELECT p FROM Productos p WHERE p.descontinuado = :descontinuado"),
    @NamedQuery(name = "Productos.findByNombreLic", query = "SELECT p FROM Productos p WHERE p.nombreLic = :nombreLic"),
    @NamedQuery(name = "Productos.findByCostob", query = "SELECT p FROM Productos p WHERE p.costob = :costob"),
    @NamedQuery(name = "Productos.findByBloqueoregistros", query = "SELECT p FROM Productos p WHERE p.bloqueoregistros = :bloqueoregistros")})
*/
    })
public class Productos implements Serializable {
  /*  @Size(max = 1073741823)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "IdSucursal")
    private String idSucursal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Costo")
    private BigDecimal costo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CostoAnt")
    private BigDecimal costoAnt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CostoStd")
    private BigDecimal costoStd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "TipoCosto")
    private String tipoCosto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ExistMin")
    private BigDecimal existMin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ConsumoProm")
    private BigDecimal consumoProm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TiempoExistMin")
    private short tiempoExistMin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "TipoIVA")
    private String tipoIVA;
    @Size(max = 25)
    @Column(name = "RegSanitario")
    private String regSanitario;
    @Size(max = 100)
    @Column(name = "FormaFarma")
    private String formaFarma;
    @Size(max = 100)
    @Column(name = "Concentracion")
    private String concentracion;
    @Column(name = "VidaUtil")
    private Short vidaUtil;
    @Size(max = 15)
    @Column(name = "IdProveedor")
    private String idProveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Homologado")
    private boolean homologado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Controlado")
    private boolean controlado;
    @Size(max = 15)
    @Column(name = "Combo")
    private String combo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AfectaInv")
    private boolean afectaInv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Activo")
    private boolean activo;
    @Column(name = "Peso")
    private BigDecimal peso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Medida")
    private BigDecimal medida;
    @Size(max = 15)
    @Column(name = "Talla")
    private String talla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Color")
    private String color;
    @Size(max = 1073741823)
    @Column(name = "Colores")
    private String colores;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ABC")
    private String abc;
    @Column(name = "Garantia")
    private BigDecimal garantia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SerieLote")
    private String serieLote;
    @Size(max = 15)
    @Column(name = "Substituto1")
    private String substituto1;
    @Size(max = 15)
    @Column(name = "Substituto2")
    private String substituto2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "IdCtaCont1")
    private String idCtaCont1;
    @Size(max = 25)
    @Column(name = "IdCtaCont2")
    private String idCtaCont2;
    @Size(max = 25)
    @Column(name = "IdCtaCont3")
    private String idCtaCont3;
    @Size(max = 25)
    @Column(name = "IdCtaCont4")
    private String idCtaCont4;
    @Size(max = 25)
    @Column(name = "IdCtaCont5")
    private String idCtaCont5;
    @Size(max = 25)
    @Column(name = "IdCtaCont6")
    private String idCtaCont6;
    @Size(max = 25)
    @Column(name = "IdCtaCont7")
    private String idCtaCont7;
    @Size(max = 25)
    @Column(name = "IdCtaCont8")
    private String idCtaCont8;
    @Lob
    @Column(name = "Foto")
    private byte[] foto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "Bitacora")
    private String bitacora;
    @Column(name = "Descontinuado")
    private Boolean descontinuado;
    @Size(max = 1073741823)
    @Column(name = "NombreLic")
    private String nombreLic;
    @Column(name = "Costo_b")
    private BigDecimal costob;
    @Column(name = "bloqueoregistros")
    private Boolean bloqueoregistros;
    @JoinColumn(name = "IdUnidad", referencedColumnName = "IdUnidad")
    @ManyToOne(optional = false)
    private Unidades idUnidad;
    @JoinColumn(name = "TipoProd", referencedColumnName = "TipoProd")
    @ManyToOne(optional = false)
    private TiposProd tipoProd;
    @JoinColumn(name = "IdSubgrupo", referencedColumnName = "IdSubgrupo")
    @ManyToOne(optional = false)
    private Subgrupos idSubgrupo;
    @JoinColumn(name = "IdFamilia", referencedColumnName = "IdSubgrupo")
    @ManyToOne
    private Subgrupos idFamilia;
    @JoinColumn(name = "IdPresenta", referencedColumnName = "IdPresenta")
    @ManyToOne(optional = false)
    private Presentaciones idPresenta;
    @JoinColumn(name = "IdMarca", referencedColumnName = "IdMarca")
    @ManyToOne(optional = false)
    private Marcas idMarca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<RegistrosMMdet> registrosMMdetList;
    */
    
 @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "IdProducto")
    private String idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nombre")
    private String nombre;
   @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "IdUnidad")
    private String idUnidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "IdBodega")
    private String idBodega;
     @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "IdEstatus")
    private String idEstatus;
      @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Lote")
    private String lote;
  /*  @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private List<BodegaVirtualMM> bodegaVirtualMMList;
    * */
  /*  @Lob
    @Column(name = "Foto")
    private byte[] foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private List<Existencias> existenciasList;
    private static final long serialVersionUID = 1L;*/

    public String getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(String idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(String idBodega) {
        this.idBodega = idBodega;
    }

    public String getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(String idEstatus) {
        this.idEstatus = idEstatus;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Productos(String idProducto, String nombre, String idUnidad, String idBodega, String idEstatus, String lote) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.idUnidad = idUnidad;
        this.idBodega = idBodega;
        this.idEstatus = idEstatus;
        this.lote = lote;
    }
    
    
    
  
    /*  @Size(max = 1073741823)
  @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "IdSucursal")
    private String idSucursal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Costo")
    private BigDecimal costo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CostoAnt")
    private BigDecimal costoAnt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CostoStd")
    private BigDecimal costoStd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "TipoCosto")
    private String tipoCosto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ExistMin")
    private BigDecimal existMin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ConsumoProm")
    private BigDecimal consumoProm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TiempoExistMin")
    private short tiempoExistMin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "TipoIVA")
    private String tipoIVA;
    @Size(max = 25)
    @Column(name = "RegSanitario")
    private String regSanitario;
    @Size(max = 100)
    @Column(name = "FormaFarma")
    private String formaFarma;
    @Size(max = 100)
    @Column(name = "Concentracion")
    private String concentracion;
    @Column(name = "VidaUtil")
    private Short vidaUtil;
    @Size(max = 15)
    @Column(name = "IdProveedor")
    private String idProveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Homologado")
    private boolean homologado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Controlado")
    private boolean controlado;
    @Size(max = 15)
    @Column(name = "Combo")
    private String combo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AfectaInv")
    private boolean afectaInv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Activo")
    private boolean activo;
    @Column(name = "Peso")
    private BigDecimal peso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Medida")
    private BigDecimal medida;
    @Size(max = 15)
    @Column(name = "Talla")
    private String talla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Color")
    private String color;
    @Size(max = 1073741823)
    @Column(name = "Colores")
    private String colores;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ABC")
    private String abc;
    @Column(name = "Garantia")
    private BigDecimal garantia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SerieLote")
    private String serieLote;
    @Size(max = 15)
    @Column(name = "Substituto1")
    private String substituto1;
    @Size(max = 15)
    @Column(name = "Substituto2")
    private String substituto2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "IdCtaCont1")
    private String idCtaCont1;
    @Size(max = 25)
    @Column(name = "IdCtaCont2")
    private String idCtaCont2;
    @Size(max = 25)
    @Column(name = "IdCtaCont3")
    private String idCtaCont3;
    @Size(max = 25)
    @Column(name = "IdCtaCont4")
    private String idCtaCont4;
    @Size(max = 25)
    @Column(name = "IdCtaCont5")
    private String idCtaCont5;
    @Size(max = 25)
    @Column(name = "IdCtaCont6")
    private String idCtaCont6;
    @Size(max = 25)
    @Column(name = "IdCtaCont7")
    private String idCtaCont7;
    @Size(max = 25)
    @Column(name = "IdCtaCont8")
    private String idCtaCont8;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "Bitacora")
    private String bitacora;
    @Column(name = "Descontinuado")
    private Boolean descontinuado;
    @Size(max = 1073741823)
    @Column(name = "NombreLic")
    private String nombreLic;
    @Column(name = "Costo_b")
    private BigDecimal costob;
    @Column(name = "bloqueoregistros")
    private Boolean bloqueoregistros;
    @JoinColumn(name = "IdUnidad", referencedColumnName = "IdUnidad")
    @ManyToOne(optional = false)
    private Unidades idUnidad;
    @JoinColumn(name = "TipoProd", referencedColumnName = "TipoProd")
    @ManyToOne(optional = false)
    private TiposProd tipoProd;
    @JoinColumn(name = "IdSubgrupo", referencedColumnName = "IdSubgrupo")
    @ManyToOne(optional = false)
    private Subgrupos idSubgrupo;
    @JoinColumn(name = "IdFamilia", referencedColumnName = "IdSubgrupo")
    @ManyToOne
    private Subgrupos idFamilia;
    @JoinColumn(name = "IdPresenta", referencedColumnName = "IdPresenta")
    @ManyToOne(optional = false)
    private Presentaciones idPresenta;
    @JoinColumn(name = "IdMarca", referencedColumnName = "IdMarca")
    @ManyToOne(optional = false)
    private Marcas idMarca;
*/
    public Productos() {
    }

    public Productos(String idProducto) {
        this.idProducto = idProducto;
    }

  /* public Productos(String idProducto, String nombre, String idSucursal, BigDecimal costo, BigDecimal costoAnt, BigDecimal costoStd, String tipoCosto, BigDecimal existMin, BigDecimal consumoProm, short tiempoExistMin, String tipoIVA, boolean homologado, boolean controlado, boolean afectaInv, boolean activo, BigDecimal medida, String color, String abc, String serieLote, String idCtaCont1, String bitacora) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.idSucursal = idSucursal;
        this.costo = costo;
        this.costoAnt = costoAnt;
        this.costoStd = costoStd;
        this.tipoCosto = tipoCosto;
        this.existMin = existMin;
        this.consumoProm = consumoProm;
        this.tiempoExistMin = tiempoExistMin;
        this.tipoIVA = tipoIVA;
        this.homologado = homologado;
        this.controlado = controlado;
        this.afectaInv = afectaInv;
        this.activo = activo;
        this.medida = medida;
        this.color = color;
        this.abc = abc;
        this.serieLote = serieLote;
        this.idCtaCont1 = idCtaCont1;
        this.bitacora = bitacora;
    }*/
    
     public Productos(String idProducto, String nombre) {
        this.idProducto = idProducto;
        this.nombre = nombre;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   /* public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getCostoAnt() {
        return costoAnt;
    }

    public void setCostoAnt(BigDecimal costoAnt) {
        this.costoAnt = costoAnt;
    }

    public BigDecimal getCostoStd() {
        return costoStd;
    }

    public void setCostoStd(BigDecimal costoStd) {
        this.costoStd = costoStd;
    }

    public String getTipoCosto() {
        return tipoCosto;
    }

    public void setTipoCosto(String tipoCosto) {
        this.tipoCosto = tipoCosto;
    }

    public BigDecimal getExistMin() {
        return existMin;
    }

    public void setExistMin(BigDecimal existMin) {
        this.existMin = existMin;
    }

    public BigDecimal getConsumoProm() {
        return consumoProm;
    }

    public void setConsumoProm(BigDecimal consumoProm) {
        this.consumoProm = consumoProm;
    }

    public short getTiempoExistMin() {
        return tiempoExistMin;
    }

    public void setTiempoExistMin(short tiempoExistMin) {
        this.tiempoExistMin = tiempoExistMin;
    }

    public String getTipoIVA() {
        return tipoIVA;
    }

    public void setTipoIVA(String tipoIVA) {
        this.tipoIVA = tipoIVA;
    }

    public String getRegSanitario() {
        return regSanitario;
    }

    public void setRegSanitario(String regSanitario) {
        this.regSanitario = regSanitario;
    }

    public String getFormaFarma() {
        return formaFarma;
    }

    public void setFormaFarma(String formaFarma) {
        this.formaFarma = formaFarma;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public Short getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(Short vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public boolean getHomologado() {
        return homologado;
    }

    public void setHomologado(boolean homologado) {
        this.homologado = homologado;
    }

    public boolean getControlado() {
        return controlado;
    }

    public void setControlado(boolean controlado) {
        this.controlado = controlado;
    }

    public String getCombo() {
        return combo;
    }

    public void setCombo(String combo) {
        this.combo = combo;
    }

    public boolean getAfectaInv() {
        return afectaInv;
    }

    public void setAfectaInv(boolean afectaInv) {
        this.afectaInv = afectaInv;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getMedida() {
        return medida;
    }

    public void setMedida(BigDecimal medida) {
        this.medida = medida;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColores() {
        return colores;
    }

    public void setColores(String colores) {
        this.colores = colores;
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public BigDecimal getGarantia() {
        return garantia;
    }

    public void setGarantia(BigDecimal garantia) {
        this.garantia = garantia;
    }

    public String getSerieLote() {
        return serieLote;
    }

    public void setSerieLote(String serieLote) {
        this.serieLote = serieLote;
    }

    public String getSubstituto1() {
        return substituto1;
    }

    public void setSubstituto1(String substituto1) {
        this.substituto1 = substituto1;
    }

    public String getSubstituto2() {
        return substituto2;
    }

    public void setSubstituto2(String substituto2) {
        this.substituto2 = substituto2;
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

    public String getBitacora() {
        return bitacora;
    }

    public void setBitacora(String bitacora) {
        this.bitacora = bitacora;
    }

    public Boolean getDescontinuado() {
        return descontinuado;
    }

    public void setDescontinuado(Boolean descontinuado) {
        this.descontinuado = descontinuado;
    }

    public String getNombreLic() {
        return nombreLic;
    }

    public void setNombreLic(String nombreLic) {
        this.nombreLic = nombreLic;
    }

    public BigDecimal getCostob() {
        return costob;
    }

    public void setCostob(BigDecimal costob) {
        this.costob = costob;
    }

    public Boolean getBloqueoregistros() {
        return bloqueoregistros;
    }

    public void setBloqueoregistros(Boolean bloqueoregistros) {
        this.bloqueoregistros = bloqueoregistros;
    }

    public Unidades getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Unidades idUnidad) {
        this.idUnidad = idUnidad;
    }

    public TiposProd getTipoProd() {
        return tipoProd;
    }

    public void setTipoProd(TiposProd tipoProd) {
        this.tipoProd = tipoProd;
    }

    public Subgrupos getIdSubgrupo() {
        return idSubgrupo;
    }

    public void setIdSubgrupo(Subgrupos idSubgrupo) {
        this.idSubgrupo = idSubgrupo;
    }

    public Subgrupos getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Subgrupos idFamilia) {
        this.idFamilia = idFamilia;
    }

    public Presentaciones getIdPresenta() {
        return idPresenta;
    }

    public void setIdPresenta(Presentaciones idPresenta) {
        this.idPresenta = idPresenta;
    }

    public Marcas getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marcas idMarca) {
        this.idMarca = idMarca;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rudysorto.jpa.Productos[ idProducto=" + idProducto + " ]";
    }

 /*   public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @XmlTransient
    public List<Existencias> getExistenciasList() {
        return existenciasList;
    }

    public void setExistenciasList(List<Existencias> existenciasList) {
        this.existenciasList = existenciasList;
    }*/


/*
    @XmlTransient
    public List<BodegaVirtualMM> getBodegaVirtualMMList() {
        return bodegaVirtualMMList;
    }

    public void setBodegaVirtualMMList(List<BodegaVirtualMM> bodegaVirtualMMList) {
        this.bodegaVirtualMMList = bodegaVirtualMMList;
    }*/
/*
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getCostoAnt() {
        return costoAnt;
    }

    public void setCostoAnt(BigDecimal costoAnt) {
        this.costoAnt = costoAnt;
    }

    public BigDecimal getCostoStd() {
        return costoStd;
    }

    public void setCostoStd(BigDecimal costoStd) {
        this.costoStd = costoStd;
    }

    public String getTipoCosto() {
        return tipoCosto;
    }

    public void setTipoCosto(String tipoCosto) {
        this.tipoCosto = tipoCosto;
    }

    public BigDecimal getExistMin() {
        return existMin;
    }

    public void setExistMin(BigDecimal existMin) {
        this.existMin = existMin;
    }

    public BigDecimal getConsumoProm() {
        return consumoProm;
    }

    public void setConsumoProm(BigDecimal consumoProm) {
        this.consumoProm = consumoProm;
    }

    public short getTiempoExistMin() {
        return tiempoExistMin;
    }

    public void setTiempoExistMin(short tiempoExistMin) {
        this.tiempoExistMin = tiempoExistMin;
    }

    public String getTipoIVA() {
        return tipoIVA;
    }

    public void setTipoIVA(String tipoIVA) {
        this.tipoIVA = tipoIVA;
    }

    public String getRegSanitario() {
        return regSanitario;
    }

    public void setRegSanitario(String regSanitario) {
        this.regSanitario = regSanitario;
    }

    public String getFormaFarma() {
        return formaFarma;
    }

    public void setFormaFarma(String formaFarma) {
        this.formaFarma = formaFarma;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public Short getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(Short vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public boolean getHomologado() {
        return homologado;
    }

    public void setHomologado(boolean homologado) {
        this.homologado = homologado;
    }

    public boolean getControlado() {
        return controlado;
    }

    public void setControlado(boolean controlado) {
        this.controlado = controlado;
    }

    public String getCombo() {
        return combo;
    }

    public void setCombo(String combo) {
        this.combo = combo;
    }

    public boolean getAfectaInv() {
        return afectaInv;
    }

    public void setAfectaInv(boolean afectaInv) {
        this.afectaInv = afectaInv;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getMedida() {
        return medida;
    }

    public void setMedida(BigDecimal medida) {
        this.medida = medida;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColores() {
        return colores;
    }

    public void setColores(String colores) {
        this.colores = colores;
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public BigDecimal getGarantia() {
        return garantia;
    }

    public void setGarantia(BigDecimal garantia) {
        this.garantia = garantia;
    }

    public String getSerieLote() {
        return serieLote;
    }

    public void setSerieLote(String serieLote) {
        this.serieLote = serieLote;
    }

    public String getSubstituto1() {
        return substituto1;
    }

    public void setSubstituto1(String substituto1) {
        this.substituto1 = substituto1;
    }

    public String getSubstituto2() {
        return substituto2;
    }

    public void setSubstituto2(String substituto2) {
        this.substituto2 = substituto2;
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

    public Boolean getDescontinuado() {
        return descontinuado;
    }

    public void setDescontinuado(Boolean descontinuado) {
        this.descontinuado = descontinuado;
    }

    public String getNombreLic() {
        return nombreLic;
    }

    public void setNombreLic(String nombreLic) {
        this.nombreLic = nombreLic;
    }

    public BigDecimal getCostob() {
        return costob;
    }

    public void setCostob(BigDecimal costob) {
        this.costob = costob;
    }

    public Boolean getBloqueoregistros() {
        return bloqueoregistros;
    }

    public void setBloqueoregistros(Boolean bloqueoregistros) {
        this.bloqueoregistros = bloqueoregistros;
    }

    public Unidades getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Unidades idUnidad) {
        this.idUnidad = idUnidad;
    }

    public TiposProd getTipoProd() {
        return tipoProd;
    }

    public void setTipoProd(TiposProd tipoProd) {
        this.tipoProd = tipoProd;
    }

    public Subgrupos getIdSubgrupo() {
        return idSubgrupo;
    }

    public void setIdSubgrupo(Subgrupos idSubgrupo) {
        this.idSubgrupo = idSubgrupo;
    }

    public Subgrupos getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Subgrupos idFamilia) {
        this.idFamilia = idFamilia;
    }

    public Presentaciones getIdPresenta() {
        return idPresenta;
    }

    public void setIdPresenta(Presentaciones idPresenta) {
        this.idPresenta = idPresenta;
    }

    public Marcas getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marcas idMarca) {
        this.idMarca = idMarca;
    }

    @XmlTransient
    public List<RegistrosMMdet> getRegistrosMMdetList() {
        return registrosMMdetList;
    }

    public void setRegistrosMMdetList(List<RegistrosMMdet> registrosMMdetList) {
        this.registrosMMdetList = registrosMMdetList;
    }
    */
}
