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

    List<CategoriaBean> categorias = new ArrayList<>();
    CategoriaBean categoria = new CategoriaBean();
    List<DepartamentoBean> departamentos = new ArrayList<>();

    Connection con;

    public Categoria() {
        try {
            con = ConexionSQLServer.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String get() {

        CategoriaDao daoC = new CategoriaDao(con);
        categorias = daoC.getAll();

        return SUCCESS;
    }

    public String llenarLista() {
        System.out.println("ene l metodo llenar Lista");
        DepartamentoDao daoD = new DepartamentoDao(con);
        departamentos = daoD.getAll();
        
        return SUCCESS;
    }

    public List<CategoriaBean> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaBean> categorias) {
        this.categorias = categorias;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
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

}
