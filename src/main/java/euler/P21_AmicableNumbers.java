package euler;

public class P21_AmicableNumbers {
    public static void main(String[] args) {
//        System.out.println(sum(220));
//        System.out.println(sum(284));
        int[] sums = new int[10_000];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sum(i);
        }

        int count = 0;
        for (int a = 1; a < sums.length; a++) {
            int b = sums[a];
            if (b >= sums.length) {
                continue;
            }
            int c = sums[b];
            if (a == c && a != b && a < b) {
                count += a + b;
                System.out.println(a + ", " + b);
            }
        }

        System.out.println(count);
    }

    public static int sum(int n) {
        int sqrt = (int) Math.sqrt(n);
        int sum = 1;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i;
                sum += n / i;
            }
        }

        if (sqrt * sqrt == n && n > 1) {
            sum += sqrt;
        }

        return sum;
    }
}
