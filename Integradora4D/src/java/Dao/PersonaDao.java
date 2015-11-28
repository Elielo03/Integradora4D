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

    DepartamentoDao departamento;
    UsuarioDao usuario;

    public PersonaDao(Connection con) {
        super(con);
        departamento = new DepartamentoDao(con);
        usuario = new UsuarioDao(con);
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
            bean.setFechaNac(res.getString(6));
            bean.setEstado(res.getBoolean(7));
            bean.setCorreoE(res.getString(8));
            bean.setTelefono(res.getString(9));
            bean.setUsuario(usuario.get(res.getInt(10)));
            bean.setDepartamento(departamento.get(res.getInt(11)));
            bean.setPass(res.getString(12));
            list.add(bean);
        }
        return list;
    }

    @Override
    public List<PersonaBean> getAll() {
        List<PersonaBean> lista = new ArrayList<>();
        String query = "select p.idPersona,p.nombre,p.app,p.apm,p.direccion,p.fecha_nac,p.estado,p.correoE,p.telefono,p.idUsuario,p.idDepartamento,u.pass from Persona p join Usuario u on p.idUsuario=u.idUsuario ORDER BY idPersona;";

        ResultSet result = executeQuery(query);

        try {
            lista = passResultSet(result, lista);

        } catch (SQLException ex) {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public PersonaBean get(int id) {
        String query = "select p.idPersona,p.nombre,p.app,p.apm,p.direccion,p.fecha_nac,p.estado,p.correoE,p.telefono,p.idUsuario,p.idDepartamento,u.pass from Persona p join Usuario u on p.idUsuario=u.idUsuario where idPersona=?;";
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
                bean.setUsuario(usuario.get(res.getInt(10)));
                bean.setDepartamento(departamento.get(res.getInt(11)));
                bean.setPass(res.getString(12));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bean;
    }

    @Override
    public boolean update(PersonaBean bean) {
        String query = "EXECUTE actualizaPersona ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, bean.getIdPersona());
            ps.setString(2, bean.getNombre());
            ps.setString(3, bean.getApp());
            ps.setString(4, bean.getApm());
            ps.setString(5, bean.getDireccion());
            ps.setString(6, bean.getFechaNac());
            ps.setString(7, bean.getCorreoE());
            ps.setString(8, bean.getTelefono());
            ps.setInt(9, bean.getUsuario().getIdUsuario());
            ps.setInt(10, bean.getDepartamento().getIdDepartamento());
            ps.setString(11, bean.getPass());
            ps.setInt(12, bean.getUsuario().getIdTipoUsuario());

            if (ps.executeUpdate() >= 1) {
                ps.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    
    public boolean updateEstado(int id, boolean estado) {
        String sql = "UPDATE Persona set estado= ? where idPersona= ?;";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setBoolean(1, estado);
            stm.setInt(2, id);
            if (stm.executeUpdate() == 1) {
                stm.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "Delete from Persona  where idPersona= ?;";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, id);
            if (stm.executeUpdate() == 1) {
                stm.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean add(PersonaBean bean) {

        String query = "EXECUTE InsertaPersona ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, bean.getNombre());
            ps.setString(2, bean.getApp());
            ps.setString(3, bean.getApm());
            ps.setString(4, bean.getDireccion());
            ps.setString(5, bean.getFechaNac());
            ps.setString(6, bean.getCorreoE());
            ps.setString(7, bean.getTelefono());
            ps.setString(8, bean.getPass());
            ps.setInt(9, bean.getUsuario().getIdTipoUsuario());
            ps.setInt(10, bean.getDepartamento().getIdDepartamento());

            if (ps.executeUpdate() >= 1) {
                ps.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
