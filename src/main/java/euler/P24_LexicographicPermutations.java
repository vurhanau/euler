package euler;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class P24_LexicographicPermutations {
    private static final int LIMIT = 1_000_000;

    public static void main(String[] args) {
        TreeSet<Character> chars = new TreeSet<>();
        for (Character c = '0'; c <= '9'; c++) {
            chars.add(c);
        }

        permutations(emptyList(), chars, new AtomicInteger(0));
    }

    public static void permutations(List<Character> current, TreeSet<Character> available, AtomicInteger counter) {
        if (available.isEmpty()) {
            if (counter.incrementAndGet() == LIMIT) {
                System.out.println(current.stream().map(Object::toString).collect(Collectors.joining()));
            }
            return;
        }

        for (Character next : available) {
            List<Character> newCurrent = new ArrayList<>(current);
            newCurrent.add(next);
            TreeSet<Character> newAvailable = new TreeSet<>(available);
            newAvailable.remove(next);
            permutations(newCurrent, newAvailable, counter);
        }
    }
}
