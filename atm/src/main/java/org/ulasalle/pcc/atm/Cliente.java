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
public class Cliente {
    private String nombre;
    private int monto;

    public Cliente(String nombre, int monto) {
        this.nombre = nombre;
        this.monto = monto;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
    
    
}
