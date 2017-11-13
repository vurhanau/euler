package euler;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P22_NamesScores {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(P22_NamesScores.class.getResourceAsStream("/22.txt"));
        List<String> list = Arrays.stream(scanner.nextLine().split(","))
                .map(s -> s.substring(1, s.length() - 1))
                .sorted()
                .collect(Collectors.toList());
        long sum = IntStream.range(1, list.size() + 1)
                .mapToLong(i -> i * list.get(i - 1).chars().map(c -> c - 'A' + 1).sum())
                .sum();
        System.out.println(sum);
    }
}
