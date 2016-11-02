/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ulasalle.pcc.supermarket;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodrigo
 */
public class Cashier extends Thread{
    private String names;
    private Customer[] customers;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }
 
    public void run(){
        
        for(int i=0;i<customers.length;i++){
            for(int j=0;j<customers[i].productos.length;j++){
                try {
                    Thread.sleep(customers[i].productos[j]*1000);
                    System.out.println("cajera:"+names);
                    System.out.println("cliente:"+customers[i].getName());
                    System.out.println("producto:"+customers[i].productos[j]);
                    System.out.println("_________________________________");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println(getNames()+" fin cliente "+customers[i].getName());
        }
        System.out.println(getNames()+" fin atencion ");
      
    }
}
