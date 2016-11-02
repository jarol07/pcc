/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.fibonacci;

/**
 *
 * @author francisco
 */
public class Fibonacci {

    private int number1;
    private int number2;
    private int number3;

    public Fibonacci() {
        number1 = 0;
        number2 = 1;
        number3 = 0;
    }

    public void show(int limit) {
        System.out.println(this.number1);
        System.out.println(this.number2);
        calculate(limit);

    }

    private void calculate(int limit) {
        if (limit > 0) {
            this.number3 = this.number1 + this.number2;
            this.number1 = this.number2;
            this.number2 = this.number3;

            System.out.println(this.number3);
            calculate(limit-1);
        }
    }

}
