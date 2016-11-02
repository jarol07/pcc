package org.ulasalle.pcc.chat.cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ulasalle.pcc.chat.Nodo;

import org.ulasalle.pcc.chat.cliente.Remoto;

public class Cliente extends Nodo implements Runnable
{
    private List<Remoto> servidores;

    public Cliente(String direccionLogica, int puerto, String nombre)
    {
        super(direccionLogica, puerto, nombre);
        servidores=new ArrayList<>();
    }
    
    public void agregarServidor(Nodo nodo) throws IOException, ClassNotFoundException
    {
        Remoto servidor=new Remoto(new Socket(nodo.getDireccionLogica(), nodo.getPuerto()));
        this.servidores.add(servidor);
        System.out.println((String) servidor.getInput().readObject());
    }
    
    public void enviarComando(Nodo nodo,String comando) throws IOException, ClassNotFoundException
    {
        for(Remoto servidor:servidores)
        {
            if(servidor.existe(nodo))
            {
                servidor.getOutput().writeObject(comando);
                System.out.println((String) servidor.getInput().readObject());
            }
        }
    }

    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                Scanner scanner=new Scanner(System.in);
                System.out.println("Agregar computadoras");
                System.out.println("Direccion logica:");
                String direccionLogica=scanner.next();
                System.out.println("Puerto:");
                int puerto=scanner.nextInt();
                agregarServidor(new Nodo(direccionLogica, puerto, "pc1"));
                for(int i=0;i<30000;i++)
                {
                    enviarComando(new Nodo(direccionLogica, puerto, "pc1"), "comando "+i);
                  
                }
            } catch (IOException | ClassNotFoundException ex)
            {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
