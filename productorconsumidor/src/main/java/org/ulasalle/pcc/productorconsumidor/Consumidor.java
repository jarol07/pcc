/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.productorconsumidor;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.ulasalle.pcc.productorconsumidor.Productor.datos;

/**
 *
 * @author francisco
 */
public class Consumidor extends Thread
{

    public static boolean estaConsumido;
    public int id;

    public Consumidor(int id)
    {
        this.id = id;
    }

    @Override
    public void run()
    {
        long tiempo = System.currentTimeMillis();
        while (true)
            if (Productor.estaProducido)
            {
                System.out.println("hilo consumidor " + this.id + ", tiempo en espera para leer " + (System.currentTimeMillis() - tiempo) + " milisegundos");
                for (int i = 0; i < 4; i++)
                    try
                    {
                        int espera = ((new Random(System.nanoTime())).nextInt(2)) + 1;
                        Thread.sleep(espera * 1000);
                        System.out.println("hilo consumidor " + this.id + " consumiendo dato " + Productor.datos[i]);
                    } catch (InterruptedException ex)
                    {
                        Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                Consumidor.estaConsumido = true;
                Productor.estaProducido = false;
                tiempo = System.currentTimeMillis();
                if (datos[3] >= 30)
                    break;
            } else
                System.out.print("");
    }

}
