/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.PersonaBean;
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
public class PersonaDao extends DaoAbstract<PersonaBean> {

    public PersonaDao(Connection con) {
        super(con);
    }

    @Override
    List<PersonaBean> passResultSet(ResultSet res, List<PersonaBean> list) throws SQLException {
        while (res.next()) {
            PersonaBean bean = new PersonaBean();

            bean.setIdPersona(res.getInt(1));
            bean.setNombre(res.getString(2));
            bean.setApp(res.getString(3));
            bean.setApm(res.getString(4));
            bean.setDireccion(res.getString(5));
            bean.setFechaNac(res.getDate(6));
            bean.setEstado(res.getBoolean(7));
            bean.setCorreoE(res.getString(8));
            bean.setTelefono(res.getString(9));
            bean.setIdUsuario(res.getInt(10));
            bean.setIdDepartamento(res.getInt(11));
            list.add(bean);
        }
           return list;
    }

    @Override
    public List<PersonaBean> getAll() {
        List<PersonaBean> lista = new ArrayList<>();
        String query = "Select * from Persona ORDER BY idPersona;";

        ResultSet result = executeQuery(query);

        try {
            lista = passResultSet(result, lista);

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public PersonaBean get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(PersonaBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(PersonaBean bean) {

        String query = "EXECUTE InsertaPersona ?, ?, ?, ?, '05-07-1989', ?, ?, ?, ?, ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, bean.getNombre());
            ps.setString(2, bean.getApp());
            ps.setString(3, bean.getApm());
            ps.setString(4, bean.getDireccion());
//            ps.setDate(5, bean.getFechaNac());
            ps.setString(5, bean.getCorreoE());
            ps.setString(6, bean.getTelefono());
            ps.setString(7, bean.getPass());
            ps.setInt(8, bean.getIdUsuario());
            ps.setInt(9, bean.getIdDepartamento());

            if (ps.executeUpdate() >= 1) {
                ps.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
