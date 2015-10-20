/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.CategoriaBean;
import Beans.DepartamentoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eliel David
 */
public class CategoriaDao extends DaoAbstract<CategoriaBean>{
    
    

    public CategoriaDao(Connection con) {
        super(con);
    }
    
    

    

    
   

   

    @Override
    public CategoriaBean get(int id) {
        String query="SELECT * from Categoria where idCtegoria=? ;";
        CategoriaBean categoria = new CategoriaBean();
        
        try {
            PreparedStatement ps =con.prepareStatement(query);
            ps.setInt(1, id);
          ResultSet result=ps.executeQuery();
          if(result.next()){
              categoria.setIdCategoria(result.getInt("idCategoria"));
              categoria.setNombre(result.getString("nombre"));
              categoria.setEstado(result.getBoolean("estado"));
//              categoria.setDepartamento(result.get("departamento"));
          }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return categoria;
        
    }

    @Override
    public boolean update(CategoriaBean bean) {
        String query="UPDATE Categoria SET"
                + "nombre=?,"
                + "estado=?,"
                + "departamento=?;";
        
        try {
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1, bean.getNombre());
            ps.setBoolean(2, bean.isEstado());
            ps.setInt(3,bean.getDepartamento().getIdDepartamento());
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean delete(int id) {
        String query ="DELETE FROM Categoria WHERE idCategoria=?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            if(ps.executeUpdate()>=1){
                ps.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;
    }

    @Override
    public boolean add(CategoriaBean bean) {
        System.out.println("en el dao de categorias addd");
       String query = "Insert into Categoria(nombre,idDepartamento) VALUES (?,?);";
       
        try {
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1, bean.getNombre());
            
           
            ps.setInt(2, bean.getDepartamento().getIdDepartamento());
            
            if(ps.executeUpdate()>=1){
                ps.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

  

    @Override
    public List<CategoriaBean> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      @Override
    List<CategoriaBean> passResultSet(ResultSet res, List<CategoriaBean> list) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
