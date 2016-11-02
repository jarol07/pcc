/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.matrixaddition;

import java.util.Random;

/**
 *
 * @author francisco
 */
public class Matrix {
    
    private int[][] matrix;
    
    
    public Matrix(int rows, int cols){
        this.matrix=new int[rows][cols];
    }

    public  int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    
    
    public void llenar(){
        Random random = new Random(System.nanoTime());
        random.nextInt(100);
        
        for(int i=0;i<matrix.length;i++){
       
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j]=random.nextInt(10);
            }
        }
    }
    
    public void mostrar(){
        for(int i=0;i<matrix.length;i++){
            System.out.println();
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
        }
        System.out.println();
    }
    
    
}
