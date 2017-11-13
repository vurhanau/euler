package euler;

public class P14_LongestCollatzSequence {

    public static void main(String[] args) {
        int maxChain = 0;
        int num = 0;
        for (int i = 999_999; i > 1; i--) {
            int chain = chain(i);
            if (chain > maxChain) {
                num = i;
                maxChain = chain;
            }
        }
        System.out.println(num);
    }

    public static int chain(long n) {
        int chain = 1;
        while (n > 1) {
            n = n % 2 == 0 ? (n / 2) : (3 * n + 1);
            chain++;
        }
        return chain;
    }
}
