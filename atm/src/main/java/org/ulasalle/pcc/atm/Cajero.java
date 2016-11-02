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
public class Cajero {
    
    private Billete[] billetes;
    private String nombre;
    
    public Cajero(String nombre) {
        this.billetes=new Billete[]{
            new Billete(200, 60),
            new Billete(100, 100),
            new Billete(50, 200),
            new Billete(20, 500)
        };
        this.nombre=nombre;
    }
    
    public void retirar(Cliente cliente){
        int temp=cliente.getMonto();
        String mensaje="";
        StringBuilder acciones=new StringBuilder();
        for (Billete billete : billetes) {
            if (temp >= billete.getMonto()) {
                int cantidad = temp / billete.getMonto();
                if (cantidad > billete.getCantidad()) {
                    cantidad = billete.getCantidad();
                    billete.restarCantidad(cantidad);
                    temp -= cantidad * billete.getMonto();
                } else {
                    temp = temp % billete.getMonto();
                    billete.restarCantidad(cantidad);
                }
                acciones.append(nombre)
                        .append(" a retirar para el cliente ")
                        .append(cliente.getNombre())
                        .append(" la cantidad de ")
                        .append(cantidad)
                        .append(" billetes de ")
                        .append(billete.getMonto())
                        .append(" soles \n");
            }
        }
        if(temp>0){
            mensaje="\nHola "+cliente.getNombre()+", El "+nombre+" no cuenta con el monto solicitado "+cliente.getMonto()+", monto minimo disponible a retirar "+(cliente.getMonto()-temp)+"\n";
        }else{
            mensaje="\nHola "+cliente.getNombre()+", El "+nombre+" va a retirar "+(cliente.getMonto()-temp)+"\n";
        }
        System.out.print(mensaje+acciones.toString());
    }
    
}
