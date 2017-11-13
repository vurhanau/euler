package euler;

import java.util.BitSet;

public class P10_SummationOfPrimes {

    public static void main(String[] args) {
        System.out.println(sum(2_000_000));
    }

    public static long sum(int n) {
        BitSet bits = new BitSet(n);
        long sum = 0;
        for (int i = 2; i < n; i++) {
            if (!bits.get(i)) {
                for (int j = 2; i * j < n; j++) {
                    bits.set(i * j);
                }
                sum += i;
            }
        }

        return sum;
    }

}
