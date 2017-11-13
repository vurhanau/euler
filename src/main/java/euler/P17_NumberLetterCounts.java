package euler;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P17_NumberLetterCounts {
    public static void main(String[] args) {
        release();
    }

    public static void debug() {
        IntStream.range(1, 1001).forEach(i -> System.out.println(i + ": " + string(i)));
    }

    public static void release() {
        System.out.println(IntStream.range(1, 1001).map(P17_NumberLetterCounts::len).reduce((a, b) -> a + b));
    }

    public static int len(int num) {
        Map<Integer, Integer> kv = lengths();
        if (num <= 20 || num == 1000) {
            return kv.get(num);
        }

        int a0 = num % 10;
        int a1 = num % 100 - a0;
        int a2 = num % 1000 - a1 - a0;

        int len = 0;
        if (a2 > 0) {
            len += kv.get(a2 / 100) + kv.get(100);
            len += a0 > 0 || a1 > 0 ? "and".length() : 0;
        }

        if (a1 + a0 >= 10 && a1 + a0 <= 20) {
            return len + kv.get(a1 + a0);
        } else if (a1 > 0) {
            len += kv.get(a1);
        }

        if (a0 > 0) {
            len += kv.get(a0);
        }

        return len;
    }

    public static String string(int num) {
        Map<Integer, String> kv = numerics();
        if (num <= 20 || num == 1000) {
            return kv.get(num);
        }

        int a0 = num % 10;
        int a1 = num % 100 - a0;
        int a2 = num % 1000 - a1 - a0;

        String len = "";
        if (a2 > 0) {
            len += " " + kv.get(a2 / 100) + " " + kv.get(100) + (a0 > 0 || a1 > 0 ? " and" : "");
        }

        if (a1 + a0 >= 10 && a1 + a0 <= 20) {
            return len + " " + kv.get(a1 + a0);
        } else if (a1 > 0) {
            len += " " + kv.get(a1);
        }

        if (a0 > 0) {
            len += " " + kv.get(a0);
        }

        return len;
    }

    private static Map<Integer, Integer> lengths() {
        return numerics().entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().length()));
    }

    private static Map<Integer, String> numerics() {
        Map<Integer, String> kv = new HashMap<>();
        kv.put(1, "one");
        kv.put(2, "two");
        kv.put(3, "three");
        kv.put(4, "four");
        kv.put(5, "five");
        kv.put(6, "six");
        kv.put(7, "seven");
        kv.put(8, "eight");
        kv.put(9, "nine");
        kv.put(10, "ten");
        kv.put(11, "eleven");
        kv.put(12, "twelve");
        kv.put(13, "thirteen");
        kv.put(14, "fourteen");
        kv.put(15, "fifteen");
        kv.put(16, "sixteen");
        kv.put(17, "seventeen");
        kv.put(18, "eighteen");
        kv.put(19, "nineteen");
        kv.put(20, "twenty");
        kv.put(30, "thirty");
        kv.put(40, "forty");
        kv.put(50, "fifty");
        kv.put(60, "sixty");
        kv.put(70, "seventy");
        kv.put(80, "eighty");
        kv.put(90, "ninety");
        kv.put(100, "hundred");
        kv.put(1000, "onethousand");
        return kv;
    }

}
