/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.supermarket;

/**
 *
 * @author rodrigo
 */
public class App {

    public static void main(String[] args) {
        Customer[] customers1 = new Customer[]{
            new Customer("luisa", new int[]{5, 3, 6}),
            new Customer("lucia", new int[]{1, 2, 4, 6}),
            new Customer("brenda", new int[]{6, 8}),
//            new Customer("susana", new int[]{8, 6, 5, 2, 9}),
//            new Customer("elizabet", new int[]{12, 1, 7}),
//            new Customer("shirley", new int[]{20, 8, 15})
        };

//        Customer[] customers2=new Customer[]{
//            new Customer("susana", new int[]{8, 6, 5, 2, 9}),
//            new Customer("elizabet", new int[]{12, 1, 7}),
//            new Customer("shirley", new int[]{20, 8, 15})
//        };
        
        Cashier cashier1 = new Cashier();
        cashier1.setNames("juana");
        cashier1.setCustomers(customers1);

//        Cashier cashier2 = new Cashier();
//        cashier2.setNames("patricia");
//        cashier2.setCustomers(customers2);
        
        cashier1.start();

        //cashier2.start();
    }
}
