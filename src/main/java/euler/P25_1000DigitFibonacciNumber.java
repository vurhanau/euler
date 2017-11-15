package euler;

import java.math.BigInteger;

public class P25_1000DigitFibonacciNumber {

    public static void main(String[] args) {
        int limit = 1000;
        BigInteger f1 = BigInteger.ONE;
        BigInteger f2 = BigInteger.ONE;
        int i;
        for (i = 3; len(f2) < limit; i++) {
            BigInteger tmp = f2;
            f2 = f2.add(f1);
            f1 = tmp;
        }

        System.out.println(i - 1);
    }

    public static int len(BigInteger num) {
        int len = 0;
        while (num.compareTo(BigInteger.ZERO) > 0) {
            num = num.divide(BigInteger.TEN);
            len++;
        }

        return len;
    }
}
