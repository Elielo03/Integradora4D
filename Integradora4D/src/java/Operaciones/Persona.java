/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Beans.DepartamentoBean;
import Beans.PersonaBean;
import Conexion.ConexionSQLServer;
import Dao.PersonaDao;
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
    DepartamentoBean departamento= new DepartamentoBean();
    
    List<PersonaBean> listaPersona = new ArrayList<PersonaBean>();
    
    int idPersona;
    Connection con;

    public Persona() {
        try {
            con = ConexionSQLServer.getConnection();
        } catch (Exception e) {
        }
    }

    public boolean add() {
        persona.setDepartamento(departamento);
        PersonaDao daoPersona = new PersonaDao(con);
        if (daoPersona.add(persona)) {
            return true;
        } else {
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
    public boolean update(){
        
       return true; 
    }

    public String llenarVacio() {
        PersonaBean persona = new PersonaBean();
        this.persona=persona;
        this.persona.setIdUsuario(4);
//        addFieldError("Tipo", "Agregar Persona");
        return SUCCESS;
    }

    public String LlenarLista() {
        System.out.println("si entra");
        PersonaDao daoPersona = new PersonaDao(con);
        listaPersona = daoPersona.getAll();
        if (listaPersona==null) {
            System.out.println("esta vacio");
        }else{
            System.out.println("esta lleno");
                    
        }
        return SUCCESS;
    }

    public String ConsultarPersona() {
        PersonaDao daoPersona = new PersonaDao(con);
        persona = daoPersona.get(idPersona);
        if (persona != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

  
    public String Intermediario(){
        if (persona.getIdPersona()==0) {
            if (add()) {
                return SUCCESS;
            }else{
                return ERROR;
            }
        }else{
            if (update()) {
                return SUCCESS;
            }else{
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
    

}
