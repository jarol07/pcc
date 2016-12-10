package org.ulasalle.pcc.cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cliente implements Runnable
{

    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private Socket socket;
    private List<Tarea> tareas;
    private ExecutorService ejecutor;

    public Cliente()
    {
        this.tareas = new ArrayList<>();
        this.ejecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    @Override
    public void run()
    {
        try
        {
            this.socket = new Socket("127.0.0.1", 9999);
            this.salida = new ObjectOutputStream(socket.getOutputStream());
            this.entrada = new ObjectInputStream(socket.getInputStream());
            recibir();
        } catch (IOException exception)
        {
            exception.printStackTrace();
        } finally
        {
            desconectar();
        }
    }

    private void recibir()
    {
        boolean bandera = false;
        try
        {
            Object object;
            while ((object = entrada.readObject()) != null)
            {
                if (object instanceof Tarea)
                {
                    Tarea tarea = (Tarea) object;
                    int indice = -1;
                    for (int i = 0; i < tareas.size(); i++)
                        if (tareas.get(i).equals(tarea))
                            indice = i;

                    if (indice == -1)
                    {
                        this.tareas.add(tarea);
                        tarea.setCambio(true);
                        this.ejecutor.submit(this.tareas.get(this.tareas.size() - 1));
                    } else
                        this.tareas.get(indice).setEstado(tarea.getEstado());
                    if (!bandera)
                    {
                        escucharTarea();
                        bandera = true;
                    }
                }
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

    private void escucharTarea()
    {
        this.ejecutor.submit(() ->
        {
            while (true)
            {
                tareas.forEach(tarea ->
                {
                    if (tarea.esCambio())
                    {
                        enviar();
                        tarea.setCambio(false);
                    }
                });
                Thread.sleep(15);
            }
        });
    }

    private void enviar()
    {
        try
        {
            Tarea[] t = new Tarea[tareas.size()];
            t = tareas.toArray(t);
            this.salida.reset();
            this.salida.writeObject(t);

        } catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }

    private void desconectar()
    {
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

}
