/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Beans.ProductoBean;
import Conexion.ConexionSQLServer;
import Dao.ProductoDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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

    List<Map> productos = new ArrayList<>();
    int idProducto;
    ProductoBean producto = new ProductoBean();
    Connection con;
    Map carrito;
    

    public Compras() {
        try {
            con = ConexionSQLServer.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String addCarrito() {
         carrito = new HashMap<>();

        ProductoDao dao = new ProductoDao(con);
        //Map carrito = ActionContext.getContext().getSession();

        producto = dao.get(idProducto);
        
        carrito.put("imagen", producto.getImagen());
        carrito.put("nombre", producto.getNombre());
        carrito.put("nombre", producto.getExistencias());
        carrito.put("precio_v", producto.getPrecio_v());
        productos.add(carrito);

        return SUCCESS;
    }

    public String obtenerElementosCarro() {
        System.out.println("-------------------------> obteniendo el MAAAAAAAAAAAAAAAPAAAAAAAAAAAAA");
        
       
       carrito=getCarrito();
       
      
        
        return SUCCESS;
    }

    public List<Map> getProductos() {
        return productos;
    }

    public void setProductos(List<Map> productos) {
        this.productos = productos;
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

    public Map getCarrito() {
        return carrito;
    }

}
