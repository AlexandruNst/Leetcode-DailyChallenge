import java.util.HashMap;
import java.util.Map;

class Trie {
    Node root;

    private class Node {
        char character;
        Map<Character, Node> map;
        boolean isEndOfWord;

        public Node(char character) {
            this.character = character;
            this.isEndOfWord = false;
            this.map = new HashMap<>();
        }
    }

    public Trie() {
        this.root = new Node('/');
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.map.containsKey(c)) {
                node.map.put(c, new Node(c));
            }
            node = node.map.get(c);
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.map.containsKey(c)) {
                return false;
            } else {
                node = node.map.get(c);
            }
        }

        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!node.map.containsKey(c)) {
                return false;
            } else {
                node = node.map.get(c);
            }
        }

        return true;
    }
}