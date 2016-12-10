package org.ulasalle.pcc.cliente;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Aplicacion
{

    public static void main(String[] args) throws ClassNotFoundException, InterruptedException
    {
        ExecutorService ejecutor;
        Cliente cliente = new Cliente();
        ejecutor = Executors.newSingleThreadExecutor();
        ejecutor.submit(cliente);
       
    }

}
