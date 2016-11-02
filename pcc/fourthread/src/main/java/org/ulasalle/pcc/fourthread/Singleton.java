/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.fourthread;

/**
 *
 * @author rodrigo
 */
public class Singleton {
    private Singleton(){
    }
    
    public static Singleton singleton=new Singleton();
    
    int increment;

    public int getIncrement() {
        return increment;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }
    
}
