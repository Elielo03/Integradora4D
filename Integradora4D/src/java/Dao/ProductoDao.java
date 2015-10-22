/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.CategoriaBean;
import Beans.ProductoBean;
import java.sql.Connection;
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
public class ProductoDao extends DaoAbstract<ProductoBean>{
    
    

    public ProductoDao(Connection con) {
        super(con);
    }

    @Override
    List<ProductoBean> passResultSet(ResultSet res, List<ProductoBean> list) throws SQLException {
        while(res.next()){
            ProductoBean bean= new ProductoBean();
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
            
            CategoriaBean categoria= new CategoriaDao(con).get(res.getInt("idCategoria"));
            bean.setCategoria(categoria);
            list.add(bean);
            
        }
        
        return list;
    }

    @Override
    public List<ProductoBean> getAll() {
        System.out.println("en el DAOOOOOOOOOOO");
       List<ProductoBean> lista=new ArrayList<>();
       
       String quey= "SELECT * FROM Producto order by idProducto;";
       
       ResultSet result=executeQuery(quey);
        try {
            lista=passResultSet(result, lista);
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       return lista;
    }

    @Override
    public ProductoBean get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ProductoBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(ProductoBean bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
