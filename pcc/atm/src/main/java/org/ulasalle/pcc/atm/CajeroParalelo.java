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
public class CajeroParalelo extends Thread {

    public static Billete[] billetes;
    private String nombre;
    private Cliente[] clientes;
    private int inicio;
    private int fin;
    
    public CajeroParalelo(String nombre, Cliente[] clientes,int inicio,int fin) {
        this.nombre = nombre;
        this.clientes = clientes;
        this.inicio=inicio;
        this.fin=fin;
    }

    public void run() {
        for (int i=inicio;i<fin;i++) {
            int temp = clientes[i].getMonto();
            String mensaje = "";
            StringBuilder acciones = new StringBuilder();
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
                            .append(clientes[i].getNombre())
                            .append(" la cantidad de ")
                            .append(cantidad)
                            .append(" billetes de ")
                            .append(billete.getMonto())
                            .append(" soles \n");
                }
            }
            if (temp > 0) {
                mensaje = "\nHola " + clientes[i].getNombre() + ", El " + nombre + " no cuenta con el monto solicitado " + clientes[i].getMonto() + ", monto minimo disponible a retirar " + (clientes[i].getMonto() - temp) + "\n";
            } else {
                mensaje = "\nHola " + clientes[i].getNombre() + ", El " + nombre + " va a retirar " + (clientes[i].getMonto() - temp) + "\n";
            }
            System.out.print(mensaje + acciones.toString());
        }
    }
}
