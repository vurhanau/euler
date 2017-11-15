package cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private final int size;
    private final Map<K, Node<K, V>> cache;
    private final Queue<K, V> queue;

    public LRUCache() {
        this(1024);
    }

    public LRUCache(int size) {
        this.size = size;
        this.cache = new HashMap<>(size);
        this.queue = new Queue<>();
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }

        Node<K, V> node = cache.get(key);
        unlink(node);
        queue.push(node);
        return node.value;
    }

    public V put(K key, V value) {
        if (cache.containsKey(key)) {
            Node<K, V> node = cache.get(key);
            V obsolete = node.value;
            node.value = value;
            return obsolete;
        }

        if (cache.size() == size) {
            Node<K, V> node = queue.poll();
            cache.remove(node.key);
        }

        Node<K, V> node = new Node<>(key, value);
        unlink(node);
        queue.push(node);
        cache.put(key, node);
        return null;
    }

    public V remove(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }

        Node<K, V> node = cache.get(key);
        unlink(node);
        cache.remove(key);
        return node.value;
    }

    private void unlink(Node<K, V> node) {
        if (node.left != null) {
            node.left.right = node.right;
        }
    }

    @Override
    public String toString() {
        return cache.toString();
    }

    private static class Queue<K, V> {
        private Node<K, V> head;
        private Node<K, V> tail;

        public Node<K, V> poll() {
            if (head == null) {
                return null;
            }

            Node<K, V> ret = head;
            if (head.left != null) {
                head = head.left;
                head.right = null;
            }

            if (head == tail) {
                this.head = null;
                this.tail = null;
            }

            return ret;
        }

        public void push(Node<K, V> node) {
            if (tail == null) {
                head = node;
                tail = node;
                return;
            }

            node.left = null;
            node.right = tail;
            tail.left = node;
            tail = node;
        }
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + ": " + value + "}";
        }
    }
}
