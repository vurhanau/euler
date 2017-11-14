package euler;

public class P24_LexicographicPermutations {

    public static void main(String[] args) {
        int input = 0b1111111111;
        System.out.println("Original");
        System.out.println(isAvailable(input, 1));
        System.out.println(isAvailable(input, 5));

        input = flip(input, 1);
        System.out.println("Off: 1");
        System.out.println(isAvailable(input, 1));
        System.out.println(isAvailable(input, 5));

        input = flip(input, 5);
        System.out.println("Off: 5");
        System.out.println(isAvailable(input, 1));
        System.out.println(isAvailable(input, 5));
    }

    static boolean isAvailable(int input, int digit) {
        int mask = 1 << digit;
        return (input & mask) != 0;
    }

    static int flip(int input, int digit) {
        int mask = 1 << digit;
        return (input ^ mask);
    }
}
