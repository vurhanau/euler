package euler;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P4_LargestPalindromeProduct {

    public static void main0(String[] args) {
        Map<Integer, List<Palindrome>> ps = new HashMap<>();
        generate(6, ps);
        ps.forEach((key, value) -> System.out.println(key + " (" + value.size() + ") " + ": " + value));
    }

    public static void main(String[] args) {
        int maxPalindrome = 0;
        for (int i = 100; i < 1000; i++) {
            for (int j = i; j < 1000; j++) {
                int prod = i * j;
                if (isPalindrome(prod) && prod > maxPalindrome) {
                    maxPalindrome = prod;
                }
            }
        }
        System.out.println(maxPalindrome);
    }

    public static boolean isPalindrome(int num) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            int digit = num % 10;
            digits.add(digit);
            num /= 10;
        }

        int len = digits.size();
        for (int i = 0; i < len / 2; i++) {
            if (!digits.get(i).equals(digits.get(len - i - 1))) {
                return false;
            }
        }

        return true;
    }

    public static void generate(int len, Map<Integer, List<Palindrome>> palindromes) {
        List<Palindrome> one = IntStream.range(0, 10)
                .mapToObj(Palindrome::new)
                .collect(Collectors.toList());
        palindromes.put(1, one);

        List<Palindrome> two = IntStream.range(0, 10)
                .mapToObj(i -> new Palindrome(Arrays.asList(i, i)))
                .collect(Collectors.toList());
        palindromes.put(2, two);

        for (int i = 3; i <= len; i++) {
            List<Palindrome> ps = palindromes.get(i - 2)
                    .stream()
                    .flatMap(p -> IntStream.range(0, 10).mapToObj(p::between))
                    .collect(Collectors.toList());
            palindromes.put(i, ps);
        }
    }

    private static class Palindrome {
        private List<Integer> digits;

        public Palindrome(int digit) {
            this.digits = Collections.singletonList(digit);
        }

        public Palindrome(List<Integer> digits) {
            this.digits = digits;
        }

        public Palindrome between(int digit) {
            List<Integer> newDigits = new ArrayList<>();
            newDigits.add(digit);
            newDigits.addAll(digits);
            newDigits.add(digit);
            return new Palindrome(newDigits);
        }

        @Override
        public String toString() {
            return digits.stream().map(String::valueOf).collect(Collectors.joining());
        }
    }
}
