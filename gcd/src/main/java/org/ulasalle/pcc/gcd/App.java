/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.gcd;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author francisco
 */
public class App {
    
    public static void main(String[] args){
        
        List<Integer> numbers=new LinkedList<>();
        numbers.add(72);
        numbers.add(108);
        numbers.add(60);
        GCD gcd=new GCD(numbers);
        System.out.println(gcd.calculate());
    }
    
}
