import java.util.*;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Integer, Node> visited = new HashMap<>();
        return cloneGraphHelper(node, visited);
    }

    private Node cloneGraphHelper(Node node, Map<Integer, Node> visited) {
        ArrayList<Node> clonedNeighbors = new ArrayList<>();
        Node clonedNode = new Node(node.val);
        visited.put(clonedNode.val, clonedNode);
        for (Node oldNeighbor : node.neighbors) {
            if (!visited.containsKey(oldNeighbor.val)) {
                clonedNeighbors.add(cloneGraphHelper(oldNeighbor, visited));
            } else {
                clonedNeighbors.add(visited.get(oldNeighbor.val));
            }
        }
        clonedNode.neighbors = clonedNeighbors;
        return clonedNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}