package euler;

import java.util.ArrayList;
import java.util.List;

public class P26_ReciprocalCycles {

    public static void main(String[] args) {
        nice();
//        int n = 1000;
//        int max = Integer.MIN_VALUE;
//        int nmax = -1;
//        for (int i = 1; i < n; i++) {
//            int cycle = cycle(i);
//            if (cycle > max) {
//                max = cycle;
//                nmax = i;
//            }
//        }
//        System.out.println(nmax);
    }

    private static void nice() {
        int n, i, len, maxlen = 0, maxn = 0;
        maxlen = 0;
        for (n = 2; n <= 1000; n++) {
            int rest = 1;
            int r0;
            for (i = 0; i < n; i++)
                rest = (rest * 10) % n;
            r0 = rest;
            len = 0;
            do {
                rest = (rest * 10) % n;
                len++;
            } while (rest != r0);
            if (len > maxlen) {
                maxn = n;
                maxlen = len;
            }
        }
        System.out.println(maxn + ": " + maxlen);
    }


    private static int cycle(int d) {
        int mod = 1;
        List<Integer> digits = new ArrayList<>();
        List<Integer> cycles = new ArrayList<>();
        while (mod != 0 && cycles.size() < 10000) {
            mod *= 10;
            digits.add(mod / d);
            mod %= d;

            int cycle = cycle0(digits);
            if (cycle > 0) {
                cycles.add(cycle);
            }
        }

        return cycles.isEmpty() ? 0 : cycles.stream().mapToInt(i -> i).max().getAsInt();
    }

    private static int cycle0(List<Integer> digits) {
        int size = digits.size();
        for (int cycleLength = 0; cycleLength <= size / 2; cycleLength++) {
            boolean found = false;
            for (int j = 0; j < cycleLength; j++) {
                int a = digits.get(size - j - 1);
                int b = digits.get(size - cycleLength - j - 1);
                found = a == b;
                if (!found) {
                    break;
                }
            }

            if (found) {
                return cycleLength;
            }

        }
        return 0;
    }
}
