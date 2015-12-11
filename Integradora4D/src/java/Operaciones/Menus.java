/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Beans.DepartamentoBean;
import Beans.ProductoBean;
import Conexion.ConexionSQLServer;
import Dao.DepartamentoDao;
import Dao.ProductoDao;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hermanos Saucedo
 */
public class Menus extends ActionSupport{

    int id;
    List<ProductoBean> productos = new ArrayList<>();
    Connection con;

    public Menus() {
        try {
            con = ConexionSQLServer.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Menus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<DepartamentoBean> departamentos() {
        List<DepartamentoBean> lista;
        DepartamentoDao dao = new DepartamentoDao(con);
        lista = dao.getAll();
        return lista;

    }

    public String buscarDep() {
        ProductoDao dao = new ProductoDao(con);
        productos = dao.Menu(id);
//        if (productos !=null) {
//            System.out.println("no vacia");
//            return SUCCESS;
//        }else{
//            return ERROR;
//        }
        System.out.println("el id es ----------"+id);
        for (ProductoBean producto : productos) {
            System.out.println("productos son  "+producto.getNombre());
            
        }
        return SUCCESS;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ProductoBean> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoBean> productos) {
        this.productos = productos;
    }
    
    

}
