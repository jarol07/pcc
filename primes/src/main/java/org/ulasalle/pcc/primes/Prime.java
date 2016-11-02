package org.ulasalle.pcc.primes;

import java.util.ArrayList;
import java.util.List;

public class Prime {

    private final List<Integer> primes = new ArrayList<>();

    public Prime() {
    }

    public void show(int limit) {

        for (int i = 0; i < limit; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
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
