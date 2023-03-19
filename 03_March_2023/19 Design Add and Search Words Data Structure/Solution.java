import java.util.HashMap;
import java.util.Map;

class WordDictionary {

    class Node {
        Map<Character, Node> map;
        boolean isEnd;

        public Node() {
            map = new HashMap<>();
            isEnd = false;
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.map.containsKey(c))
                node.map.put(c, new Node());
            node = node.map.get(c);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return searchRec(word, 0, root);
    }

    private boolean searchRec(String word, int index, Node node) {
        if (index == word.length())
            return node.isEnd;
        char c = word.charAt(index);
        if (c != '.') {
            if (node.map.containsKey(c))
                return searchRec(word, index + 1, node.map.get(c));
            else
                return false;
        } else {
            for (Node child : node.map.values()) {
                if (searchRec(word, index + 1, child))
                    return true;
            }
            return false;
        }
    }
}