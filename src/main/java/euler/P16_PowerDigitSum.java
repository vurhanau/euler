package euler;

import java.math.BigInteger;

public class P16_PowerDigitSum {

    public static void main(String[] args) {
        BigInteger num = BigInteger.valueOf(2);
        BigInteger pow = num.pow(1000);
        BigInteger sum = BigInteger.ZERO;
        while (pow.compareTo(BigInteger.ZERO) > 0) {
            sum = sum.add(pow.mod(BigInteger.TEN));
            pow = pow.divide(BigInteger.TEN);
        }

        System.out.println(sum);
    }
}
