/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.VentaDetalleBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Eliel David
 */
public class CarritoDao extends DaoAbstract <VentaDetalleBean>{

    public CarritoDao(Connection con) {
        super(con);
    }

    @Override
    List<VentaDetalleBean> passResultSet(ResultSet res, List<VentaDetalleBean> list) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VentaDetalleBean> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VentaDetalleBean get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(VentaDetalleBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(VentaDetalleBean bean) {
       String query="INSERT INTO Venta_detalle(cantidad,costo_venta,idVenta,idProducto) values(?, ? , ?,  ?);";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
           ps.setInt(1, bean.getCantidad());
           ps.setDouble(2, bean.getCosto_venta());
           ps.setInt(3, bean.getIdVenta());
           ps.setInt(4, bean.getIdProducto());
            
            if(ps.executeUpdate()>=1){
               
                ps.close();
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        
        return false;
    }

   
    
}
