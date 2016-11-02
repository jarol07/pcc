package org.ulasalle.pcc.chat.cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import org.ulasalle.pcc.chat.Nodo;

public class Remoto
{
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    
    public Remoto(Socket socket) throws IOException
    {
        this.socket = socket;
        output=new ObjectOutputStream(socket.getOutputStream());
        input=new ObjectInputStream(socket.getInputStream());
    }

    public boolean existe(Nodo nodo)
    {
        return socket.getInetAddress().getHostAddress().equals(nodo.getDireccionLogica()) 
                    && socket.getPort()==nodo.getPuerto();
    }
    
    public ObjectOutputStream getOutput()
    {
        return output;
    }

    public ObjectInputStream getInput()
    {
        return input;
    }
    
    
}
