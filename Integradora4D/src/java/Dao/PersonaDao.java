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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonaBean> getAll() {
        List<PersonaBean> resultado = new ArrayList();
        String sql = "select * from Persona;";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PersonaBean persona = new PersonaBean();
                persona.setIdPersona(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setApp(rs.getString(3));
                persona.setApm(rs.getString(4));
                persona.setDireccion(rs.getString(5));
                persona.setFechaNac(rs.getDate(6));
                persona.setCorreoE(rs.getString(7));
//                persona.setTelefono(rs.getString(8));
                persona.setIdUsuario(rs.getInt(9));
                persona.setIdDepartamento(rs.getInt(10));
                persona.setEstado(rs.getBoolean(11));
                resultado.add(persona);
            }
            stm.close();

        } catch (Exception e) {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, e);
        }

        return resultado;
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
