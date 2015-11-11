/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Beans.UsuarioBean;
import Conexion.ConexionSQLServer;
import Dao.UsuarioDao;
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

    public String sesion() {
        UsuarioDao dao = new UsuarioDao(con);
        usuario = dao.sesion(usuario.getUserName(), usuario.getPass());
        if (usuario != null) {
            if (usuario.getIdTipoUsuario() == 4) {
                return "opcion1";
            } else {
                return "opcion2";
            }
        } else {
            return ERROR;
        }

    }

    //get and set
    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

}
