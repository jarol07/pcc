/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.supermarket;

/**
 *
 * @author rodrigo
 */
public class Customer {
    private String name;
    int[] productos;

    public Customer(String name, int[] productos) {
        this.name = name;
        this.productos = productos;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getProductos() {
        return productos;
    }

    public void setProductos(int[] productos) {
        this.productos = productos;
    }
    
    
}
