/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.DepartamentoBean;
import Beans.PersonaBean;
import Beans.ProductoBean;
import Beans.VentaBean;
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
public class VentaDao extends DaoAbstract <VentaBean>{

    public VentaDao(Connection con) {
        super(con);
    }

    @Override
    List<VentaBean> passResultSet(ResultSet res, List<VentaBean> list) throws SQLException {
         while(res.next()){
            VentaBean bean=new VentaBean();
                       
            bean.setIdVenta(res.getInt("idVenta"));
            bean.setFecha_compra(res.getString("fecha_compra"));
            bean.setDescripcion(res.getString("descripcion"));
            bean.setEstado(res.getBoolean("estado"));
            
            PersonaBean persona = new PersonaDao(con).get(res.getInt("idPersona"));
            bean.setPersona(persona);
            list.add(bean);
        }     
        return list;
    }

    @Override
    public List<VentaBean> getAll() {
        List<VentaBean> lista= new ArrayList<>();
        
        String query="SELECT * From venta;";
        ResultSet result = executeQuery(query);
        try {
            lista=passResultSet(result, lista);
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

   

    

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public boolean update(VentaBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(VentaBean bean) {
       
        
        System.out.println("La venta ess: "+bean.getDescripcion()+bean.getPersona());
        String query="INSERT INTO Venta(fecha_compra,descripcion,idPersona) VALUES (GETDATE(), ?, ?);";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, bean.getDescripcion());
            ps.setInt(2, bean.getPersona().getIdPersona());
            
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
    public VentaBean get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int lastSell(){
     
        VentaBean bean= new VentaBean();
        String query  ="select top 1 * from Venta order by idVenta desc ";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet result=ps.executeQuery();
            if(result.next()){
                bean.setIdVenta(result.getInt("idVenta"));
                
            }
            return bean.getIdVenta();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        return 0;
    }

    
   
    
}
