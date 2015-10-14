/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.CategoriaBean;
import Beans.DepartamentoBean;
import java.sql.Connection;
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
public class DepartamentoDao extends DaoAbstract<DepartamentoBean>{
    
    

    public DepartamentoDao(Connection con) {
        super(con);
    }

    @Override
    public List<DepartamentoBean> getAll() {
        System.out.println("en el dao");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(DepartamentoBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(DepartamentoBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
