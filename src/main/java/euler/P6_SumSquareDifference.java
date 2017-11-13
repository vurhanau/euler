package euler;

import java.util.stream.IntStream;

public class P6_SumSquareDifference {

    public static void main(String[] args) {
        int n = 100;
        int s0 = IntStream.range(1, n + 1).reduce((a, b) -> a + b * b).getAsInt();
        int s1 = (1 + n) * n / 2;
        s1 *= s1;
        System.out.println(s1 - s0);
    }
}
