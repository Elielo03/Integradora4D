/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.CarritoBean;
import Beans.CategoriaBean;
import Beans.DepartamentoBean;
import Beans.ProductoBean;
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
    
     public List<CarritoBean> getAllUser(int user)  {
        List<CarritoBean> carrito= new ArrayList<>();
        
         String query="SELECT * From carrito where idPersona=?;";
           try {
               PreparedStatement ps = con.prepareStatement(query);
               ps.setInt(1, user);
               
               ps.executeQuery();
               
               
        ResultSet result = ps.executeQuery();
       
            carrito=passResultSet(result, carrito);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return carrito;
        
    }

    

    @Override
    public boolean delete(int id) {
        
        try {
            String quuery="DELETE FROM carrito where idProducto=?;";
            
            PreparedStatement ps= con.prepareStatement(quuery);
            ps.setInt(1, id);
            
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
        while(res.next()){
           CarritoBean bean = new CarritoBean();
           
             bean.setIdPersona(res.getInt("idPersona"));
            
           
           
            
            ProductoBean producto = new ProductoDao(con).get(res.getInt("idProducto"));
            bean.setProducto(producto);
            
            list.add(bean);
       }
       return list;
    }

    @Override
    public CarritoBean get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
