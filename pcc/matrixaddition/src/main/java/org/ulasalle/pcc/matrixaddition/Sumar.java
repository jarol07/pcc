/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.matrixaddition;

/**
 *
 * @author francisco
 */
public class Sumar extends Thread{
    
    private int inicio;
    private int fin;
    private Matrix[] matrixs;
    public static Matrix matrix;
    
    public Sumar(int inicio, int fin, Matrix[] matrixs){
        this.inicio=inicio;
        this.fin=fin;
        this.matrixs=matrixs;
        matrix=new Matrix(matrixs[0].getMatrix().length, matrixs[0].getMatrix()[0].length);
       
    }
    
    public void run(){
        
        for(int j=0;j<this.matrixs.length;j++){
           // System.out.println("[ "+this.getName()+" ]"+"[ "+j+" ]"+"[ "+this.matrixs.length+" ]"+inicio+" - "+ fin);
            for(int i=inicio;i<fin;i++){
                
                for(int k=0;k<matrixs[j].getMatrix()[0].length;k++){
                    //System.out.println("[ "+matrixs[j].getMatrix()[i].length+" ]"+"[ "+j+" ]");
                    matrix.getMatrix()[i][k]+=matrixs[j].getMatrix()[i][k];
                }
            }
        }
        
    }
    
    
}
