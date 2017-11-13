package euler;

import java.math.BigInteger;

public class P20_FactorialDigitSum {

    public static void main(String[] args) {
        int n = 100;
        BigInteger value = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            value = value.multiply(BigInteger.valueOf(i));
        }
        long sum = 0;
        while (value.compareTo(BigInteger.ZERO) > 0) {
            sum += value.mod(BigInteger.TEN).intValue();
            value = value.divide(BigInteger.TEN);
        }
        System.out.println(sum);
    }
}
