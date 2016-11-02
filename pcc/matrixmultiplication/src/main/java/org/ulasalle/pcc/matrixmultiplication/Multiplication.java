/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.matrixmultiplication;

import java.awt.Point;

/**
 *
 * @author francisco
 */
public class Multiplication extends Thread{
    
    private int[] row;
    private int[] col;
    private Point position;
    
    public Multiplication(int[] row,int[] col,Point position){
        this.row=row;
        this.col=col;
        this.position=position;
    }
    
    @Override
    public void run(){
        int value=0;
        for(int i=0;i<row.length;i++){
            value+=row[i]*col[i];
        }
        
        Matrix.matrix[position.x][position.y]=value;
    }
    
}
