/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

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
    List<PersonaBean> listaPersona = new ArrayList<PersonaBean>();
    Connection con;

    public Persona() {
        try {
            con = ConexionSQLServer.getConnection();
        } catch (Exception e) {
        }
    }
    public String addCliente(){
        PersonaDao daoPersona= new PersonaDao(con);
        if (daoPersona.add(persona)) {
            System.out.println("Funciono creo"); 
        }else{
            System.out.println("algo anda mal poreldao");
        }
            
       
        return SUCCESS;
    }
    public String llenarVacio(){     
        persona.setIdUsuario(0);
        persona.setIdDepartamento(0);
        persona.setIdUsuario(4);
        return SUCCESS;
    }
    
    public String LlenarLista(){
        System.out.println("entre almetodo llenar");
        PersonaDao daoPersona= new PersonaDao(con);
        listaPersona=daoPersona.getAll();
        return SUCCESS;
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
    
    

}
