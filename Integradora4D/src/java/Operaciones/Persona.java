/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Beans.DepartamentoBean;
import Beans.PersonaBean;
import Beans.TipoUsuarioBean;
import Beans.UsuarioBean;
import Conexion.ConexionSQLServer;
import Dao.DepartamentoDao;
import Dao.PersonaDao;
import Dao.TipoUsuarioDao;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hermanos Saucedo
 */
public class Persona extends ActionSupport {

    PersonaBean persona = new PersonaBean();
    DepartamentoBean departamento = new DepartamentoBean();
    UsuarioBean usuario = new UsuarioBean();

    List<PersonaBean> listaPersona = new ArrayList();
    List<DepartamentoBean> listaDepartamento = new ArrayList();
    List<TipoUsuarioBean> listaTipo = new ArrayList();

    int idPersona;

    Connection con;

    public Persona() {
        try {
            con = ConexionSQLServer.getConnection();
        } catch (Exception e) {
        }
    }

    public String LlenarListas() {
        DepartamentoDao daoDepa = new DepartamentoDao(con);
        TipoUsuarioDao daoTipo = new TipoUsuarioDao(con);
        listaDepartamento = daoDepa.getAll();
        listaTipo = daoTipo.getAll();

        return SUCCESS;

    }

    public boolean add() {
        System.out.println("estoy en add");
        PersonaDao daoPersona = new PersonaDao(con);
        System.out.println("usuario"+usuario.getIdTipoUsuario());
        persona.setDepartamento(departamento);
        persona.setUsuario(usuario);
        
        if (daoPersona.add(persona)) {
            System.out.println("algo para por aqui");
              return true;
        }else{
              return false;
        }
    }

    public String delete() {
        PersonaDao daoPersona = new PersonaDao(con);
        if (daoPersona.delete(idPersona)) {
            return SUCCESS;
        } else {
            return ERROR;
        }

    }

    public boolean update() {
        PersonaDao daoPersona = new PersonaDao(con);
        persona.setDepartamento(departamento);
        persona.setUsuario(usuario);
        return daoPersona.update(persona);
//        return true;
    }
    
    

    public String getAll() {
        PersonaDao daoPersona = new PersonaDao(con);
        listaPersona = daoPersona.getAll();
        return SUCCESS;
    }

    public String llenarVacio() {
        persona.setIdPersona(0);
        usuario.setIdTipoUsuario(4);
        departamento.setIdDepartamento(0);
        return SUCCESS;
    }

    public String ConsultarPersona() {
        PersonaDao daoPersona = new PersonaDao(con);
        LlenarListas();

        persona = daoPersona.get(idPersona);
        usuario = persona.getUsuario();
        departamento = persona.getDepartamento();

        if (persona.getDepartamento().getIdDepartamento() == 0) {
            return "opcion1";
        } else {
            return "opcion2";
        }
    }

    public String Intermediario() {
        System.out.println("entro al inter");
        if (persona.getIdPersona() == 0) {
            if (add()) {
                System.out.println("entro al add");
                return SUCCESS;
            } else {
                return ERROR;
            }
        } else {
            if (update()) {
                return SUCCESS;
            } else {
                return ERROR;
            }
        }

    }

    //Get and set de todos----------------
    public PersonaBean getPersona() {
        return persona;
    }

    public void setPersona(PersonaBean persona) {
        this.persona = persona;
    }

    public List<PersonaBean> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<PersonaBean> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public DepartamentoBean getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoBean departamento) {
        this.departamento = departamento;
    }

    public List<DepartamentoBean> getListaDepartamento() {
        return listaDepartamento;
    }

    public void setListaDepartamento(List<DepartamentoBean> listaDepartamento) {
        this.listaDepartamento = listaDepartamento;
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

    public List<TipoUsuarioBean> getListaTipo() {
        return listaTipo;
    }

    public void setListaTipo(List<TipoUsuarioBean> listaTipo) {
        this.listaTipo = listaTipo;
    }

}
