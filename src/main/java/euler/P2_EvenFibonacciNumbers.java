package euler;

public class P2_EvenFibonacciNumbers {

    public static void main(String[] args) {
        System.out.println(fib(4_000_000));
    }

    private static int fib(int limit) {
        int a0 = 1;
        int a1 = 1;
        int sum = 0;
        while (a1 <= limit) {
            int tmp = a1;
            a1 = a0 + a1;
            a0 = tmp;
            if (a1 % 2 == 0) {
                sum += a1;
            }
        }

        return sum;
    }
}
