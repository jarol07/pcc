/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.matrixaddition;

/**
 *
 * @author francisco
 */
public class Simple {

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

        Matrix result = new Matrix(rows, cols);

        for (int k = 0; k < count; k++) {
            for (int i = 0; i < matrixs[0].getMatrix().length; i++) {
                for (int j = 0; j < matrixs[0].getMatrix()[0].length; j++) {
                    result.getMatrix()[i][j] += matrixs[k].getMatrix()[i][j];
                }
            }
        }

        long totalTiempo = System.currentTimeMillis() - tiempoInicio;
        System.out.println("El tiempo de demora es :" + totalTiempo + " miliseg");

    }

}
