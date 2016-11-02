/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.productorconsumidor;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author francisco
 */
public class Productor extends Thread
{

    public static int[] datos;
    public static boolean estaProducido;
    public int id;

    public Productor(int id)
    {
        if (Productor.datos == null)
            Productor.datos = new int[4];
        this.id = id;
    }

    @Override
    public void run()
    {
        long tiempo = System.currentTimeMillis();
        while (true)
            if (Consumidor.estaConsumido || Productor.datos[3] == 0)
            {
                Productor.estaProducido = false;
                System.out.println("hilo productor " + this.id + ", tiempo en espera para llenar " + (System.currentTimeMillis() - tiempo) + " milisegundos");
                int ultimo = datos[3] + 1;
                for (int i = 0; i < 4; i++)
                    try
                    {
                        int espera = ((new Random(System.nanoTime())).nextInt(2)) + 1;
                        Thread.sleep(espera * 1000);
                        datos[i] = ultimo + i;
                    } catch (InterruptedException ex)
                    {
                        Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                Productor.estaProducido = true;
                Consumidor.estaConsumido = false;
                tiempo = System.currentTimeMillis();
                if (datos[3] >= 30)
                    break;
            } else
                System.out.print("");
    }

}
