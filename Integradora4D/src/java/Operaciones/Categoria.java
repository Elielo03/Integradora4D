/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Beans.CategoriaBean;
import Conexion.ConexionSQLServer;
import Dao.CategoriaDao;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eliel David
 */
public class Categoria extends ActionSupport {
    
    CategoriaBean categoria= new CategoriaBean();
    
    Connection con;

    public Categoria() {
        try {
            con = ConexionSQLServer.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String get(){
        
        
        CategoriaDao dao = new CategoriaDao(con);
        dao.get(categoria.getIdDepartamento());
        
        return SUCCESS;
    }

    public CategoriaBean getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaBean categoria) {
        this.categoria = categoria;
    }
    
    
    
}
