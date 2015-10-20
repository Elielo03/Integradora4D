/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Beans.DepartamentoBean;
import Conexion.ConexionSQLServer;
import Dao.DepartamentoDao;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eliel David
 */
public class Departamento  extends ActionSupport{
    Connection con;
    DepartamentoBean departamento= new DepartamentoBean();
     
    

    public Departamento(Connection con) {
        this.con = con;
    }

    public Departamento() {
       
        try {
            con=ConexionSQLServer.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Departamento.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
    
    public String add(){
        DepartamentoDao dao = new DepartamentoDao(con);
        
        
      dao.add(departamento);
       
        
        return SUCCESS;
    }

    public DepartamentoBean getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoBean departamento) {
        this.departamento = departamento;
    }
    
    
    
    
}
