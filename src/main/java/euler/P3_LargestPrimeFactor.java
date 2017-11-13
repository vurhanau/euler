package euler;

public class P3_LargestPrimeFactor {

    public static void main(String[] args) {
        System.out.println(factors(600851475143L));
    }


    private static long factors(long n) {
        long result = 0;
        for (int i = 2; i < (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                n /= i;
                result = n;
                i = 2;
            }
        }

        return result;
    }
}
