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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eliel David
 */
public class Departamento  extends ActionSupport{
    Connection con;
    DepartamentoBean departamento= new DepartamentoBean();
     List<DepartamentoBean> departamentos = new ArrayList<>();
    public int idDepartamento;
      
  
     
    

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
    
    public boolean add(){
       
        DepartamentoDao dao = new DepartamentoDao(con);
      
       
        
        return dao.add(departamento);
    }
    
    
    public boolean update(){
        
        
        DepartamentoDao daoD= new DepartamentoDao(con);
       
       
        return daoD.update(departamento);
    }
    public String updateEstado(){
        
        
        DepartamentoDao daoD= new DepartamentoDao(con);
       departamento= daoD.get(idDepartamento);
        
       
       if(departamento.isEstado()){
           daoD.updateEstado(departamento, false);
           
       }else
           daoD.updateEstado(departamento, true);
       
       return SUCCESS;
       
       
    }
    
    public String delete(){
        
         DepartamentoDao daoD= new DepartamentoDao(con);
         
        if(daoD.delete(idDepartamento)){
            return SUCCESS;
        }
       
        return SUCCESS;
        
        
    }
    
    
    
    public String llenarLista(){
        
        DepartamentoDao daoD= new DepartamentoDao(con);
        departamentos=daoD.getAll();
        
      
        
        departamento=daoD.get(idDepartamento);
        
        return SUCCESS;
    }
    
    
    public String intermediario(){
        if(departamento.getIdDepartamento()==0){
            if(add()){
                return SUCCESS;
            }
        }
        if(update()){
           
            return SUCCESS;
        }
        
        return ERROR;
    }
            

    public DepartamentoBean getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoBean departamento) {
        this.departamento = departamento;
    }

    public List<DepartamentoBean> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<DepartamentoBean> departamentos) {
        this.departamentos = departamentos;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    
    
    
}
