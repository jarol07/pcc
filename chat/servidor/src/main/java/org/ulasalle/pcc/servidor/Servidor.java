package org.ulasalle.pcc.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor implements Runnable
{

    private ServerSocket serverSocket;
    private Map<String, Cliente> clientes;
    private ExecutorService ejecutor;

    public Servidor()
    {
    }

    public Map<String, Cliente> getClientes()
    {
        return clientes;
    }

    @Override
    public void run()
    {
        escuchar();
    }

    public Cliente getCliente(String ip)
    {
        return this.clientes.get(ip);
    }

    private void escuchar()
    {
        try
        {
            this.serverSocket = new ServerSocket(9999);
            this.ejecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            llenarClientes();
            while (true)
            {
                Socket socket;
                socket = serverSocket.accept();
                String ip = socket.getInetAddress().getHostAddress();
                System.out.println(ip);
                if (this.clientes.containsKey(ip))
                {
                    this.clientes.put(ip, new Cliente());
                    this.clientes.get(ip).conectar(socket);
                    this.ejecutor.submit(this.clientes.get(ip));
                }
            }
        } catch (IOException exception)
        {
            exception.printStackTrace();
        } finally
        {
            desconectar();
        }
    }

    private void desconectar()
    {
        try
        {
            this.clientes.forEach((ip, cliente) ->
            {
                cliente.desconectar();
            });
            this.serverSocket.close();
            this.clientes = null;
            this.serverSocket = null;
        } catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }

    private void llenarClientes()
    {
        this.clientes = new HashMap<>();
        this.clientes.put("127.0.0.1", null);
        this.clientes.put("192.168.0.12", null);
    }

}
