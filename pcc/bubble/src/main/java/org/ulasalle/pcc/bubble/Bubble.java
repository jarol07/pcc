/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.bubble;

/**
 *
 * @author rodrigo
 */
public class Bubble {
    
    public int[] sort(int[] numbers){
        
        int n1=0;
        int n2=0;
        int temp=0;
        
        for(int i=0;i<numbers.length;i++){
            
            for(int j=0;j<numbers.length;j++){
            
                if(numbers[j]>numbers[i]){
                    
                    temp=numbers[j];
                    numbers[j]=numbers[i];
                    numbers[i]=temp;
                }
                
            }
            
        }
        
        return numbers;
    }
    
}
