package euler;

import java.util.ArrayList;
import java.util.List;

public class P7_10001stPrime {

    public static void main(String[] args) {
        System.out.println(prime(10001));
    }

    private static int prime(int n) {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int value = 3; primes.size() != n; value += 2) {
            int v = value;
            boolean isPrime = primes.stream().allMatch(p -> v % p != 0);
            if (isPrime) {
                primes.add(value);
            }
        }

        return primes.get(primes.size() - 1);
    }
}
