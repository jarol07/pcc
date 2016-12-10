package org.ulasalle.pcc.primesthread;

import java.util.ArrayList;
import java.util.List;

public class Prime extends Thread{

    private final List<Integer> primes = new ArrayList<>();
 
    
    public Prime() {
    }

    @Override
    public void run() {
        int init=10000;
        int limit=20000;
        while(init<limit){
             if (isPrime(init)) {
                System.out.println(init);
            }
             init++;
        }
    }

    public boolean isPrime(int number) {
        if (number > 1) {
            for (int i = 0; i < primes.size(); i++) {
                if ((number % primes.get(i) == 0)) {
                    return false;
                }
            }
            primes.add(number);
            return true;
        }
        return false;
    }

}
