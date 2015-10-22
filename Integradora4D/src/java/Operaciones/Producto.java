/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Beans.CategoriaBean;
import Beans.ProductoBean;
import Conexion.ConexionSQLServer;
import Dao.CategoriaDao;
import Dao.ProductoDao;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Comodin
 */
public class Producto  extends ActionSupport{
    
    List<CategoriaBean> categorias=new ArrayList<>();
    List<ProductoBean> productos=new ArrayList<>();
    ProductoBean bean =new ProductoBean();
    Connection con;
    

    public Producto() {
        try {
            con=ConexionSQLServer.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String llenarLista(){
        ProductoDao daoP= new ProductoDao(con);
        CategoriaDao daoC=new CategoriaDao(con);
        
        categorias=daoC.getAll();
        productos=daoP.getAll();
        
        
        return SUCCESS;
    }

    public List<CategoriaBean> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaBean> categorias) {
        this.categorias = categorias;
    }

    public List<ProductoBean> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoBean> productos) {
        this.productos = productos;
    }

    public ProductoBean getBean() {
        return bean;
    }

    public void setBean(ProductoBean bean) {
        this.bean = bean;
    }
    
    
}
