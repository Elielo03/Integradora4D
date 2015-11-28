/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Beans.VentaBean;
import Conexion.ConexionSQLServer;
import Dao.VentaDao;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eliel Rodriguez
 */
public class Ventas extends ActionSupport {
    
    VentaBean venta= new VentaBean();
    List<VentaBean> ventas = new   ArrayList();
    int idVenta;
    Connection con;
    

    public Ventas() {
         try {
            con=ConexionSQLServer.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getAll(){
        VentaDao dao= new VentaDao(con);
        ventas=dao.getAll();
        
        return SUCCESS;
    }
    
    public String addVenta(){
        
        
        return SUCCESS;
    }

    public VentaBean getVenta() {
        return venta;
    }

    public void setVenta(VentaBean venta) {
        this.venta = venta;
    }

    public List<VentaBean> getVentas() {
        return ventas;
    }

    public void setVentas(List<VentaBean> ventas) {
        this.ventas = ventas;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }
    
    
}
