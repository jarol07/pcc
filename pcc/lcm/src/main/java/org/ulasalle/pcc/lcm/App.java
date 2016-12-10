/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.lcm;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author francisco
 */
public class App {
    
    public static void main(String[] args){
        
        List<Integer> numbers=new LinkedList<>();
        numbers.add(9);
        numbers.add(6);
        numbers.add(4);
        LCM lcm=new LCM(numbers);
        System.out.println(lcm.calculate());
    }
    
}
