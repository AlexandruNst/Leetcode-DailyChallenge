import java.util.*;

class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        left = new Node(-1, -1);
        right = new Node(-1, -1);
        left.next = right;
        right.prev = left;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            updateNode(node);
            return node.val;
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            map.put(key, node);
            updateNode(node);
        } else {
            map.put(key, new Node(key, value));
            insert(map.get(key));
            if (map.keySet().size() > capacity) {
                Node lru = left.next;
                remove(lru);
                map.remove(lru.key);
            }
        }
    }

    private void updateNode(Node node) {
        remove(node);
        insert(node);
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = right.prev;
        prev.next = node;
        node.next = right;
        right.prev = node;
        node.prev = prev;
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */