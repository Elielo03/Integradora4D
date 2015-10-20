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
import javax.swing.JOptionPane;

/**
 *
 * @author Eliel David
 */
public class DepartamentoDao extends DaoAbstract<DepartamentoBean>{
    
    

    public DepartamentoDao(Connection con) {
        super(con);
    }

    @Override
    public List<DepartamentoBean> getAll() {
        
        List<DepartamentoBean> lista= new ArrayList<>();
        
        String query="SELECT * From Departamento;";
        ResultSet result = executeQuery(query);
        try {
            lista=passResultSet(result, lista);
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    @Override
    public DepartamentoBean get(int id) {
        String query="SELECT * FROM Departamento where idDepartamento =?;";
        
        DepartamentoBean bean = new DepartamentoBean();
        try {
            PreparedStatement ps =con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            while(result.next()){
                bean.setIdDepartamento(result.getInt("idDepartamento"));
                bean.setNombre(result.getString("nombre"));
                bean.setDescripcion(result.getString("descripcion"));
                bean.setEstado(result.getBoolean("estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bean;
    }

    @Override
    public boolean update(DepartamentoBean bean) {
        String query="UPDATE Departamento SET"
                + "nombre=?,"
                + "estado=?,"
                + "descripcion=?;";
        
        try {
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1, bean.getNombre());
            ps.setBoolean(2, bean.isEstado());
            ps.setInt(3, bean.getIdDepartamento());
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean delete(int id) {
         String query ="DELETE FROM Departamento WHERE idDepartamento=?;";
        
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
    public boolean add(DepartamentoBean bean) {
        
        String query = "Insert into Departamento (nombre,descripcion) VALUES (?,?);";
       
        try {
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1, bean.getNombre());
             ps.setString(2, bean.getDescripcion());
           
           
            
            if(ps.executeUpdate()==1){
                ps.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    List<DepartamentoBean> passResultSet(ResultSet res, List<DepartamentoBean> list) throws SQLException {
        while(res.next()){
            DepartamentoBean bean=new DepartamentoBean();
            
            
            bean.setIdDepartamento(res.getInt("idDepartamento"));
            bean.setNombre(res.getString("nombre"));
            bean.setDescripcion(res.getString("descripcion"));
            bean.setEstado(res.getBoolean("estado"));
            list.add(bean);
        }
        
        return list;
    }
    
}
