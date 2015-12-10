/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.CarritoBean;
import Beans.VentaDetalleBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eliel David
 */
public class CarritoDao extends DaoAbstract <CarritoBean>{

    public CarritoDao(Connection con) {
        super(con);
    }

   

    @Override
    public List<CarritoBean> getAll() {
        List<CarritoBean> carrito= new ArrayList<>();
        
         String query="SELECT * From carrito;";
         
          
        ResultSet result = executeQuery(query);
        try {
            carrito=passResultSet(result, carrito);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return carrito;
        
    }

    

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public boolean update(CarritoBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(CarritoBean bean) {
        
            String query ="insert into carrito (idPersona,idProducto) values (?,?);";
            try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, bean.getIdPersona());
            ps.setInt(2,  bean.getProducto().getIdProducto());
            
            if(ps.executeUpdate()>=1){
               
                ps.close();
                return true;
            }
            
            
        } catch (SQLException ex) {
                System.out.println(ex);
        }
            return false;
    }

    @Override
    List<CarritoBean> passResultSet(ResultSet res, List<CarritoBean> list) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CarritoBean get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
