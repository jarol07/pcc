package org.ulasalle.pcc.chat.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ulasalle.pcc.chat.Nodo;

public class Administrador extends Thread
{
    private Socket socket;
    private static List<String> comandos;
    private static Object candado;
    private ObjectOutputStream objectOutput;
    private ObjectInputStream objectInput;
    private Nodo nodo;
    
    public Administrador(Socket socket,Nodo nodo) throws IOException
    {
        this.socket=socket;
        this.candado=new Object();
        this.nodo=nodo;
        if(this.comandos==null) this.comandos=new ArrayList<>();
        this.objectInput=new ObjectInputStream(socket.getInputStream());
        this.objectOutput=new ObjectOutputStream(socket.getOutputStream());
    }

    public Socket getSocket()
    {
        return socket;
    }
  
    private boolean agregarComando(String comando)
    {
        synchronized(candado)
        {
            return comandos.add(comando);
        }
    }
    
    
    public void run()
    {
        try
        {
            objectOutput.writeObject("ADDED :: "+nodo.getDireccionLogica()+":"+nodo.getPuerto());
            while(true)
            {
                Object object=objectInput.readObject();
                if(object==null) return ;
                String comando= (String) object;
                if(agregarComando(comando))
                {
                    objectOutput.writeObject("ADDED [COMANDO :: "+nodo.getDireccionLogica()+":"+nodo.getPuerto()+"]"+comando);
                }
                else
                {
                    objectOutput.writeObject("ERROR [COMANDO :: "+nodo.getDireccionLogica()+":"+nodo.getPuerto()+"]"+comando);
                }
            }
        } catch (IOException | ClassNotFoundException ex)
        {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
