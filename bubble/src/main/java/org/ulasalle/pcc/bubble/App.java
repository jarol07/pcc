/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.bubble;

import java.util.Random;

/**
 *
 * @author rodrigo
 */
public class App {

    public static void main(String[] args) {
        int size = 1000;
        int[] numbers = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(size);
        }
        Bubble bubble=new Bubble();
        numbers=bubble.sort(numbers);
        for (int i = 0; i < size; i++) {
            System.out.println(numbers[i]);
        }

    }
}
