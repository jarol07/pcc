package org.ulasalle.pcc.puzzle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Puzzle
{
    private int[][] objetivo;
    private Deque<Tabla> tablas;

    private int recursiones;
    
    public Puzzle(int[][] objetivo,int[][] datos)
    {
        this.tablas=new ArrayDeque<>();
        this.tablas.push(new Tabla(datos));
        this.objetivo=objetivo;
        this.recursiones=0;
    }
    
    private int contarMovimiento(Tabla tabla,int valor, int xObjetivo, int yObjetivo)
    {
        for (int i = 0; i < tabla.getDatos().length; i++)
            for (int j = 0; j <  tabla.getDatos().length; j++)
                if (tabla.getDatos()[i][j] == valor)
                    return Math.abs(i - xObjetivo) + Math.abs(j - yObjetivo);
        return 0;
    }
    
    public void mostrar(Tabla tabla)
    {
        while(tabla.getPadre()!=null)
        {
            tabla.mostrar();
            tabla=tabla.getPadre();
            System.out.println("____________________________");
        }
        tabla.mostrar();
    }
    
    public void calcular()
    {
       
        while(tablas.peek().getDistancia()!=0)
        {
            Tabla[] hijos=tablas.peek().getHijos();
            for(Tabla t:hijos) t.setDistancia(getManhattan(t, objetivo));
            Arrays.sort(hijos);
            tablas.pop();
            for(Tabla t:hijos)
            {
                tablas.add(t);
            }
            this.recursiones++;
        }
            mostrar(tablas.peek());
            System.out.println(this.recursiones);
       
    }

        
    
    public int getManhattan(Tabla tabla, int[][] objetivo)
    {
        int movimientos = 0;
        for (int i = 0; i < tabla.getDatos().length; i++)
            for (int j = 0; j < tabla.getDatos().length; j++)
                if (objetivo[i][j] != tabla.getDatos()[i][j])
                    movimientos += contarMovimiento(tabla, objetivo[i][j], i, j);
                    
        return movimientos;
    }

    
}
