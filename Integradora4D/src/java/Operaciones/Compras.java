/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Beans.PersonaBean;
import Beans.ProductoBean;
import Beans.VentaBean;
import Beans.VentaDetalleBean;
import Conexion.ConexionSQLServer;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeArray.map;

/**
 *
 * @author Eliel Rodriguez
 */
public class Compras extends ActionSupport {

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

        System.out.println("------------------------------------->" + cantidadHidden);
        if (!carrito.containsKey("listaProductos")) {
            List<ProductoBean> productos = new ArrayList<>();

            productos.add(producto = dao.get(idProducto));
            if (cantidadHidden == 0 || cantidadHidden == 1) {
                System.out.println("solo uno manooo");
                producto.setCantidad(1);
            } else {
                System.out.println("massssss de uno tronko");
                producto.setCantidad(cantidadHidden);
            }

            carrito.put("listaProductos", productos);

        } else {
            producto = dao.get(idProducto);
            if (cantidadHidden == 0 || cantidadHidden == 1) {
                System.out.println("solo uno manooo");
                producto.setCantidad(1);
            } else {
                System.out.println("massssss de uno tronko");
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
        beanP=daoP.get(2);
        

        Map carrito = ActionContext.getContext().getSession();
        lista = ((List<ProductoBean>) carrito.get("listaProductos"));

        HashSet<ProductoBean> hashSet = new HashSet<>(lista);
        lista.clear();
        lista.addAll(hashSet);

        bean.setPersona(beanP);
        bean.setDescripcion("Eliel esta Guapoooooooo");

       if( dao.add(bean)){
          for (ProductoBean productoBean : lista) {
            System.out.println("producto: " + productoBean.getNombre() + productoBean.getCantidad());
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
