import java.util.*;

class MyHashSet {
    List<List<Integer>> list;
    int buckets = 1000;

    public MyHashSet() {
        list = new ArrayList<>(buckets);
        for (int i = 0; i < buckets; i++) {
            list.add(new ArrayList<>());
        }
    }

    public void add(int key) {
        if (this.contains(key))
            return;
        int hash = key % buckets;
        List<Integer> l = list.get(hash);
        l.add(key);
    }

    public void remove(int key) {
        if (!this.contains(key))
            return;
        int hash = key % buckets;
        List<Integer> l = list.get(hash);
        l.remove(l.indexOf(key));
    }

    public boolean contains(int key) {
        int hash = key % buckets;
        List<Integer> l = list.get(hash);
        for (int num : l)
            if (num == key)
                return true;
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */