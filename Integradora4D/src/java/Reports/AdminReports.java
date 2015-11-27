/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import Conexion.ConexionSQLServer;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author spown
 */
public class AdminReports extends ActionSupport {

    String nombreuser, desde, hasta;
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
    

    public String getNombreuser() {
        return nombreuser;
    }

    public void setNombreuser(String nombreuser) {
        this.nombreuser = nombreuser;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String AdminProductReport() throws Exception {

        params = new HashMap();
        conn = ConexionSQLServer.getConnection();
        params.put("nombreuser", nombreuser);

        return SUCCESS;
    }

    public String AdminSalesReportGraph() throws Exception {
        params = new HashMap();
        conn = ConexionSQLServer.getConnection();
        params.put("desde", desde);
        params.put("hasta", hasta);
        params.put("nombre", nombreuser);
        return SUCCESS;
    }

    public String AdminSalesReport() throws Exception {
        params = new HashMap();
        conn = ConexionSQLServer.getConnection();
        params.put("desde", desde);
        params.put("hasta", hasta);
        params.put("nombre", nombreuser);
        return SUCCESS;
    }

}
