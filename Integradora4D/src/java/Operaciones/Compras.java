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

    
    int idProducto;
    
    ProductoBean producto = new ProductoBean();
    Connection con;
    
    
   
   
    

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
            
            if(!carrito.containsKey("listaProductos")){
                List<ProductoBean> productos = new ArrayList<>();
                productos.add(producto = dao.get(idProducto));
                carrito.put("listaProductos", productos);
                 
            }else{
                producto = dao.get(idProducto);
                
              ((List<ProductoBean>) carrito.get("listaProductos")).add(producto);
            }
        return SUCCESS;
    }
    
     public String removeElement(){
         List<ProductoBean> lista = new ArrayList();
               ProductoDao dao= new ProductoDao(con);
         Map carrito = ActionContext.getContext().getSession();
        lista= ((List<ProductoBean>) carrito.get("listaProductos"));
         System.out.println("id que llega::::::::::::::::::."+idProducto);
         for (ProductoBean productoBean : lista) {
             System.out.println("idddddddddd"+productoBean.getIdProducto());
             if(productoBean.getIdProducto()==idProducto){
                 
                 lista.remove(productoBean);
             }
         }
                 

         carrito.put("listaProductos", lista);
         
         
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

   
    
    

}
