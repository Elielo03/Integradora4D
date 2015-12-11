/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import Beans.PersonaBean;
import Conexion.ConexionSQLServer;
import Dao.DaoReportes;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Context;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author spown
 */
public class AdminReports extends ActionSupport {

    String desde, hasta;

    private Map params;
    private Connection conn;

    PersonaBean persona = new PersonaBean();

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
        Map objetosSesion = ActionContext.getContext().getSession();
        DaoReportes dao = new DaoReportes();
        int id = (int) objetosSesion.get("idUsuario");
        persona = dao.get(id);
        if (persona != null) {
            params = new HashMap();
            conn = ConexionSQLServer.getConnection();
            params.put("nombreuser", persona.getNombre() + " " + persona.getApp());
            params.put("logo", getClass().getResourceAsStream("liverpool_logo.png"));
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String AdminSalesReportGraph() throws Exception {
        Map objetosSesion = ActionContext.getContext().getSession();
        DaoReportes dao = new DaoReportes();
        int id = (int) objetosSesion.get("idUsuario");
        persona = dao.get(id);
        if (persona != null) {
            params = new HashMap();
            conn = ConexionSQLServer.getConnection();
            params.put("desde", desde);
            params.put("hasta", hasta);
            params.put("nombre", persona.getNombre() + " " + persona.getApp());
            params.put("logo", getClass().getResourceAsStream("liverpool_logo.png"));
            return SUCCESS;
        } else {
            return ERROR;
        }

    }

    public String AdminSalesReport() throws Exception {
        Map objetoSesion = ActionContext.getContext().getSession();
        DaoReportes dao = new DaoReportes();
        int id = (int) objetoSesion.get("idUsuario");
        persona = dao.get(id);
        if (persona != null) {
            params = new HashMap();
            conn = ConexionSQLServer.getConnection();
            params.put("desde", desde);
            params.put("hasta", hasta);
            params.put("nombre", persona.getNombre() + " " + persona.getApp());
            params.put("logo", getClass().getResourceAsStream("liverpool_logo.png"));
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

}
