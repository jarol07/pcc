package org.ulasalle.pcc.puzzle;

import java.util.List;

public class Tabla implements Comparable<Tabla>
{

    private int[][] datos;
    private int distancia;
    private Tabla padre;
    
    public Tabla(int[][] datos)
    {
        this.datos=datos;
        this.distancia=Integer.MAX_VALUE;
        this.padre=null;
    }
    
    public Tabla(int[][] datos,Tabla padre)
    {
        this.datos=datos;
        this.distancia=Integer.MAX_VALUE;
        this.padre=padre;
    }


    public int[][] getDatos()
    {
        return datos;
    }

    public int getDistancia()
    {
        return distancia;
    }

    public void setDistancia(int distancia)
    {
        this.distancia = distancia;
    }

    public Tabla getPadre()
    {
        return padre;
    }

    public void setPadre(Tabla padre)
    {
        this.padre = padre;
    }
 
    public boolean esMovible(int posicion, int longitud)
    {
        return posicion > -1 && posicion < longitud;
    }
    
    private int getLongitud(Tabla[] tabla)
    {
        int contar=0;
        for (Tabla t : tabla)
            if (t != null)
                contar++;
        return contar;
    }
    
    private Tabla[] copiar(Tabla[] tabla)
    {
        Tabla[] nueva=new Tabla[getLongitud(tabla)];
        for (int i=0,j=0;i<tabla.length;i++)
            if (tabla[i] != null)
                nueva[j++]=new Tabla(tabla[i].datos, tabla[i].padre);
        return nueva;        
    }
    

    
    public void mostrar()
    {
        for (int[] dato : datos)
        {    
            for (int y = 0; y < datos.length; y++)
                System.out.print(dato[y] + " ");
            System.out.println();
        }
    }
    
    public Tabla[] getHijos()
    {
        Tabla[] tmp=new Tabla[4];
        for (int x = 0; x < datos.length; x++)
        {
            for (int y = 0; y < datos.length; y++)
            {
                if (datos[x][y] == 0)
                {
                    if(esMovible(y-1, datos.length)) tmp[0]=new Tabla(crearHijo(x, y, 0, datos), this);
                    if(esMovible(y+1, datos.length)) tmp[1]=new Tabla(crearHijo(x, y, 1, datos), this);
                    if(esMovible(x+1, datos.length)) tmp[2]=new Tabla(crearHijo(x, y, 2, datos), this);
                    if(esMovible(x-1, datos.length)) tmp[3]=new Tabla(crearHijo(x, y, 3, datos), this);
                }
            }
        }      

        return copiar(tmp);
    }
 
    private int[][] crearHijo(int x,int y, int movimiento, int[][] tabla)
    {
        int[][] nuevo =new int[tabla.length][tabla.length];
        for(int i=0;i<tabla.length;i++)
            System.arraycopy(tabla[i], 0, nuevo[i], 0, tabla.length);
        int temp;
        switch (movimiento)
        {
            case 0: //arriba
                temp=nuevo[x][y];
                nuevo[x][y]=nuevo[x][y-1];
                nuevo[x][y-1]=temp;
                break;
            case 1: //abajo
                temp=nuevo[x][y];
                nuevo[x][y]=nuevo[x][y+1];
                nuevo[x][y+1]=temp;
                break;
            case 2://derecha
                temp=nuevo[x][y];
                nuevo[x][y]=nuevo[x+1][y];
                nuevo[x+1][y]=temp;
                break;
            case 3://izquierda
                temp=nuevo[x][y];
                nuevo[x][y]=nuevo[x-1][y];
                nuevo[x-1][y]=temp;
                break;
        }
        return nuevo;
    }

    @Override
    public int compareTo(Tabla o)
    {
        return this.distancia-o.distancia;
    }
    
}
