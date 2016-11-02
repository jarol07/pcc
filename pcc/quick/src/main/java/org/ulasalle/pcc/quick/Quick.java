/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.quick;

/**
 *
 * @author rodrigo
 */
public class Quick {
    
    int partition(int array[],int left,int right){
        
        
        int i=left;
        int j=right;
        
        int temp=0;
        
        int middle=left+(right-left )/2;
        int pivot=array[middle];
        
        //evitamos que colisionen
        while(i<=j){
            //i es el index, se enviara a la derecha
            while(array[i]<pivot){
                i++;
            }
            //j es el index, se enviara a la izquierda
            while(array[j]>pivot){
                j--;
            }
            //realiza en cambio, si no supera al index de la derecha
            if(i<=j){
                temp=array[i];
                array[i]=array[j];
                array[j]=temp;
                i++;
                j--;
            }
            
        }
        return i;
    }
    
    
    public void sort(int array[],int left,int right){
        
        if(array==null) return;
        if(left>right) return;
        
        int index=partition(array, left, right);
        
        //ordena lado izquierdo
        if(left <index-1){
            sort(array, left, index-1);
        }
        
        //ordena lado derecho
        if(index<right){
            sort(array, index, right);
        }
    }
}
