package euler;

public class P12_HighlyDivisibleTriangularNumber {

    public static void main(String[] args) {
        int limit = 5;

        int sum = 0;
        for (int i = 1; factors(sum) <= 500; i++) {
            sum += i;
        }
        System.out.println(sum);
    }


    public static int factors(int num) {
        if (num == 0) {
            return 0;
        }

        int count = 2;
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i < sqrt; i++) {
            if (num % i == 0) {
                count += 2;
            }
        }

        if (sqrt * sqrt == num) {
            count++;
        }

        return count;
    }

}
