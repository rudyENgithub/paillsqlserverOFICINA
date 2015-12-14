/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.ln;

import com.rudysorto.jpa.AppMoviles;
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

    public List<AppMoviles> selectLike(String par);
    
}
