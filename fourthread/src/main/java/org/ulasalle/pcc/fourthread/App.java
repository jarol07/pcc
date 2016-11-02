/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.fourthread;

/**
 *
 * @author rodrigo
 */
public class App {
    
     public static void main(String[] args) {
         
         //manejo de la seccion critica,lecturas falsas
         ThreadSingleton threadSingleton1=new ThreadSingleton(1);
         ThreadSingleton threadSingleton2=new ThreadSingleton(2);
         ThreadSingleton threadSingleton3=new ThreadSingleton(3);
         ThreadSingleton threadSingleton4=new ThreadSingleton(4);
         
         Singleton.singleton.setIncrement(0);
         
         threadSingleton1.start();
         threadSingleton2.start();
         threadSingleton3.start();
         threadSingleton4.start();
         
         System.out.println(Singleton.singleton.getIncrement());
     }
}
