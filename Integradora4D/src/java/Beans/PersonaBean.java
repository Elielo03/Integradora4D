/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.Date;

/**
 *
 * @author Eliel David
 */
public class PersonaBean {

    private int idPersona;
    private String nombre;
    private String app;
    private String apm;
    private String direccion;
    private String fechaNac;
    private boolean estado;
    private UsuarioBean Usuario;
    private DepartamentoBean Departamento;
    private String correoE;
    private String telefono;
    private String pass;

    public PersonaBean() {
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

  

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public UsuarioBean getUsuario() {
        return Usuario;
    }

    public void setUsuario(UsuarioBean Usuario) {
        this.Usuario = Usuario;
    }

    

    public DepartamentoBean getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(DepartamentoBean Departamento) {
        this.Departamento = Departamento;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
