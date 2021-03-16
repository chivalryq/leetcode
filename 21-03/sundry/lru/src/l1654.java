import java.util.LinkedHashMap;
import java.util.Map;

public class l1654 {
}

class LRUCache extends LinkedHashMap<Integer, Integer> {
    private final int cap;

    public LRUCache(int capacity) {
        super(capacity, (float) 0.75,true);
        this.cap = capacity;
    }

    public int get(int key) {
        int a= (int) (1e9+7);
        return super.getOrDefault(key,-1);

    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > cap;
    }
}

