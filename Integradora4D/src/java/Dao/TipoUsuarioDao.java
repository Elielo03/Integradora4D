/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.DepartamentoBean;
import Beans.TipoUsuarioBean;
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
public class TipoUsuarioDao extends DaoAbstract<TipoUsuarioBean> {

    public TipoUsuarioDao(Connection con) {
        super(con);
    }

    @Override
    List<TipoUsuarioBean> passResultSet(ResultSet res, List<TipoUsuarioBean> list) throws SQLException {
        while (res.next()) {
            TipoUsuarioBean bean = new TipoUsuarioBean();

            bean.setIdTipoUsuario(res.getInt(1));
            bean.setTipo(res.getString(2));
            list.add(bean);
        }
        return list;
    }

    @Override
    public List<TipoUsuarioBean> getAll() {
        List<TipoUsuarioBean> lista = new ArrayList<>();
        String query = "Select * from TipoUsuario ORDER BY idTipoUsuario;";

        ResultSet result = executeQuery(query);

        try {
            lista = passResultSet(result, lista);

        } catch (SQLException ex) {
            Logger.getLogger(TipoUsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public TipoUsuarioBean get(int id) {
        String query = "SELECT * from TipoUsuario where idTipoUsuario=?;";
        TipoUsuarioBean tipo = new TipoUsuarioBean();

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                tipo.setIdTipoUsuario(result.getInt(1));
                tipo.setTipo(result.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoUsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tipo;
    }

    @Override
    public boolean update(TipoUsuarioBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(TipoUsuarioBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
