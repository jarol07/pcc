package org.ulasalle.pcc.gcd;

import java.util.*;
import org.ulasalle.pcc.primes.Prime;

/**
 *
 */
public class GCD {

    /**
     *
     */
    private List<Integer> numbers;

    /**
     * Default constructor
     *
     * @param numbers
     */
    public GCD(List<Integer> numbers) {
        this.numbers = numbers;
    }

    /**
     * @param number
     * @param prime
     * @return
     */
    private Factor factorize(int number, int prime) {
        int count = 0;
        while (number % prime == 0) {
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
        int temp;
        while (true) {
            if (prime.isPrime(i)) {
                int min = Integer.MAX_VALUE;
                int access=0;
                for (int j = 0; j < numbers.size(); j++) {
                    if (numbers.get(j) != 0) {
                        Factor factor = factorize(numbers.get(j), i);
                        numbers.set(j, factor.getNumber());
                        if (factor.getCount() < min) {
                            min = factor.getCount();
                        }
                        if (numbers.get(j) == 1) {
                            numbers.set(j, 0);
                            full++;
                        }
                        access++;
                    }
                }
                temp=(access==numbers.size()?(int) Math.pow(i, min):0);
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
