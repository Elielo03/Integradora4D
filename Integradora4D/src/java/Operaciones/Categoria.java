/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Beans.CategoriaBean;
import Beans.DepartamentoBean;
import Conexion.ConexionSQLServer;
import Dao.CategoriaDao;
import Dao.DepartamentoDao;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
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
public class Categoria extends ActionSupport {

    CategoriaBean categoria = new CategoriaBean();
   
    List<DepartamentoBean> departamentos = new ArrayList<>();
    String idDepartamentos;

    Connection con;

    public Categoria() {
        try {
            con = ConexionSQLServer.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String add() {
        
        
        
        DepartamentoDao daoDepartamento = new DepartamentoDao(con);
        DepartamentoBean beanDepartamento= new DepartamentoBean();
       beanDepartamento=daoDepartamento.get(Integer.parseInt(idDepartamentos) );
       categoria.setDepartamento(beanDepartamento);
       
        CategoriaDao categoriaDao= new CategoriaDao(con);
        if(categoriaDao.add(categoria))
            return SUCCESS;
       else
        return ERROR;

    }

    public String llenarLista() {
        DepartamentoDao daoD = new DepartamentoDao(con);
        departamentos = daoD.getAll();

        return SUCCESS;
    }

    public CategoriaBean getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaBean categoria) {
        this.categoria = categoria;
    }

    public List<DepartamentoBean> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<DepartamentoBean> departamentos) {
        this.departamentos = departamentos;
    }

    public String getIdDepartamentos() {
        return idDepartamentos;
    }

    public void setIdDepartamentos(String idDepartamentos) {
        this.idDepartamentos = idDepartamentos;
    }

   

    

}
