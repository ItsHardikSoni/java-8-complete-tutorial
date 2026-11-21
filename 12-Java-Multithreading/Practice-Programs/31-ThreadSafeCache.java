import java.util.concurrent.ConcurrentHashMap;

class ThreadSafeCache {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> cache = new ConcurrentHashMap<>();
        cache.put("A", 1);
        cache.put("B", 2);
        cache.compute("A", (key, value) -> value == null ? 1 : value + 10);
        System.out.println(cache);
    }
}
