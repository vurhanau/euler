package euler;

import java.util.Arrays;

public class P18_MaximumPathSumI {

    public static void main(String[] args) {
        int[][] d = new int[data.length][];
        for (int i = 0; i < data.length; i++) {
            d[i] = new int[data[i].length];
            System.arraycopy(data[i], 0, d[i], 0, data[i].length);
        }

        System.out.println(walk(d));
    }

    public static int walk(int[][] d) {
        for (int i = 1; i < d.length; i++) {
            d[i][0] += d[i - 1][0];
            d[i][d[i].length - 1] += d[i - 1][d[i - 1].length - 1];
            for (int j = 0; j < d[i - 1].length - 1; j++) {
                d[i][j + 1] += Math.max(d[i - 1][j], d[i - 1][j + 1]);
            }
        }

        return Arrays.stream(d[d.length - 1]).max().getAsInt();
    }

    private static int[][] data = {
            {75},
            {95, 64},
            {17, 47, 82},
            {18, 35, 87, 10},
            {20, 4, 82, 47, 5},
            {19, 1, 23, 75, 3, 34},
            {88, 2, 77, 73, 7, 63, 67},
            {99, 65, 4, 28, 6, 16, 70, 92},
            {41, 41, 26, 56, 83, 40, 80, 70, 33},
            {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
            {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
            {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
            {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
            {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
            {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}
    };

    private static int[][] data0 = {
            {3},
            {7, 4},
            {2, 4, 6},
            {8, 5, 9, 3}
    };
}
