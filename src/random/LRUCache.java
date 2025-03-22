package src.random;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // true = access order (LRU)
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity; // Remove the least recently used entry
    }

    public static void main(String[] args) {
        LRUCacheMain<Integer, String> cache = new LRUCacheMain<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        System.out.println(cache); // {1=A, 2=B, 3=C}

        cache.get(1); // Access key 1, making it recently used
        cache.put(4, "D"); // Removes least recently used key (2)

        System.out.println(cache); // {3=C, 1=A, 4=D}
    }
}
