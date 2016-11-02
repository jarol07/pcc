/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.matrixmultiplication;

import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author francisco
 */
public class App {
    public static void main(String[] args){
        int[][] matrix1=new int[3][3];
        int[][] matrix2=new int[3][2];
        
        matrix1[0]=new int[] {3,2,1};
        matrix1[1]=new int[] {1,1,3};
        matrix1[2]=new int[] {0,2,1};
        
        matrix2[0]=new int[] {2,1};
        matrix2[1]=new int[] {1,0};
        matrix2[2]=new int[] {3,2};
        
        
        
        int length=matrix1[0].length;
        
        int colsMatrix1=matrix1[0].length;
        int rowsMatrix1=matrix1.length;
        int colsMatrix2=matrix2[0].length;
        int rowsMatrix2=matrix2.length;
        
        Matrix.matrix= new int[rowsMatrix1][colsMatrix2]; 
        
        Multiplication[] multiplications=new Multiplication[rowsMatrix1*colsMatrix2];
        
        int count=0;
        
        for(int indexMatrix1=0;indexMatrix1<rowsMatrix1;indexMatrix1++){
             
            for(int indexMatrix2=0;indexMatrix2<colsMatrix2;indexMatrix2++){
                
                try {
                    
                    int[] row=matrix1[indexMatrix1];
                    int[] col=new int[length];
                    
                    for(int i=0;i<length;i++){
                        col[i]=matrix2[i][indexMatrix2];
                    }
                    
                    multiplications[count]=new Multiplication(row,col, new Point(indexMatrix1, indexMatrix2));
                   
                    multiplications[count].start();
                    multiplications[count].join(1000);
                    count++;
                } catch (InterruptedException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        Matrix matrix=new Matrix();
        matrix.show();
        
    }
}
