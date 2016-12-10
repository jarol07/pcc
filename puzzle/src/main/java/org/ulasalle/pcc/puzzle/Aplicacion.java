package org.ulasalle.pcc.puzzle;

public class Aplicacion
{

    public static void main(String[] args)
    {
        int[][] datos = new int[][]
        {
            {
                0,3,2
            }, 
            {
                8,7,1
            }, 
            {
                4, 5, 6
            }
        };
        int[][] objetivo = new int[][]
        {
            {
                1, 2, 3
            }, 
            {
                4, 5, 6
            }, 
            {
                7, 8, 0
            }
        };
        
        Puzzle puzzle=new Puzzle(objetivo,datos);
         long startTime = System.currentTimeMillis();
        puzzle.calcular();
       System.out.println("Tiempo:" + (System.currentTimeMillis() - startTime));
    }

}
