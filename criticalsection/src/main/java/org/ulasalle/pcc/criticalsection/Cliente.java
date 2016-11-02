/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.criticalsection;

/**
 *
 * @author rodrigo
 */
public class Cliente extends Thread{
    
    public int init;
    public int limit;    
    public static String nombre;
    public static int[] vector=new int[100];

    public Cliente(String nombre,int init, int limit) {
        this.nombre=nombre;
        this.init = init;
        this.limit = limit;
    }
    
    
    public void run(){
        System.out.println("\n Inicio ... "+this.nombre+" ------------------------");
        while(init<limit){
            System.out.print((vector[init]*10)+" ");
            init++;
        }
        System.out.println("\n Fin ..."+this.nombre+" ------------------------");
    }
}
