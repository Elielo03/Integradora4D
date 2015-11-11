/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.DepartamentoBean;

import Beans.UsuarioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eliel David
 */
public class UsuarioDao extends DaoAbstract<UsuarioBean> {

    public UsuarioDao(Connection con) {
        super(con);
    }

    @Override
    List<UsuarioBean> passResultSet(ResultSet res, List<UsuarioBean> list) throws SQLException {
        while (res.next()) {
            UsuarioBean bean = new UsuarioBean();

            bean.setIdUsuario(res.getInt(1));
            bean.setUserName(res.getString(2));
            bean.setPass(res.getString(3));
            bean.setIdTipoUsuario(res.getInt(4));
            list.add(bean);
        }
        return list;
    }

    @Override
    public List<UsuarioBean> getAll() {
        List<UsuarioBean> lista = new ArrayList<>();
        String query = "Select * from Usuario ORDER BY idUsuario;";

        ResultSet result = executeQuery(query);

        try {
            lista = passResultSet(result, lista);

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public UsuarioBean get(int id) {

        String query = "SELECT * from Usuario where idUsuario=?;";
        UsuarioBean bean = new UsuarioBean();

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                bean.setIdUsuario(res.getInt(1));
                bean.setUserName(res.getString(2));
                bean.setPass(res.getString(3));
                bean.setIdTipoUsuario(res.getInt(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bean;
    }

    @Override
    public boolean update(UsuarioBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(UsuarioBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public UsuarioBean sesion(String nombre, String pass) {

        String query = "SELECT * FROM Usuario where username=? and pass=?;";

        UsuarioBean bean = new UsuarioBean();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, pass);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                bean.setIdUsuario(result.getInt(1));
                bean.setUserName(result.getString(2));
                bean.setPass(result.getString(3));
                bean.setIdTipoUsuario(result.getInt(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bean;
    }

}
