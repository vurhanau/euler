package euler;

import java.util.Arrays;
import java.util.Scanner;

public class P67_MaximumPathSumII {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(P67_MaximumPathSumII.class.getResourceAsStream("/67.txt"));
        int[][] d = new int[100][];
        for (int i = 0; i < 100; i++) {
            d[i] = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }

        System.out.println(P18_MaximumPathSumI.walk(d));
    }

}
