package org.ulasalle.pcc.chat.cliente;

import org.ulasalle.pcc.chat.cliente.Cliente;
import java.io.IOException;

public class EjecutarCliente
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {

        Thread cliente=new Thread(new Cliente("127.0.0.1",9001 , "server 1"));
        cliente.start();
    }
}
