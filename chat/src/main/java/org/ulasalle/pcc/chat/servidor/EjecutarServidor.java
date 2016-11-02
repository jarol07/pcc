package org.ulasalle.pcc.chat.servidor;

import org.ulasalle.pcc.chat.servidor.Servidor;
import java.io.IOException;

public class EjecutarServidor
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {

        Thread servidor=new Thread(new Servidor("127.0.0.1",9001 , "server 1"));
        servidor.start();
    }
}
