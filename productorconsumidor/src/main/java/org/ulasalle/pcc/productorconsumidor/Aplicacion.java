/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.productorconsumidor;

/**
 *
 * @author francisco
 */
public class Aplicacion
{
    public static void main(String[] args)
    {

            Productor productor=new Productor(0);
            Consumidor consumidor=new Consumidor(0);
            productor.start();
            consumidor.start();
        

        
    }
}
