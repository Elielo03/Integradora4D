/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Beans.Persona;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Eliel David
 */
public class Registar extends ActionSupport {
    Persona persona= new Persona();
    
    
    public String registro(){
        System.out.println("nombre: "+persona.getNombre());
        System.out.println("apellidos: "+persona.getApellidos());
        System.out.println("correo: "+persona.getCorreo());
        
        return SUCCESS;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    
    
}
