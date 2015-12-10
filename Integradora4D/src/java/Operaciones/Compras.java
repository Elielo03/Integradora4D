/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Beans.CarritoBean;
import Beans.PersonaBean;
import Beans.ProductoBean;
import Beans.VentaBean;
import Beans.VentaDetalleBean;
import Conexion.ConexionSQLServer;
import Dao.CarritoDao;
import Dao.PersonaDao;
import Dao.ProductoDao;
import Dao.VentaDao;
import Dao.VentaDetalleDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eliel Rodriguez
 */
public class Compras extends ActionSupport {
    List<CarritoBean> carrito= new ArrayList();
    int idProducto;

    ProductoBean producto = new ProductoBean();
    Connection con;
    int cantidadHidden;

    public Compras() {
        try {
            con = ConexionSQLServer.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String addCarro() {
        ProductoDao dao = new ProductoDao(con);

        Map carrito = ActionContext.getContext().getSession();

        
        if (!carrito.containsKey("listaProductos")) {
            List<ProductoBean> productos = new ArrayList<>();

            productos.add(producto = dao.get(idProducto));
            if (cantidadHidden == 0 || cantidadHidden == 1) {
                
                producto.setCantidad(1);
            } else {
                
                producto.setCantidad(cantidadHidden);
            }

            carrito.put("listaProductos", productos);

        } else {
            producto = dao.get(idProducto);
            if (cantidadHidden == 0 || cantidadHidden == 1) {
                
                producto.setCantidad(1);
            } else {
                
                producto.setCantidad(cantidadHidden);
            }

            ((List<ProductoBean>) carrito.get("listaProductos")).add(producto);
        }
        return SUCCESS;
    }

    public String removeElement() {

        List<ProductoBean> lista = new ArrayList();
        ProductoDao dao = new ProductoDao(con);
        Map carrito = ActionContext.getContext().getSession();
        lista = ((List<ProductoBean>) carrito.get("listaProductos"));
        producto = dao.get(idProducto);

        for (ProductoBean productoBean : lista) {

            if (productoBean.getIdProducto() == producto.getIdProducto()) {

                lista.remove(productoBean);
            }
        }

        carrito.put("listaProductos", lista);

        return SUCCESS;
    }

    public String realizarCompra() {
        List<ProductoBean> lista = new ArrayList();
        VentaDao dao = new VentaDao(con);
        VentaBean bean = new VentaBean();
        PersonaDao daoP= new PersonaDao(con);
        PersonaBean beanP = new PersonaBean();

        VentaDetalleDao daoDetalle = new VentaDetalleDao(con);
        VentaDetalleBean beanDetalle = new VentaDetalleBean();
        
        

        Map carrito = ActionContext.getContext().getSession();
        lista = ((List<ProductoBean>) carrito.get("listaProductos"));
        beanP=daoP.get((Integer)carrito.get("idUsuario"));

//        HashSet<ProductoBean> hashSet = new HashSet<>(lista);
//        lista.clear();
//        lista.addAll(hashSet);

        bean.setPersona(beanP);
        bean.setDescripcion("Sin Obervaciones");

       if( dao.add(bean)){
          for (ProductoBean productoBean : lista) {
            
            beanDetalle.setCantidad(productoBean.getCantidad());
            beanDetalle.setCosto_venta(productoBean.getPrecio_v());
            beanDetalle.setIdProducto(productoBean.getIdProducto());
            beanDetalle.setIdVenta(dao.lastSell());
            daoDetalle.add(beanDetalle);
        }
       }
           carrito =ActionContext.getContext().getSession();
           carrito.remove("listaProductos");
        
        
        

        return SUCCESS;
    }
    
    public String addCar(){
        
       System.out.println("id producto es: "+ idProducto);
       ProductoDao productoD= new ProductoDao(con);
       CarritoDao daoC= new CarritoDao(con);
       CarritoBean carritoB=new CarritoBean();
        ProductoBean beanP= new ProductoBean();
              beanP=  productoD.get(idProducto);
              Map carrito = ActionContext.getContext().getSession();
             
           
           carritoB.setIdPersona((Integer)carrito.get("idUsuario"));
           carritoB.setProducto(beanP);
           daoC.add(carritoB);
       
        return SUCCESS;
    }
    
    public String getCar(){
        CarritoDao daoC= new CarritoDao(con);
        carrito=daoC.getAll();
        
        return SUCCESS;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public ProductoBean getProducto() {
        return producto;
    }

    public int getCantidadHidden() {
        return cantidadHidden;
    }

    public void setCantidadHidden(int cantidadHidden) {
        this.cantidadHidden = cantidadHidden;
    }

}
