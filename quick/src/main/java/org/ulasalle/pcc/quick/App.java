package org.ulasalle.pcc.quick;

import java.util.Arrays;
import java.util.Random;

public class App
{

    public static void main(String[] args)
    {
        int cantidad = 100000000;
        Random random = new Random();

        int[] elementos = new int[cantidad];
        for (int i = 0; i < cantidad; i++)
            elementos[i] = random.nextInt(cantidad);

        Quick quick = new Quick();
        long startTime = System.currentTimeMillis();
        quick.sort(elementos, 0, elementos.length - 1);
        System.out.println("Tiempo:" + (System.currentTimeMillis() - startTime));
//
//        System.out.println(Arrays.toString(elementos));

    }

}
