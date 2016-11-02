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
public class App {
    
    public static void main(String[] args){
       
        int[][] matrix1=new int[][]{{1,0,0},{3,4,2}};
        int[][] matrix2=new int[][]{{2,1},{0,3},{1,0}};
        
        Product product=new Product();
        int[][] matrix=product.calculate(matrix1, matrix2);
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

}
