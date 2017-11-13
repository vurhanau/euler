package euler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class P5_SmallestMultiple {

    public static void main(String[] args) {
        System.out.println(best());
    }

    static int best() {
        int result = 2;
        int next = 3;

        while (next <= 20) {
            if (result % next != 0) {
                for (int i = 2; i <= next; i++) {
                    if ((result * i) % next == 0) {
                        result *= i;
                        break;
                    }
                }
            }
            next++;
        }
        return result;
    }

    public static void main0(String[] args) {
        System.out.println(IntStream.range(1, 21).reduce(P5_SmallestMultiple::leastCommonMultiple));
    }

    static int leastCommonMultiple(int a, int b) {
        List<Integer> af = divisors(a);
        int an = af.size();

        List<Integer> bf = divisors(b);
        int bn = bf.size();

        int prod = 1;
        int ai = 1;
        int bi = 1;
        while (ai < an && bi < bn) {
            int na = af.get(ai);
            int nb = bf.get(bi);

            if (na == nb) {
                ai++;
                bi++;
                prod *= na;
            } else if (na > nb) {
                bi++;
                prod *= nb;
            } else if (na < nb) {
                ai++;
                prod *= na;
            }
        }

        for (int i = ai; i < an; i++) {
            prod *= af.get(i);
        }

        for (int i = bi; i < bn; i++) {
            prod *= bf.get(i);
        }

        return prod;
    }

    static List<Integer> divisors(int num) {
        List<Integer> ints = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                ints.add(i);
                num = num / i;
                i = 1;
            }
        }

        return ints;
    }
}
