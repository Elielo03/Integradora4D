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

/**
 *
 * @author Eliel David
 */
public class Categoria extends ActionSupport {

    CategoriaBean categoria = new CategoriaBean();
    DepartamentoBean departamento = new DepartamentoBean();

    List<DepartamentoBean> departamentos = new ArrayList<>();
    List<CategoriaBean> categorias = new ArrayList<>();
    int idDepartamento;
    int idCategoria;
    Connection con;

    public Categoria() {
        try {
            con = ConexionSQLServer.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean add() {

        DepartamentoDao daoDepartamento = new DepartamentoDao(con);
        DepartamentoBean beanDepartamento = new DepartamentoBean();
        beanDepartamento = daoDepartamento.get(idDepartamento);
        categoria.setDepartamento(beanDepartamento);

        CategoriaDao categoriaDao = new CategoriaDao(con);
        if (categoriaDao.add(categoria)) {
            return true;
        } else {
            return false;
        }

    }

    public String llenarLista() {
        DepartamentoDao daoD = new DepartamentoDao(con);
        CategoriaDao daoC = new CategoriaDao(con);
        departamentos = daoD.getAll();
        categorias = daoC.getAll();
        
        

        categoria = daoC.get(idCategoria);
        departamento = categoria.getDepartamento();

        return SUCCESS;
    }
    public String getActive(){
        DepartamentoDao daoD = new DepartamentoDao(con);
        CategoriaDao daoC = new CategoriaDao(con);
         departamentos = daoD.getAllActive();
         
         categoria=daoC.get(idCategoria);
         departamento=categoria.getDepartamento();
         
         
         
        
         
        
    
        categorias = daoC.getAllActive();
        return SUCCESS;
    }

    public boolean update() {

        DepartamentoDao daoD = new DepartamentoDao(con);
        departamento = daoD.get(departamento.getIdDepartamento());
       
        categoria.setDepartamento(departamento);
        CategoriaDao dao = new CategoriaDao(con);
        categoria.setEstado(true);
        
        return dao.update(categoria);
    }

    public String delete() {

        CategoriaDao dao = new CategoriaDao(con);
        dao.delete(idCategoria);

        return SUCCESS;
    }
    
    
    public String updateEstado(){
        
        CategoriaDao dao = new CategoriaDao(con);
        categoria=dao.get(idCategoria);
        
        
        if(categoria.isEstado()){
            dao.updateEstado(categoria,false);
        }else
            dao.updateEstado(categoria, true);
                
        
        return SUCCESS;
    }

    public String intermediario() {

        if (categoria.getIdCategoria() == 0) {
            if (add()) {
                return SUCCESS;
            }

        }

        if (update()) {

            return SUCCESS;
        }

        return ERROR;
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

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public List<CategoriaBean> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaBean> categorias) {
        this.categorias = categorias;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public DepartamentoBean getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoBean departamento) {
        this.departamento = departamento;
    }

}
