/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.CategoriaBean;
import Beans.DepartamentoBean;
import Beans.ProductoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Eliel David
 */
public class ProductoDao extends DaoAbstract<ProductoBean> {

    public ProductoDao(Connection con) {
        super(con);
    }

    @Override
    List<ProductoBean> passResultSet(ResultSet res, List<ProductoBean> list) throws SQLException {
        while (res.next()) {
            ProductoBean bean = new ProductoBean();
            bean.setIdProducto(res.getInt("idProducto"));
            bean.setNombre(res.getString("nombre"));
            bean.setDescripcion(res.getString("descripcion"));
            bean.setCodigo(res.getString("codigo"));
            bean.setExistencias(res.getInt("existencias"));
            bean.setStock(res.getInt("stock"));
            bean.setPrecio_c(res.getDouble("precio_c"));
            bean.setPrecio_v(res.getDouble("precio_v"));
            bean.setEstado(res.getBoolean("estado"));
            bean.setMarca(res.getString("marca"));
            bean.setImagen(res.getString("imagen"));

            CategoriaBean categoria = new CategoriaDao(con).get(res.getInt("idCategoria"));
            bean.setCategoria(categoria);
            list.add(bean);

        }

        return list;
    }

    @Override
    public List<ProductoBean> getAll() {

        List<ProductoBean> lista = new ArrayList<>();

        String quey = "SELECT * FROM Producto order by idProducto;";

        ResultSet result = executeQuery(quey);
        try {
            lista = passResultSet(result, lista);
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public List<ProductoBean> getAllActive() {

        List<ProductoBean> lista = new ArrayList<>();

        String quey = "SELECT * FROM Producto where estado= 'true' order by idProducto;";

        ResultSet result = executeQuery(quey);
        try {
            lista = passResultSet(result, lista);
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public ProductoBean get(int id) {
        String query = "SELECT * from Producto where idProducto=?;";
        ProductoBean producto = new ProductoBean();

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                producto.setIdProducto(result.getInt("idCategoria"));
                producto.setNombre(result.getString("nombre"));
                producto.setCodigo(result.getString("codigo"));
                producto.setDescripcion(result.getString("descripcion"));
                producto.setExistencias(result.getInt("existencias"));
                producto.setStock(result.getInt("stock"));
                producto.setPrecio_c(result.getDouble("precio_c"));
                producto.setPrecio_c(result.getDouble("precio_c"));

                producto.setEstado(result.getBoolean("estado"));
                producto.setMarca(result.getString("marca"));
                producto.setImagen(result.getString("imagen"));
                CategoriaBean categoria = new CategoriaDao(con).get(result.getInt("idCategoria"));
                producto.setCategoria(categoria);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return producto;
    }

    public ProductoBean getByCodigo(String codigo) {
        String query = "SELECT * from Producto where codigo=?;";
        ProductoBean producto = new ProductoBean();

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, codigo);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                producto.setIdProducto(result.getInt("idCategoria"));
                producto.setNombre(result.getString("nombre"));
                producto.setCodigo(result.getString("codigo"));
                producto.setDescripcion(result.getString("descripcion"));
                producto.setExistencias(result.getInt("existencias"));
                producto.setStock(result.getInt("stock"));
                producto.setPrecio_c(result.getDouble("precio_c"));
                producto.setPrecio_c(result.getDouble("precio_c"));

                producto.setEstado(result.getBoolean("estado"));
                producto.setMarca(result.getString("marca"));
                producto.setImagen(result.getString("imagen"));
                CategoriaBean categoria = new CategoriaDao(con).get(result.getInt("idCategoria"));
                producto.setCategoria(categoria);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return producto;
    }

    @Override
    public boolean update(ProductoBean bean) {
        String query = "UPDATE PRODUCTO SET "
                + "nombre=?, "
                + "codigo=?, "
                + "descripcion=?, "
                + "existencias=?, "
                + "stock=?, "
                + "precio_c=?, "
                + "precio_v=?, "
                + "estado=?, "
                + "marca=?, "
                + "imagen=?, "
                + "idCategoria=? "
                + "WHERE idProducto =?;";
        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, bean.getNombre());
            ps.setString(2, bean.getCodigo());
            ps.setString(3, bean.getDescripcion());
            ps.setInt(4, bean.getExistencias());
            ps.setInt(5, bean.getStock());
            ps.setDouble(6, bean.getPrecio_c());
            ps.setDouble(7, bean.getPrecio_v());
            ps.setBoolean(8, bean.isEstado());
            ps.setString(8, bean.getMarca());
            ps.setString(9, bean.getImagen());
            ps.setInt(10, bean.getCategoria().getIdCategoria());
            ps.setInt(11, bean.getIdProducto());
            if (ps.executeUpdate() >= 1) {
                ps.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean updateeSTADO(ProductoBean bean, boolean estado) {
        System.out.println("-----------------idddddddddddddddddd" + bean.getIdProducto());
        String query = "UPDATE PRODUCTO SET "
                + " estado= ? "
                + " WHERE idProducto = ?;";
        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setBoolean(1, estado);

            ps.setInt(2, bean.getIdProducto());
            if (ps.executeUpdate() >= 1) {
                ps.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean updateExistente(int id, int existencias, int stock) {
        String query = "execute addProdExistente ?,?,?";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.setInt(2, existencias);
            ps.setInt(3, stock);
            if (ps.executeUpdate(query) >= 1) {
                ps.close();
                return true;
            } else {
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;

    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM Producto where idProducto=?;";
        try {

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            if (ps.executeUpdate() >= 1) {
                ps.close();
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return false;
    }

    @Override
    public boolean add(ProductoBean bean) {

        String query = "INSERT INTO Producto VALUES(?,?,?,?,?,?,?,?,?,?,?);";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, bean.getNombre());
            ps.setString(2, bean.getCodigo());
            ps.setString(3, bean.getDescripcion());
            ps.setInt(4, bean.getExistencias());
            ps.setInt(5, bean.getStock());
            ps.setDouble(6, bean.getPrecio_c());
            ps.setDouble(7, bean.getPrecio_v());
            ps.setBoolean(8, bean.isEstado());
            ps.setString(9, bean.getMarca());
            ps.setString(10, bean.getImagen());
            ps.setInt(11, bean.getCategoria().getIdCategoria());

            if (ps.executeUpdate() >= 1) {
                ps.close();
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return false;
    }

    public List<ProductoBean> Menu(int codigo) {
        String query = "SELECT * FROM Producto where idCategoria=(select idCategoria from Categoria where idDepartamento=?);";
        List<ProductoBean> lista =  new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                ProductoBean producto = new ProductoBean();
                producto.setIdProducto(result.getInt("idCategoria"));
                producto.setNombre(result.getString("nombre"));
                producto.setCodigo(result.getString("codigo"));
                producto.setDescripcion(result.getString("descripcion"));
                producto.setExistencias(result.getInt("existencias"));
                producto.setStock(result.getInt("stock"));
                producto.setPrecio_c(result.getDouble("precio_c"));
                producto.setPrecio_c(result.getDouble("precio_c"));

                producto.setEstado(result.getBoolean("estado"));
                producto.setMarca(result.getString("marca"));
                producto.setImagen(result.getString("imagen"));
                CategoriaBean categoria = new CategoriaDao(con).get(result.getInt("idCategoria"));
                producto.setCategoria(categoria);
                lista.add(producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

}
