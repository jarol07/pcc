package org.ulasalle.pcc.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import org.ulasalle.pcc.cliente.Tarea;

public class Cliente implements Runnable
{

    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private Socket socket;
    private Tarea[] tareas;

    public Cliente()
    {
    }

    public Tarea[] getTareas()
    {
        return tareas;
    }

    public boolean estaConectado()
    {
        return !this.socket.isClosed();
    }

    public void conectar(Socket socket)
    {
        this.socket = socket;
        try
        {
            this.salida = new ObjectOutputStream(this.socket.getOutputStream());
            this.entrada = new ObjectInputStream(this.socket.getInputStream());

        } catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }

    public void enviar(Tarea tarea)
    {
        if (this.socket.isConnected())
            try
            {
                this.salida.reset();
                this.salida.writeObject(tarea);
            } catch (IOException exception)
            {
                exception.printStackTrace();
            }
    }

    private void recibir()
    {
        if (this.socket.isConnected())
            try
            {

                Object object;
                while ((object = entrada.readObject()) != null)
                {
                    if (object instanceof Tarea[])
                        this.tareas = (Tarea[]) object;
                    Thread.sleep(15);
                }

            } catch (InterruptedException | IOException | ClassNotFoundException exception)
            {
                if (!(exception instanceof IOException))
                    exception.printStackTrace();
            } finally
            {
                desconectar();
            }
    }

    public void desconectar()
    {
        if (this.socket.isConnected())
            try
            {
                this.entrada.close();
                this.salida.close();
                this.socket.close();
            } catch (IOException exception)
            {
                exception.printStackTrace();
            }
    }

    @Override
    public void run()
    {
        recibir();
    }

}
