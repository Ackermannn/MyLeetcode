import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * question address:
 * https://leetcode-cn.com/problems/lru-cache/
 */
class Pair {
    Integer key;
    Integer value;

    Pair(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }
}

// 用deque + hashmap
public class LRUCache {
    private final int capacity;
    private final ArrayDeque<Pair> deque = new ArrayDeque<>();
    private final HashMap<Integer, Pair> hashMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            deque.remove(hashMap.get(key));
            deque.offer(hashMap.get(key));
            return hashMap.get(key).value;
        } else
            return -1;
    }

    public void put(int key, int value) {
        Pair newPair = new Pair(key, value);
        if (hashMap.containsKey(key)) { // 先检查有没有
            deque.remove(hashMap.get(key));
            hashMap.remove(key);
        } else {
            if (deque.size() >= capacity) { // 如果没有，考虑是不是满了
                Pair abandoned = deque.poll();
                assert abandoned != null;
                hashMap.remove(abandoned.key);
            }
        }
        deque.offer(newPair);
        hashMap.put(key, newPair);
    }
}

class Main {
    public static void main(String[] args) {
//        ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//        [[2],[1, 1],[2, 2],[1],[3, 3],[2],[4, 4],[1],[3],[4]]
//        ["LRUCache", "put", "get"]
//        [[1],[2, 1],[1]]
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }
}

