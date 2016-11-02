package org.ulasalle.pcc.chat;

public class Nodo
{
    private String direccionLogica;
    private int puerto;

    public Nodo()
    {
    }
    
    public Nodo(String direccionLogica, int puerto)
    {
        this.direccionLogica = direccionLogica;
        this.puerto = puerto;
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

}
