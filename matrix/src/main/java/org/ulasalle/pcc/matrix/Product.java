/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.matrix;

/**
 *
 * @author rodrigo
 */
public class Product {
    
    public int[][] calculate(int[][] matrix1, int[][] matrix2){
             
        int rows=matrix1[0].length;
        int cols=matrix2.length;
        
        if(rows==cols){
            
            int[][] matrix=new int[matrix1.length][matrix2[0].length];
            
            for(int i=0;i<matrix.length;i++){
            
                for(int j=0;j<matrix2[0].length;j++){
                
                    for(int l=0;l<rows;l++){
                    
                        matrix[i][j]+=matrix1[i][l]*matrix2[l][j];
                        
                    }
                    
                }
            
            }
            
            return matrix;
        }else{
            throw new RuntimeException("Las filas con las columnas entre las matrices deben ser del mismo tamaño");
        }
    }
    
}
