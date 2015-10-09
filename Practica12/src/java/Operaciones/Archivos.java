/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Eliel David
 */
public class Archivos extends ActionSupport {
    
    File archivo;

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    
    public String txtFile() throws IOException{
        
        String infoTemporal="";
        String path =ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");
        File archivoFinal=new File(path+"archivo.txt",infoTemporal);
        FileUtils.copyFile(archivo,archivoFinal);
        
        System.out.println("Path: "+path);
        
        return SUCCESS;
    }
    
    public String csvFile() throws IOException{
        String infoTemporal="";
         String path =ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");
         File archivoFinal= new File(path+"archivo2.csv",infoTemporal);
          
         FileUtils.copyFile(archivo, archivoFinal);
         
         Scanner lector = new Scanner(archivoFinal);
         while(lector.hasNext()){
             System.out.println(lector.nextLine());
         }
         lector.close();
         
         return SUCCESS;
    }
    
    public String jpgFile() throws IOException{
        String infoTemporal="";
         String path =ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");
         File archivoFinal= new File(path+"archivo3.jpg",infoTemporal);
          
         FileUtils.copyFile(archivo, archivoFinal);
         
         
         
         return SUCCESS;
        
    }
}
