package org.ulasalle.pcc.lcm;


import java.util.*;
import org.ulasalle.pcc.primes.Prime;

/**
 * 
 */
public class LCM {

     /**
     * 
     */
    private List<Integer> numbers;

    
    /**
     * Default constructor
     * @param number
     */
    public LCM(List<Integer> numbers) {
        this.numbers=numbers;
    }
   
    /**
     * @param number
     * @param prime
     * @return
     */
    private Factor factorize(int number, int prime) {
        int count = 0;
        while (number % prime == 0) {
            System.out.println("numero: "+number + " | primo: " + prime + " | nuevo numero: " + (number / prime));
            number = number / prime;
            count++;
        }
        Factor factor = new Factor();
        factor.setCount(count);
        factor.setNumber(number);

        return factor;
    }

    /**
     * @return
     */
    public int calculate() {
        Prime prime = new Prime();

        int i = 0;

        int gcd = 1;
        int full = 0;
        int temp=0;
        while (true) {

            if (prime.isPrime(i)) {
                int max = 0;
                for (int j = 0; j < numbers.size(); j++) {
                    System.out.println("de la lista: "+numbers.get(j));
                    if (numbers.get(j) != 0) {
                        Factor factor = factorize(numbers.get(j), i);
                        numbers.set(j, factor.getNumber());
                        if (factor.getCount() > max) {
                            max = factor.getCount();
                        }
                        if (numbers.get(j) == 1) {
                            System.out.println("is one: "+numbers.get(j));
                            numbers.set(j, 0);
                            full++;
                        }
                    }
                    System.out.println("full: "+full);
                }
                temp=(int) Math.pow(i, max);
                gcd = gcd * (temp==0 ?1:temp);
            }
            if (full == this.numbers.size()) {
                break;
            }
            i++;
        }
        return gcd;
    }

}