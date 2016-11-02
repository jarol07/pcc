/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.matrixaddition;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author francisco
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long tiempoInicio = System.currentTimeMillis();
        int rows = 5000;
        int cols = 5000;
        int count = 4;

        Matrix[] matrixs = new Matrix[count];
        for (int i = 0; i < count; i++) {
            matrixs[i] = new Matrix(rows, cols);
            matrixs[i].llenar();
            //matrixs[i].mostrar();
        }

        int nucleos = Runtime.getRuntime().availableProcessors();
        int operaciones = rows / nucleos;

        int inicio = 0;
        int fin = operaciones;
        Sumar[] sumars = new Sumar[nucleos];
        for (int i = 0; i < nucleos; i++) {
            sumars[i] = new Sumar(inicio, fin, matrixs);
            sumars[i].start();
            inicio = fin;
            fin = fin + operaciones;

        }

        long totalTiempo = System.currentTimeMillis() - tiempoInicio;
        System.out.println("El tiempo de demora es :" + totalTiempo + " miliseg");

    }

}
