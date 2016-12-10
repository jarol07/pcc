/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.criticalsection;

import java.util.Random;

/**
 *
 * @author rodrigo
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        int nNucleos = runtime.availableProcessors();
        System.out.println("Numeros de nucleos fisicos:" + nNucleos);
        
        
        int between=2;
        System.out.print("\n-----------------------");
        int[] vector = Cliente.vector;
        Random random = new Random(System.nanoTime());
        for (int i = 0; i < vector.length; i++) {
            vector[i] = random.nextInt(100);
            System.out.print(vector[i] + " ");
        }
        Cliente.vector = vector;
        System.out.print("\n-----------------------");

        Cliente[] clientes = new Cliente[vector.length];
        int j = 0;
        for (int i = 0; i < vector.length; i = i + between, j++) {
            clientes[j] = new Cliente("Thread " + j+" ["+i+" , "+(i+between)+"] ", i, i + between);
            clientes[j].start();
        }
        try {
            clientes[j].join();
        } catch (Exception e) {

        }
        System.out.println("End hilo principal");
    }

}
