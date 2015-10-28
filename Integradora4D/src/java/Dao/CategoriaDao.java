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
import java.util.ArrayList;
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
        String query="SELECT * from Categoria where idCategoria=?;";
        CategoriaBean categoria = new CategoriaBean();
        
        
        try {
            PreparedStatement ps =con.prepareStatement(query);
            ps.setInt(1, id);
          ResultSet result=ps.executeQuery();
          if(result.next()){
              categoria.setIdCategoria(result.getInt("idCategoria"));
              categoria.setNombre(result.getString("nombre"));
              categoria.setEstado(result.getBoolean("estado"));
               DepartamentoBean departamento = new DepartamentoDao(con).get(result.getInt("idDepartamento"));
            categoria.setDepartamento(departamento);
          }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return categoria;
        
    }

    @Override
    public boolean update(CategoriaBean bean) {
        String query="UPDATE Categoria SET"
                + "idCategoria=?"
                + "nombre=?,"
                + "estado=?,"
                + "idDepartamento=?;";
        
        try {
            PreparedStatement ps =con.prepareStatement(query);
            ps.setInt(1, bean.getIdCategoria());
            ps.setString(2, bean.getNombre());
            ps.setBoolean(3, bean.isEstado());
            ps.setInt(4,bean.getDepartamento().getIdDepartamento());
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
    public boolean delete(int id) {
        
        String query ="DELETE FROM Categoria WHERE idCategoria=?;";//se supone que tiene que ser logico?
        
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
        List<CategoriaBean> lista = new ArrayList<>();
        String query = "Select * from Categoria ORDER BY  idCategoria;";
        
        ResultSet result=executeQuery(query);
        
        try {
            lista=passResultSet(result, lista);
                    
                    
                    } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return lista;
    }
    
      @Override
    List<CategoriaBean> passResultSet(ResultSet res, List<CategoriaBean> list) throws SQLException {
       while(res.next()){
           CategoriaBean bean = new CategoriaBean();
           
             bean.setIdCategoria(res.getInt("idCategoria"));
            bean.setNombre(res.getString("nombre"));
           
            bean.setEstado(res.getBoolean("estado"));
            
            DepartamentoBean departamento = new DepartamentoDao(con).get(res.getInt("idDepartamento"));
            bean.setDepartamento(departamento);
            
            list.add(bean);
       }
       return list;
    }
    
}
