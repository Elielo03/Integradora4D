/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import Beans.DepartamentoBean;
import Beans.PersonaBean;
import Conexion.ConexionSQLServer;
import Dao.DaoReportes;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author spown
 */
public class EmployeeReports extends ActionSupport {

    PersonaBean persona = new PersonaBean();
    DepartamentoBean depto = new DepartamentoBean();

    String desde, hasta;
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

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }

    public String EmployeeProductReport() throws Exception {
        Map objetosSesion = ActionContext.getContext().getSession();
        DaoReportes dao = new DaoReportes();
        int id = (int) objetosSesion.get("idUsuario");
        persona = dao.get(id);
        depto = dao.getdept(id);
        if (persona != null) {
            params = new HashMap();
            conn = ConexionSQLServer.getConnection();
            params.put("nombreuser", persona.getNombre() + " " + persona.getApp());
            params.put("depto", depto.getNombre());
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String EmployeeSalesReport() throws Exception {
        Map objetosSesion = ActionContext.getContext().getSession();
        DaoReportes dao = new DaoReportes();
        int id = (int) objetosSesion.get("idUsuario");
        persona = dao.get(id);
        depto = dao.getdept(id);
        if (persona != null) {
            params = new HashMap();
            conn = ConexionSQLServer.getConnection();
            System.out.println(persona.getNombre() + persona.getApp());
            System.out.println(depto.getNombre());
//            params.put("nombreuser", persona.getNombre() + " " + persona.getApp());
//            params.put("depto", depto.getNombre());
//            params.put("desde", desde);
//            params.put("hasta", hasta);
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

}
