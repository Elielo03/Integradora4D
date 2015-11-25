/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Beans.CategoriaBean;
import Beans.ProductoBean;
import Conexion.ConexionSQLServer;
import Dao.CategoriaDao;
import Dao.ProductoDao;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Comodin
 */
public class Producto  extends ActionSupport{
    File archivo;
    String url;
    
    List<CategoriaBean> categorias=new ArrayList<>();
    List<ProductoBean> productos=new ArrayList<>();
    ProductoBean bean =new ProductoBean();
    Connection con;
    int idProducto;
    int idCategoria;
    

    public Producto() {
        try {
            con=ConexionSQLServer.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String llenarLista(){
       
        ProductoDao daoP= new ProductoDao(con);
        CategoriaDao daoC=new CategoriaDao(con);
       
        
        categorias=daoC.getAll();
        productos=daoP.getAll();
        
        
        return SUCCESS;
    }
    
    public boolean add() throws IOException{
        ProductoDao dao= new ProductoDao(con);
        CategoriaDao daoC= new CategoriaDao(con);
         CategoriaBean categoria = new CategoriaBean();
        
         addImagen();
        
         
         
      
        
       categoria= daoC.get(idCategoria);
        
        bean.setCategoria(categoria);
        bean.setImagen(url);
       return dao.add(bean);
        
        
    }
    
    public boolean update() throws IOException{
        ProductoDao dao= new ProductoDao(con);
        bean= dao.get(bean.getIdProducto());
        
        if(url!=bean.getImagen()){
            return dao.update(bean);
        }else{
            System.out.println("---------------------->AQIOOOOOOOOO");
            addImagen();
            
        }
        
        
        return dao.update(bean);
    }
    
    
    public String delete(){
        
        ProductoDao dao= new ProductoDao(con);
        
        dao.delete(idProducto);
        
        return SUCCESS;
    }
    
    
    public String intermediario() throws IOException {

        if (bean.getIdProducto()== 0) {
            if (add()) {
                return SUCCESS;
            }

        }

        if (update()) {

            return SUCCESS;
        }

        return ERROR;
    }
    
    
    public void addImagen() throws IOException{
        
         String infoTemporal="";
        String path = ServletActionContext.getRequest().getSession()
                .getServletContext().getRealPath("/");
        
       
        
        File archivoFinal = new File(path+"/img/"+bean.getCodigo()+".jpg",infoTemporal);
        FileUtils.copyFile(archivo, archivoFinal);
         
    
        
        url = "http://localhost:8080/Integradora4D/img/"+archivoFinal.getName();
        bean.setImagen(url);
        
    }
    
    
    
    public String addExist(){
    ProductoDao dao = new ProductoDao(con);
    
   bean= dao.getByCodigo(bean.getCodigo());
        System.out.println(bean.getExistencias());
        System.out.println(bean.getStock());
        System.out.println("--------------------------------> "+bean.getNombre());
   
   if(dao.updateExistente(bean.getIdProducto(), bean.getExistencias(), bean.getStock())){
       return SUCCESS;
   }else
   return ERROR;
    }
    
    
    
    
    
    

    public List<CategoriaBean> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaBean> categorias) {
        this.categorias = categorias;
    }

    public List<ProductoBean> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoBean> productos) {
        this.productos = productos;
    }

    public ProductoBean getBean() {
        return bean;
    }

    public void setBean(ProductoBean bean) {
        this.bean = bean;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    
    
    
}
