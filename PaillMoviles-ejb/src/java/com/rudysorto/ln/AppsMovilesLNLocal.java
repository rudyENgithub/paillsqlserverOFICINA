/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.ln;

import com.rudysorto.jpa.AppMoviles;
import com.rudysorto.jpa.Clientes;
import com.rudysorto.jpa.OpcionesAppMoviles;
import com.rudysorto.jpa.ProductoMM;
import com.rudysorto.jpa.Productos;
import com.rudysorto.jpa.RegistrosMM;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rsorto
 */
@Local
public interface AppsMovilesLNLocal {
    public void guardar(AppMoviles producto);

    public void eliminar(AppMoviles producto);

    public void actualizar(AppMoviles producto);

    public List<AppMoviles> selectAll();

    public List<OpcionesAppMoviles> selectLike(String par);
    
    public List<OpcionesAppMoviles> selectOpcionesXapp(int par);
    
    public List<Productos> productosLike(String par, String id);
    
     public List<Clientes> clientesLike(String par);
     
     public List<ProductoMM> productosBodega(String par);
     
     public List<RegistrosMM> registrosMMPorVendedor(String par);
     
     
}
