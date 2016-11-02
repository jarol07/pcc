package org.ulasalle.pcc.chat;

public class Nodo
{
    private String direccionLogica;
    private int puerto;
    private String nombre;

    public Nodo()
    {
    }
    
    public Nodo(String direccionLogica, int puerto, String nombre)
    {
        this.direccionLogica = direccionLogica;
        this.puerto = puerto;
        this.nombre = nombre;
    }
    
    public String getDireccionLogica()
    {
        return direccionLogica;
    }

    public void setDireccionLogica(String direccionLogica)
    {
        this.direccionLogica = direccionLogica;
    }

    public int getPuerto()
    {
        return puerto;
    }

    public void setPuerto(int puerto)
    {
        this.puerto = puerto;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    
    
}
