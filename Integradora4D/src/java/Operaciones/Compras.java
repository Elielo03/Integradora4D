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
            System.out.println(ex);
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
        
        int cont=0;
        int indice=0;
        for (ProductoBean productoBean : lista) {

            if (productoBean.getIdProducto() == idProducto) {

            indice=cont;    
            }
            
            cont++;
        }
        lista.remove(indice);
        
        carrito.put("listaProductos", lista);
        return SUCCESS;
    }
    
    
     public String deleteCar(){
            
            CarritoDao dao= new CarritoDao(con);
            
            dao.delete(producto.getIdProducto());
            
            
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
    
    
    public String buyCar(){
         VentaDao dao = new VentaDao(con);
        VentaBean bean = new VentaBean();
        PersonaDao daoP= new PersonaDao(con);
        PersonaBean beanP = new PersonaBean();
        ProductoDao daoPro= new ProductoDao(con);
        ProductoBean beanProducto= new ProductoBean();

        VentaDetalleDao daoDetalle = new VentaDetalleDao(con);
        VentaDetalleBean beanDetalle = new VentaDetalleBean();
        
        Map carrito = ActionContext.getContext().getSession();
        beanProducto= daoPro.get(producto.getIdProducto());
        beanProducto.setCantidad(cantidadHidden);
        beanP=daoP.get((Integer)carrito.get("idUsuario"));
        
         bean.setPersona(beanP);
        bean.setDescripcion("Sin Obervaciones");
              
        if(dao.add(bean)){
            
            beanDetalle.setCantidad(beanProducto.getCantidad());
            beanDetalle.setCosto_venta(beanProducto.getPrecio_v());
            beanDetalle.setIdProducto(beanProducto.getIdProducto());
            beanDetalle.setIdVenta(dao.lastSell());
            daoDetalle.add(beanDetalle);
            
             CarritoDao daoCarrito= new CarritoDao(con);
            
            daoCarrito.delete(producto.getIdProducto());
            
        }

        
        
        return SUCCESS;
    }
    
    public String addCar(){
        
       
       ProductoDao productoD= new ProductoDao(con);
       CarritoDao daoC= new CarritoDao(con);
       CarritoBean carritoB=new CarritoBean();
        ProductoBean beanP= new ProductoBean();
              beanP=  productoD.get(idProducto);
              Map carrito = ActionContext.getContext().getSession();
             
           
           carritoB.setIdPersona((Integer)carrito.get("idUsuario"));
           carritoB.setProducto(beanP);
          if (daoC.add(carritoB)){
               List<ProductoBean> lista = new ArrayList();
               Map carrito1 = ActionContext.getContext().getSession();
        lista = ((List<ProductoBean>) carrito.get("listaProductos"));
        
        int cont=0;
        int indice=0;
        for (ProductoBean productoBean : lista) {

            if (productoBean.getIdProducto() == idProducto) {

            indice=cont;    
            }
            
            cont++;
        }
        lista.remove(indice);
        
        carrito.put("listaProductos", lista);
        
        
          }
       
        return SUCCESS;
    }
    
    public String getCar() throws SQLException{
         Map carrito1 = ActionContext.getContext().getSession();
        CarritoDao daoC= new CarritoDao(con);
         int user=(Integer)carrito1.get("idUsuario");
        
        carrito=daoC.getAllUser(user);
        
        
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

    public List<CarritoBean> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<CarritoBean> carrito) {
        this.carrito = carrito;
    }

}
