package cache;

import java.util.List;

import static java.util.Arrays.asList;

public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(3);
        List<String> keys = asList("a", "b", "c", "d", "e");
        for (int i = 0; i < keys.size(); i++) {
            cache.put(keys.get(i), i);
            System.out.println(i + ": " + cache);
        }

        for (String key : keys) {
            Integer value = cache.remove(key);
            System.out.println(value + ": " + cache);
        }
    }
}
