package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class LRUCache extends LinkedHashMap<Integer, Integer> {

    private final int INIT_CAPACITY;
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        INIT_CAPACITY = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return size() > INIT_CAPACITY;
    }

    public int get(int key) {
        Integer value = super.get(key);
        if (value == null) {
            return -1;
        }
        return value;
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);
        lruCache.get(2);
        lruCache.put(2,6);
        printMap(lruCache);
        lruCache.get(1);
        lruCache.put(1,5);
        printMap(lruCache);
        lruCache.put(1,2);
        printMap(lruCache);
        lruCache.get(1);
        lruCache.get(2);
        printMap(lruCache);
        assert(lruCache.size() == 2);
        assert(lruCache.get(1) == 2);
        assert(lruCache.get(2) == 6);
    }

    private static void printMap(Map<Integer, Integer> map) {
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        System.out.print("[ ");
        for (Map.Entry<Integer, Integer> entry: entries) {
            System.out.printf("{%d:%d} ", entry.getKey(), entry.getValue());
        }
        System.out.println("]");
        System.out.println();
    }
}