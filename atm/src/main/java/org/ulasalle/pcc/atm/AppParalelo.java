/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.atm;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author francisco
 */
public class AppParalelo {

    public static void main(String[] args) {
        long tiempoInicio = System.currentTimeMillis();

        Cliente[] clientes = new Cliente[]{
            new Cliente("Cliente 1", 1470),
            new Cliente("Cliente 2", 5210),
            new Cliente("Cliente 3", 8920),
            new Cliente("Cliente 4", 4280),
            new Cliente("Cliente 5", 7390),
            new Cliente("Cliente 6", 4610),
            new Cliente("Cliente 7", 3520),
            new Cliente("Cliente 8", 5270),};

        int nucleos = Runtime.getRuntime().availableProcessors();
        int segmento = clientes.length / nucleos;

        CajeroParalelo.billetes = new Billete[]{
            new Billete(200, 60),
            new Billete(100, 100),
            new Billete(50, 200),
            new Billete(20, 500)
        };

        CajeroParalelo[] cajerosParalelos = new CajeroParalelo[nucleos];
        int inicio = 0;
        int fin = segmento;
        for (int i = 0; i < nucleos; i++) {
            cajerosParalelos[i] = new CajeroParalelo("cajero" + (i + 1), clientes, inicio, fin);
            cajerosParalelos[i].start();
            inicio = fin;
            fin = fin + segmento;
        }

        for (int i = 0; i < nucleos; i++) {
            try {
                cajerosParalelos[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(AppParalelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        long totalTiempo = System.currentTimeMillis() - tiempoInicio;
        System.out.println("El tiempo de demora es :" + totalTiempo + " miliseg");

    }
}
