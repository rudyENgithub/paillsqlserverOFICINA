/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.dao;

import com.rudysorto.jpa.AppMoviles;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author rsorto
 */
@Stateless
public class AppMovilesFacade extends AbstractFacade<AppMoviles> implements AppMovilesFacadeLocal {

    @PersistenceContext(unitName = "PaillMoviles-ejbPU")
    private EntityManager em;
    private List<AppMoviles> appporperfilList;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AppMovilesFacade() {
        super(AppMoviles.class);
    }

    @Override
    public List<AppMoviles> listaAppsPerfil(String par) {
        /*@NamedQuery(name = "Tproducto.findInnerProductoFabricante", query = 
         "SELECT t FROM Tproducto t JOIN t.Tfabricante f WHERE t.nombre = :nombre OR f.nombre = :nombref"),
         */
        //  String jpql = "SELECT t FROM Tproducto t WHERE t.nombre LIKE 'Cer%'";
        //    String jpql = "SELECT t FROM Tproducto t WHERE t.nombre LIKE :par";
        // String jpql = "SELECT t FROM Tproducto t JOIN t.tfabricante f WHERE t.nombre LIKE :par OR f.nombre LIKE :par";
        //  String jpql = "SELECT t FROM Tproducto t WHERE t.nombre = ?1";
        // SELECT c1, c2 FROM Country c1 INNER JOIN c1.neighbors c2
       /* String jpql =   "select us.UID, us.Nombre  as 'NombreUsuario' , pm.Nombre  as 'NombrePerfil', pm.Descripcion  as 'DescripcionPerfil' ,\n" +
         " am.Nombre  as NombreApp, am.Descripcion as 'DescripcionMovil' , am.Logo from Usuarios us inner join PerfilesMoviles pm \n" +
         "on us.IdPerfilMovil = pm.IdPerfilMovil inner join AppPorPerfiles ap on us.IdPerfilMovil = ap.IdPerfilMovil\n" +
         "inner join AppMoviles am on ap.IdAppMovil = am.IdAppMovil\n" +
         "where us.UID = :par" ;*/

        /* select am.* from AppMoviles  am inner join AppPorPerfiles ap on am.idAppMovil
         = ap.IdAppMovil where ap.idPerfilMovil = 1*/

        String jpql1 = "SELECT am.* from Usuarios us inner join PerfilesMoviles pm on us.idPerfilMovil = pm.idPerfilMovil inner join AppPorPerfiles ap on pm.idPerfilMovil = ap.idPerfilMovil inner join AppMoviles am on ap.idAppMovil = am.IdAppMovil where us.UID = ?";
        String jpqlx = "SELECT m FROM AppMoviles m WHERE m.idAppMovil = :par ";
        /*  @NamedQuery(name = "BlogMembers.findBlogsOnWhichCommentsAreMade", 
         query = "SELECT bm.blogId FROM BlogMembers bm INNER JOIN bm.blogId b 
         INNER JOIN b.blogPostsList bp INNER JOIN bp.blogPostCommentList bpc 
         INNER JOIN bpc.blogMembersId bmt WHERE bm.userId = :userId")*/
        //  Query query = em.createQuery(jpql); 
        //  select m from Member m join m.roles mr where mr.role_id = 2
        String jpql3 = "SELECT AP FROM Usuarios US INNER JOIN US.idPerfilMovil PM INNER JOIN PM.appMovilesList AP INNER JOIN AP.idAppMovil AM WHERE US.uid = :par";
      //  String jpql = "SELECT AM FROM AppMoviles AM JOIN AM.perfilesMovilesList PAM WHERE PAM.idPerfilMovil = :par";
        // Query query =   em.createNativeQuery(jpql1);
        Query query = em.createQuery(jpql3);
        //query.setParameter(1, par);
      //  query.setParameter("par", Integer.parseInt(par));
         query.setParameter("par", par);
        //    query.setParameter("par", "%"+ par +"%");
        appporperfilList = query.getResultList();
        //em.close();
        return appporperfilList;

    }
}
