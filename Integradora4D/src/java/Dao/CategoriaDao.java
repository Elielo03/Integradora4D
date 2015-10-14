/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.CategoriaBean;
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
        String query="SELECT * from Categoria where idCtegoria=?;";
        CategoriaBean categoria = new CategoriaBean();
        
        try {
            PreparedStatement ps =con.prepareStatement(query);
            ps.setInt(1, id);
          ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return categoria;
        
    }

    @Override
    public boolean update(CategoriaBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(CategoriaBean id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(CategoriaBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
