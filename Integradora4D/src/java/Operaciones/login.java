/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Beans.UsuarioBean;
import Conexion.ConexionSQLServer;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;

/**
 *
 * @author Xavier
 */
public class login extends ActionSupport {

    UsuarioBean usuario = new UsuarioBean();

    Connection con;

    public login() {
        try {
            con = ConexionSQLServer.getConnection();
        } catch (Exception e) {
        }
    }

    public void sesion() {

    }

    //get and set
    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

}
