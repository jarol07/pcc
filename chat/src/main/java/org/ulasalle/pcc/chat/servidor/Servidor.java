package org.ulasalle.pcc.chat.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ulasalle.pcc.chat.Nodo;

public class Servidor extends Nodo implements Runnable 
{
    private final ServerSocket servidor;
    private List<Administrador> administradores;
        
    public Servidor(String direccionLogica, int puerto, String nombre) throws IOException
    {
        super(direccionLogica, puerto, nombre);
        this.servidor = new ServerSocket(puerto);
        administradores=new ArrayList<>();
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                boolean flag=false;
                Socket socket=servidor.accept();
                for(Administrador adm:administradores)
                {
                    if(adm.getSocket().getInetAddress()==socket.getInetAddress() && adm.getSocket().getPort()==socket.getPort())
                    {
                        flag=true;
                    }
                }
                if(!flag)
                {
                    Administrador administrador=new Administrador(socket,this);
                    if(!administradores.contains(administrador))
                    {
                        administradores.add(administrador);
                        administrador.start();
                    }else
                    {
                        System.out.println("ya existe una computadora con esas caracteristicas");
                    }
                }

            } catch (IOException ex)
            {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }
}
