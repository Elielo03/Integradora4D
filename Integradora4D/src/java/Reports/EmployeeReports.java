/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import Conexion.ConexionSQLServer;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author spown
 */
public class EmployeeReports extends ActionSupport {

    String nombreuser, depto, desde, hasta;
    private Map params;
    private Connection conn;

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getNombreuser() {
        return nombreuser;
    }

    public void setNombreuser(String nombreuser) {
        this.nombreuser = nombreuser;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }

    public String EmployeeProductReport() throws Exception {

        params = new HashMap();
        conn = ConexionSQLServer.getConnection();
        params.put("nombreuser", nombreuser);
        params.put("depto", depto);

        return SUCCESS;
    }
    
    public String EmployeeSalesReport() throws Exception {
        
        params = new HashMap();
        conn = ConexionSQLServer.getConnection();
        params.put("nombreuser", nombreuser);
        params.put("desde", desde);
        params.put("hasta", hasta);
        params.put("depto", depto);
        
        return SUCCESS;
        
    }

}
