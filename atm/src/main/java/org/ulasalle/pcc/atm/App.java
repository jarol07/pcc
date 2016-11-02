/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.atm;

import java.util.Arrays;

/**
 *
 * @author francisco
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        long tiempoInicio = System.currentTimeMillis();
        
        Cliente[] clientes = new Cliente[]{
            new Cliente("Cliente 1", 1470),
            new Cliente("Cliente 2", 5210),
            new Cliente("Cliente 3", 8920),
            new Cliente("Cliente 4", 4280),
            new Cliente("Cliente 5", 7390),
            new Cliente("Cliente 6", 4610),
            new Cliente("Cliente 7", 3520),
            new Cliente("Cliente 8", 5270),
        };
        
        Cajero cajero=new Cajero("Cajero 1");
        for(Cliente cliente:clientes){
            cajero.retirar(cliente);
        }
        
        long totalTiempo = System.currentTimeMillis() - tiempoInicio;
        System.out.println("El tiempo de demora es :" + totalTiempo + " miliseg");
        
    }
    
}
