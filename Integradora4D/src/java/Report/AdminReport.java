/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import Conexion.ConexionSQLServer;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author spown
 */
public class AdminReport extends ActionSupport {

    String nombreuser;
    private Map params;
    private Connection conn;

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

    @Override
    public String execute() throws Exception {

        params = new HashMap();
        conn = ConexionSQLServer.getConnection();
        params.put("nombreuser", nombreuser);

        return SUCCESS;
    }

}
