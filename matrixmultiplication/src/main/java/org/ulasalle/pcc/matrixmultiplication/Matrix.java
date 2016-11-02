/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.matrixmultiplication;

/**
 *
 * @author francisco
 */
public class Matrix {
    public static int[][] matrix;
    
    public void show(){
        for(int i=0;i<matrix.length;i++){
            System.out.println();
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(" "+matrix[i][j]+" ");
            }
        }
    }
}
