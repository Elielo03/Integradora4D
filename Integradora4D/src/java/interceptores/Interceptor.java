/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptores;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hermanos Saucedo
 */
public class Interceptor extends AbstractInterceptor {

    String actionPublico;
    String actionEmpleado;
    String actionAdministrador;

    public void setActionPublico(String actionPublico) {
        this.actionPublico = actionPublico;
    }

    public void setActionEmpleado(String actionEmpleado) {
        this.actionEmpleado = actionEmpleado;
    }

    public void setActionAdministrador(String actionAdministrador) {
        this.actionAdministrador = actionAdministrador;
    }

    List<String> permisosPublicos = new ArrayList();
    List<String> permisosEmpleado = new ArrayList();
    List<String> permisosAdmin = new ArrayList();

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        String respuesta = "index";
        String actionInvocar = (String) ActionContext.getContext().get(ActionContext.ACTION_NAME);
        if (ai.getInvocationContext().getSession().containsKey("idUsuario")) {

            if (ai.getInvocationContext().getSession().get("tipo").equals(2) && permisosAdmin.contains(actionInvocar)) {
                respuesta = ai.invoke();
            } else if (ai.getInvocationContext().getSession().get("tipo").equals(3) && permisosEmpleado.contains(actionInvocar)) {
                respuesta = ai.invoke();
            }

        } else if (permisosPublicos.contains(actionInvocar)) {
            respuesta = ai.invoke();
        }
        return respuesta;
    }

}
