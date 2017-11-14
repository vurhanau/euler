package euler;

import java.util.*;

public class P23_NonAbundantSums {

    public static void main(String[] args) {
        int limit = 20161;
        for (int i = 1; i <= limit; i++) {
            int sum = sum(i);
            if (sum > i) {
                abundant.add(i);
                debug.put(i, sum);
            }
        }

        BitSet bits = new BitSet(2 * limit + 1);
        for (int i = 0; i < abundant.size(); i++) {
            for (int j = i; j < abundant.size(); j++) {
                bits.set(abundant.get(i) + abundant.get(j));
            }
        }

        long sum = 0;
        int last = 0;
        for (int i = 0; i <= 2 * limit; i++) {
            if (!bits.get(i)) {
                sum += i;
                last = i;
            }
        }

        System.out.println(last);
        System.out.println(sum);
    }

    private static int sum(int n) {
        int sum = 1;
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                sum += i;
                sum += n / i;
            }
        }

        return sum;
    }

    private static final Map<Integer, Integer> debug = new TreeMap<>();
    private static final List<Integer> abundant = new ArrayList<>();
}
