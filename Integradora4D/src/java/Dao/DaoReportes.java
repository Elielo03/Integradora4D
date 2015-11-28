/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.CategoriaBean;
import Beans.DepartamentoBean;
import Beans.PersonaBean;
import Conexion.ConexionSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author spown
 */
public class DaoReportes {

    Connection con;

    public DaoReportes() throws SQLException {
        con = ConexionSQLServer.getConnection();
    }

    public PersonaBean get(int id) {
        String query = "SELECT * from Persona where idUsuario=?;";
        PersonaBean bean = new PersonaBean();

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                bean.setIdPersona(res.getInt(1));
                bean.setNombre(res.getString(2));
                bean.setApp(res.getString(3));
                bean.setApm(res.getString(4));
                bean.setDireccion(res.getString(5));
                bean.setFechaNac(res.getString(6));
                bean.setEstado(res.getBoolean(7));
                bean.setCorreoE(res.getString(8));
                bean.setTelefono(res.getString(9));
//                bean.setUsuario(usuario.get(res.getInt(10)));
//                bean.setDepartamento(departamento.get(res.getInt(11)));
                bean.setPass(res.getString(10));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoReportes.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bean;

    }

}
