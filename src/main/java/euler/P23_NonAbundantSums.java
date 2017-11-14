package euler;

import java.util.Set;
import java.util.TreeSet;

public class P23_NonAbundantSums {

    public static void main(String[] args) {
        int size = 28123;

        for (int i = 1; i <= size; i++) {
            int sum = sum(i);
            if (sum > i) {
                abundant.add(i);
            }
        }

        long sum = 0;
        for (int i = 1; i <= size; i++) {
            boolean found = false;
            for (Integer a : abundant) {
                if (a > i) {
                    break;
                }
                int b = i - a;
                if (abundant.contains(b)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                sum += i;
            }
        }

        System.out.println(sum);
    }


    private static int sum(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) {
                    sum += n / i;
                }
            }
        }

        return sum;
    }

    private static final Set<Integer> abundant = new TreeSet<>();
}
