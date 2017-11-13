package euler;

public class P9_SpecialPythagoreanTriplet {

    public static void main(String[] args) {
        for (int a = 1; a < 1000; a++) {
            for (int b = a + 1; b < 1000; b++) {
                if (a + b + Math.sqrt(a * a + b * b) == 1000) {
                    System.out.println(a * b * (1000 - a - b));
                    return;
                }
            }
        }
    }
}
