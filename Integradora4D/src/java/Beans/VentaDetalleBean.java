/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.List;

/**
 *
 * @author Eliel David
 */
public class VentaDetalleBean {
    private int idVenta_detalle;
    private int cantidad;
    private double costo_venta;
    private int idVenta;
    private  List<ProductoBean> productos;

    public VentaDetalleBean() {
    }


    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdVenta_detalle() {
        return idVenta_detalle;
    }

    public void setIdVenta_detalle(int idVenta_detalle) {
        this.idVenta_detalle = idVenta_detalle;
    }

    public double getCosto_venta() {
        return costo_venta;
    }

    public void setCosto_venta(double costo_venta) {
        this.costo_venta = costo_venta;
    }

    


    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public List<ProductoBean> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoBean> productos) {
        this.productos = productos;
    }

    

   
    
    
}
