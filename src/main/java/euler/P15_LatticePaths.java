package euler;

public class P15_LatticePaths {

    public static void main(String[] args) {
        d[0][0] = 0;
        for (int i = 1; i < d.length; i++) {
            d[0][i] = 1;
            d[i][0] = 1;
        }

        for (int i = 1; i < d.length; i++) {
            for (int j = 1; j < d.length; j++) {
                d[i][j] = d[i][j - 1] + d[i - 1][j];
            }
        }
        System.out.println(d[20][20]);
    }

    private static long[][] d = new long[21][21];
}
