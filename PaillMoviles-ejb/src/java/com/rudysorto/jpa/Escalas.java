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
@Entity
@Table(name = "Escalas")
@XmlRootElement
@NamedQueries({
  /*  @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByIdProducto", query = "SELECT p FROM Productos p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Productos.findByNombre", query = "SELECT p FROM Productos p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Productos.findByDescripcion", query = "SELECT p FROM Productos p WHERE p.descripcion = :descripcion"),
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
public class Escalas implements Serializable {
         @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "IdEscala")
    private String idEscala;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nombre")
    private String nombre;
   @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Precio")
    private String precio;

    public String getIdEscala() {
        return idEscala;
    }

    public void setIdEscala(String idEscala) {
        this.idEscala = idEscala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Escalas(String idEscala, String nombre, String precio) {
        this.idEscala = idEscala;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Escalas() {
    }

    @Override
    public String toString() {
        return "Escala{" + "idEscala=" + idEscala + ", nombre=" + nombre + ", precio=" + precio + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.idEscala != null ? this.idEscala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Escalas other = (Escalas) obj;
        if ((this.idEscala == null) ? (other.idEscala != null) : !this.idEscala.equals(other.idEscala)) {
            return false;
        }
        return true;
    }
   
   
}
