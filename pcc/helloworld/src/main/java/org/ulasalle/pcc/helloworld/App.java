package org.ulasalle.pcc.helloworld;


import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rodrigo
 */
public class App extends Thread {

    private int id;
    private long time;

    public App(int id, long time) {
        this.id = id;
        this.time = time;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(time);
            System.out.println("Hello world " + id);
        } catch (InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        App h1 = new App(6, 1000);
        App h2 = new App(5, 2000);
        App h3 = new App(4, 3000);
        App h4 = new App(3, 4000);
        App h5 = new App(2, 5000);
        App h6 = new App(1, 6000);
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
        h6.start();

        System.out.println("----End");
    }

}
