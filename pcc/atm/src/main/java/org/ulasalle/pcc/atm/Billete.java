/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.atm;

/**
 *
 * @author francisco
 */
public class Billete {
    
    private int monto;
    private int cantidad;

    public Billete(int monto, int cantidad) {
        this.monto = monto;
        this.cantidad = cantidad;
    }
    
    public int restarCantidad(int cantidad){
        this.cantidad=this.cantidad-cantidad;
        return this.cantidad;
    }
    
    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
