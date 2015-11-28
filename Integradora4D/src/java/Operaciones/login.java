/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Beans.UsuarioBean;
import Conexion.ConexionSQLServer;
import Dao.UsuarioDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.util.Map;

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

        Map objetosSesion = ActionContext.getContext().getSession();
        UsuarioDao dao = new UsuarioDao(con);
        usuario = dao.sesion(usuario.getUserName(), usuario.getPass());
        System.out.println("usuario " + usuario.getIdTipoUsuario());
        if (usuario != null) {
            if (usuario.getIdTipoUsuario() == 1) {
                System.out.println("entre tipo 1--------------");
                objetosSesion.put("tipo", usuario.getIdTipoUsuario());
                objetosSesion.put("nombre", usuario.getUserName());
                objetosSesion.put("idUsuario", usuario.getIdUsuario());
                objetosSesion.put("estado", true);
                return "opcion2";
            } else if (usuario.getIdTipoUsuario() == 2) {
                objetosSesion.put("tipo", usuario.getIdTipoUsuario());
                objetosSesion.put("nombre", usuario.getUserName());
                objetosSesion.put("idUsuario", usuario.getIdUsuario());
                objetosSesion.put("estado", true);
                return "opcion2";
            } else if (usuario.getIdTipoUsuario() == 3) {
                objetosSesion.put("tipo", usuario.getIdTipoUsuario());
                objetosSesion.put("nombre", usuario.getUserName());
                objetosSesion.put("idUsuario", usuario.getIdUsuario());
                objetosSesion.put("estado", true);
                return "opcion2";
            } else {
                objetosSesion.put("tipo", usuario.getIdTipoUsuario());
                objetosSesion.put("nombre", usuario.getUserName());
                objetosSesion.put("idUsuario", usuario.getIdUsuario());
                objetosSesion.put("estado", true);
                return "opcion1";
            }
        } else {
            return ERROR;
        }

    }

    public String cerrar() {
        Map objetosSesion
                = ActionContext.getContext().getSession();

        objetosSesion.remove("tipo");
        objetosSesion.remove("nombre");
        objetosSesion.remove("idUsuario");
        objetosSesion.remove("estado");

        return SUCCESS;
    }

    //get and set

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

}
