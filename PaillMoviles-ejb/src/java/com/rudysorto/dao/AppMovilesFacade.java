/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rudysorto.dao;

import com.rudysorto.jpa.AppMoviles;
import com.rudysorto.jpa.Clientes;
import com.rudysorto.jpa.Clientesfv;
import com.rudysorto.jpa.Doctoress;
import com.rudysorto.jpa.Escalas;
import com.rudysorto.jpa.Vendedores;
import com.rudysorto.jpa.OpcionesAppMoviles;
import com.rudysorto.jpa.ProductoMM;
import com.rudysorto.jpa.Productos;
import com.rudysorto.jpa.RegistrosMM;
import com.rudysorto.jpa.RegistrosMMdet;
import com.rudysorto.jpa.Transacciones;
import com.rudysorto.utils.Utils;
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
    private List<OpcionesAppMoviles> opcionesXAppList;
    private List<Productos> productosLikeList;
    private List<Clientes> clientesLikeList;
        private List<RegistrosMMdet> clientesPorVendedor;
    private List<ProductoMM> productosBodegaMMList;
    private List<RegistrosMM> registrosmmList;
    private List<Vendedores> ejecutivosList;
    private List<Escalas> escalasPorProducto;
    private List<Transacciones> lstTransaccionesmm;
    private List<Doctoress> lstDoctores;
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AppMovilesFacade() {
        super(AppMoviles.class);
    }

    @Override
    public List<OpcionesAppMoviles> listaAppsPerfil(String par) {

              String jpql = "select opxapp.IdOpcionesAppMoviles,  opxapp.Nombre, opxapp.Descripcion, opxapp.Logo, opxapp.IdAppMovil, usu.IdEmpleado from Usuarios usu inner join  Empleados emp on usu.IdEmpleado = emp.IdEmpleado inner join PerfilesMoviles permo on usu.IdPerfilMovil = permo.IdPerfilMovil   inner join AppPorPerfiles appxper on usu.IdPerfilMovil = appxper.IdPerfilMovil   inner join  AppMoviles appmo on appxper.IdAppMovil = appmo.IdAppMovil inner join OpcionesAppMoviles opxapp on appmo.IdAppMovil = opxapp.IdAppMovil where usu.uid = ?";
     Query query =   em.createNativeQuery(jpql, OpcionesAppMoviles.class);
        query.setParameter(1,  par);
     opcionesXAppList = query.getResultList();
        return opcionesXAppList;
    }

    @Override
    public List<OpcionesAppMoviles> listaOpcionesApp(int par) {  
         String jpql3 = "SELECT OA FROM OpcionesAppMoviles OA INNER JOIN OA.idAppMovil AM WHERE AM.idAppMovil = :par";
        Query query = em.createQuery(jpql3);
         query.setParameter("par", par);
        opcionesXAppList = query.getResultList();
        return opcionesXAppList;
    }

    @Override
    public List<Productos> productosLike(String par, String id) {
      /*  String jpql = "SELECT EX.productos FROM Existencias EX "
                + " WHERE EX.bodegas.idBodega = '59' AND EX.productos.idProducto LIKE :par"
                + " OR EX.productos.nombre LIKE :par";*/
     String jpql = "SELECT PR FROM Productos PR where PR.idProducto LIKE :par OR PR.nombre LIKE :par" ;
                
        Query query = em.createQuery(jpql);  
        
          String jpql1 =   "select DISTINCT pro.IdProducto, pro.Nombre from bodegaVirtualMM vb inner join Productos pro on vb.IdProducto = pro.IdProducto and vb.IdVendedor = ? where   pro.IdProducto = ? or pro.Nombre like ? ";
     //   String jpql1 =   "select DISTINCT pro.IdProducto, pro.Nombre from bodegaVirtualMM vb inner join Productos pro on vb.IdProducto = pro.IdProducto and vb.IdVendedor = ? order by pro.Nombre";

            
          Query query2 =   em.createNativeQuery(jpql1, Productos.class);
    query2.setParameter(1, id);      
query2.setParameter(2,  par);
query2.setParameter(3, "%"+ par +"%");
//query2.setParameter(1,  "%"+ par +"%");
       //  query2.setParameter("par", "%"+ par +"%");  
         productosLikeList = query2.getResultList();
        return productosLikeList; 
        
          /* String jpql =   "select us.UID, us.Nombre  as 'NombreUsuario' , pm.Nombre  as 'NombrePerfil', pm.Descripcion  as 'DescripcionPerfil' ,\n" +
         " am.Nombre  as NombreApp, am.Descripcion as 'DescripcionMovil' , am.Logo from Usuarios us inner join PerfilesMoviles pm \n" +
         "on us.IdPerfilMovil = pm.IdPerfilMovil inner join AppPorPerfiles ap on us.IdPerfilMovil = ap.IdPerfilMovil\n" +
         "inner join AppMoviles am on ap.IdAppMovil = am.IdAppMovil\n" +
         "where us.UID = :par" ;*/
        
    }
    
    
        @Override
    public List<Productos> productosPorVendedor( String id) {
   String jpql1 =   "select DISTINCT pro.IdProducto, pro.Nombre from bodegaVirtualMM vb inner join Productos pro on vb.IdProducto = pro.IdProducto and vb.IdVendedor = ? order by pro.Nombre";
          Query query2 =   em.createNativeQuery(jpql1, Productos.class);
    query2.setParameter(1, id);      
         productosLikeList = query2.getResultList();
        return productosLikeList;  
    }

    @Override
    public List<Clientes> clientesLike(String par, String idEmpleado) {

     String jpql =  "select top 10 jvpm as IdCliente, Nombre from (select * from Clientesfv where IdEmpleado = ?) sel where Nombre like ? or jvpm = ?";
        Query query =   em.createNativeQuery(jpql, Clientes.class);
        query.setParameter(1, idEmpleado);
query.setParameter(2, "%"+ par +"%");
if(Utils.isNumeric(par)){
    query.setParameter(3, Integer.parseInt(par));
}

     clientesLikeList = query.getResultList();
        return clientesLikeList; 
    }

    @Override
    public List<ProductoMM> productosBodegaVirtual(String par) {
       // String jpql =   "select distinct pro.IdProducto, pro.Nombre, vb.cantidad as 'entrada', IsNULL(sum(mmdet.Cantidad),0) as 'salida', ( vb.cantidad - IsNULL(sum(mmdet.Cantidad),0)) as diferencia from bodegaVirtualMM vb inner join Productos pro on vb.IdProducto = pro.IdProducto left join RegistrosMMdet mmdet on  pro.IdProducto = mmdet.IdProducto where vb.IdVendedor = ?  group by pro.IdProducto, pro.Nombre, vb.cantidad";
    String jpql =   "select distinct pro.IdProducto, pro.Nombre, vb.cantidad as 'entrada', IsNULL(sum(mmdet.Cantidad),0) as 'salida', ( vb.cantidad - IsNULL(sum(mmdet.Cantidad),0))  as diferencia from bodegaVirtualMM vb inner join Productos pro on vb.IdProducto = pro.IdProducto and vb.IdVendedor = ?  left join  RegistrosMM mm on mm.IdVendedor = ? left join RegistrosMMdet mmdet on  mm.IdRegMM = mmdet.IdRegMM and pro.IdProducto = mmdet.IdProducto group by pro.IdProducto, pro.Nombre, vb.cantidad";
        Query query =   em.createNativeQuery(jpql, ProductoMM.class);
        query.setParameter(1,  par);
        query.setParameter(2,  par);
     productosBodegaMMList = query.getResultList();
        return productosBodegaMMList;
    }

    @Override
    public List<RegistrosMM> registrosMMPorVendedor(String par) {
       //  String jpql =   "select reg.IdRegMM,   cli.IdCliente, cli.Nombre, reg.Longitud, reg.Latitud, sum(regdet.Cantidad) as totalmm from RegistrosMM reg inner join RegistrosMMdet regdet on reg.IdRegMM = regdet.IdRegMM  inner join Clientesfv cli on reg.IdCliente = cli.IdCliente where reg.IdVendedor = ? group by reg.IdRegMM, cli.IdCliente, cli.Nombre, reg.Longitud, reg.Latitud";
        String jpql =   "select reg.IdRegMM,   cli.jvpm, cli.Nombre, reg.Longitud, reg.Latitud, sum(regdet.Cantidad) as totalmm from RegistrosMM reg inner join RegistrosMMdet regdet on reg.IdRegMM = regdet.IdRegMM  inner join Doctoress cli on reg.IdCliente = cli.jvpm where reg.IdVendedor = ? group by reg.IdRegMM, cli.jvpm, cli.Nombre, reg.Longitud, reg.Latitud order by reg.IdRegMM";
     Query query =   em.createNativeQuery(jpql, RegistrosMM.class);
        query.setParameter(1,  par);
     registrosmmList = query.getResultList();
        return registrosmmList;

    }

    @Override
    public List<Vendedores> selectALlEjecutivos() {
       
         String jpql =   "select distinct vb.IdVendedor, (em.Nombre +' '+ em.Apellido) as Nombre, isnull(ven.Grupo, 'S/L') Grupo  from bodegaVirtualMM vb inner join Empleados em on vb.IdVendedor = em.IdEmpleado  left join  Vendedores ven on em.IdEmpleado = ven.IdEmpleado";
     Query query =   em.createNativeQuery(jpql, Vendedores.class);
     ejecutivosList = query.getResultList();
        return ejecutivosList;
    }

    @Override
    public List<Vendedores> likeEjecutivos(String par) {
        
         String jpql =   "select top 10 * from (select distinct vb.IdVendedor, (em.Nombre +' '+ em.Apellido) as Nombre, ven.Grupo  from bodegaVirtualMM vb inner join Empleados em on vb.IdVendedor  = em.IdEmpleado  inner join  Vendedores ven on em.IdEmpleado = ven.IdEmpleado ) sel where Nombre like ?";
     Query query =   em.createNativeQuery(jpql, Vendedores.class);
     query.setParameter(1, "%"+ par +"%");
     ejecutivosList = query.getResultList();
        return ejecutivosList; 
        
    }

    @Override
    public List<RegistrosMMdet> clientesporVendedor(String idempleado) {
       
        String jpql =   " select mmdet.idRegMMdet, mm.IdCliente, cf.Nombre, mmdet.IdProducto, pro.Nombre as NombreProducto,  mmdet.Cantidad ,  mm.Guardado from RegistrosMM mm inner join Clientesfv cf on mm.IdCliente = cf.IdCliente and mm.IdVendedor = ? inner join RegistrosMMdet mmdet on mmdet.IdRegMM = mm.IdRegMM inner join Productos pro on mmdet.IdProducto = pro.IdProducto";
     Query query =   em.createNativeQuery(jpql, RegistrosMMdet.class);
     query.setParameter(1,  idempleado );
     clientesPorVendedor = query.getResultList();
        return clientesPorVendedor; 
       
    }

    @Override
    public List<Productos> productoLikePedido(String par) {
        
        String jpql =   "select productopedidos.IdProducto, productopedidos.Nombre, IdUnidad from ( select * from Productos where IdSubgrupo in ( select IdSubgrupo from Subgrupos where IdGrupo in (33 , 11, 38, 37, 48 , 26 , 19 ))) as productopedidos  where productopedidos.Nombre like ?  or productopedidos.IdProducto = ?";
     Query query =   em.createNativeQuery(jpql, Productos.class);
    query.setParameter(1, "%"+ par +"%");
     query.setParameter(2,  par );
     
     productosLikeList = query.getResultList();
        return productosLikeList; 
    }

    @Override
    public List<Escalas> escalasPorProductos(String par) {
        
             String jpql =   "select distinct esc.IdEscala,  esc.Nombre, pre.Precio from Precios pre inner join Escalas esc on pre.IdEscala = esc.IdEscala where IdProducto = ?";
     Query query =   em.createNativeQuery(jpql, Escalas.class);
     query.setParameter(1,  par );
     
     escalasPorProducto = query.getResultList();
        return escalasPorProducto; 
        
    }

    @Override
    public List<Productos> checkexistencias(String par) {
        
        String jpql =   "select top 1 productopedidos.IdProducto, productopedidos.Nombre, exis.IdBodega, exis.IdEstatus, exis.Lote  from ( select * from Productos where IdSubgrupo  in ( select IdSubgrupo from Subgrupos where IdGrupo in (33 , 11, 38, 37, 48,26 ,19)))  as productopedidos  inner join Existencias exis on productopedidos.IdProducto = exis.IdProducto and exis.Cantidad > 0 and exis.IdEstatus = 'DIS' where productopedidos.Nombre like ?  or productopedidos.IdProducto = ?";
     Query query =   em.createNativeQuery(jpql, Productos.class);
     query.setParameter(1, "%"+ par +"%");
     query.setParameter(2,  par );
     
     productosLikeList = query.getResultList();
        return productosLikeList; 
        
        
    }

    @Override
    public List<Clientes> clientesPedidosLike(String par) {
             String jpql =  "select top 30 IdCliente, Nombre, RegFiscal, IdVendedor, TasaDesc, IdEscala, TipoIVA  from Clientes  where Nombre like ? or IdCliente = ?";
        Query query =   em.createNativeQuery(jpql, Clientes.class);
    query.setParameter(1, "%"+ par +"%");
        query.setParameter(2, par);
     clientesLikeList = query.getResultList();
        return clientesLikeList; 
    }

    @Override
    public List<Transacciones> transaccionesmedicosmm(String par) {
        
        // String jpql =  "select  mmdet.idRegMMdet, mm.IdCliente, cf.Nombre, mmdet.IdProducto, pro.Nombre as NombreProducto, mmdet.Cantidad ,  mm.Guardado from RegistrosMM mm inner join Clientesfv cf on mm.IdCliente = cf.IdCliente and mm.IdVendedor = ? inner join RegistrosMMdet mmdet on mmdet.IdRegMM = mm.IdRegMM inner join Productos pro on mmdet.IdProducto = pro.IdProducto";
         String jpql =  "select  mmdet.idRegMMdet, mm.IdCliente, cf.Nombre, mmdet.IdProducto, pro.Nombre as NombreProducto, mmdet.Cantidad ,  mm.Guardado from RegistrosMM mm inner join Doctoress cf on mm.IdCliente = cf.jvpm and mm.IdVendedor = ? inner join RegistrosMMdet mmdet on mmdet.IdRegMM = mm.IdRegMM inner join Productos pro on mmdet.IdProducto = pro.IdProducto";
        Query query =   em.createNativeQuery(jpql, Transacciones.class);
        query.setParameter(1, par);
     lstTransaccionesmm = query.getResultList();
        return lstTransaccionesmm; 
    }

    @Override
    public List<Doctoress> clientesXVendedor(String par) {
          String jpql =  " select doc.jvpm, vendet.IdCliente, isnull(clien.Nombre, doc.Nombre) Nombre from VendedoresdetClientes vendet inner join Empleados emple on vendet.IdEmpleado = emple.IdEmpleado left join Clientes clien on vendet.IdCliente = clien.IdCliente left join Doctoress doc on vendet.IdCliente = doc.jvpm where vendet.IdEmpleado = ? order by Nombre";
        Query query =   em.createNativeQuery(jpql, Doctoress.class);
        query.setParameter(1, par);
     lstDoctores = query.getResultList();
        return lstDoctores; 
       
    }

    @Override
    public List<Escalas> precioPorEscala(String par, String esca) {
        
            String jpql =   "select distinct esc.IdEscala,  esc.Nombre, pre.Precio from Precios pre inner join Escalas esc on pre.IdEscala = esc.IdEscala where IdProducto = ? and esc.IdEscala = ?";
     Query query =   em.createNativeQuery(jpql, Escalas.class);
     query.setParameter(1,  par );
      query.setParameter(2,  esca );
     escalasPorProducto = query.getResultList();
        return escalasPorProducto; 
    }
    
   
}
