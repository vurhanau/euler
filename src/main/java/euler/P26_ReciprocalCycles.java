package euler;

import java.util.ArrayList;
import java.util.List;

public class P26_ReciprocalCycles {

    public static void main(String[] args) {
        int n = 1000;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int cycle = cycle(i);
            if (cycle > max) {
                System.out.println(i + ": " + cycle);
                max = cycle;
            }
        }
        System.out.println(max);
    }

    private static int cycle(int d) {
        int mod = 1;
        List<Integer> digits = new ArrayList<>();
        List<Integer> cycles = new ArrayList<>();
        int[] cycle = {-1, -1};
        int[] prevCycle = {-1, -1};
        while (mod != 0 && cycles.size() < 10) {
            mod *= 10;
            while (mod < d) {
                digits.add(0);
                mod *= 10;
            }
            digits.add(mod / d);
            mod %= d;

            int[] c = cycle0(cycle[1] + 1, digits);
            if (c[1] > 0) {
                prevCycle = cycle;
                cycle = c;
                if (prevCycle[0] > 0 && isConcat(prevCycle, cycle, digits)) {
                    return prevCycle[1];
                }
            }
        }

        return 0;
    }

    private static boolean isConcat(int[] cycle0, int[] cycle1, List<Integer> digits) {
        for (int i = 0; i < cycle0[1]; i++) {
            int a = digits.get(cycle1[0] - i);
            int b = digits.get(cycle0[0] - i);
            if (a != b) {
                return false;
            }
        }

        return true;
    }

    private static int[] cycle0(int minimalLength, List<Integer> digits) {
        int size = digits.size();
        for (int cycleLength = minimalLength; cycleLength <= size / 2; cycleLength++) {
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
                return new int[]{digits.size() - 1, cycleLength};
            }

        }
        return new int[]{-1, 0};
    }
}
