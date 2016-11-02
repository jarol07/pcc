/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.quick;

import java.util.Arrays;

/**
 *
 * @author rodrigo
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array={9,20,5,8,2,1,10,0,3,6,-1,7};
        //Burbble burble=new Burbble();
        //burble.sort(array);
        
        Quick quick=new Quick();
        quick.sort(array, 0, array.length-1);
        

        System.out.println(Arrays.toString(array));
  
        
    }
    
}
