import java.util.*;

class Solution {
    public long countPairs(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 1; // start at 1 to avoid * 0
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1], parent, rank);
        }

        // Select individual parents / cluster representatives
        Set<Integer> parents = new HashSet<>();
        for (int i = 0; i < n; i++) {
            parents.add(findParent(i, parent));
        }

        // By getting the rank of parents, we get the group/cluster sizes
        List<Integer> groupSizes = new ArrayList<>();
        for (int p : parents) {
            groupSizes.add(rank[p]);
        }

        // We have a, b, c, d cluster sizes
        // Amount of pairs = (a * (b + c + d)) + (b * (c + d)) + (c * d)
        long sum = 0;
        for (int r : groupSizes) {
            sum += r;
        }
        long pairs = 0;
        for (int r : groupSizes) {
            sum -= r;
            pairs += r * sum;
        }

        return pairs;
    }

    private int findParent(int i, int[] parent) {
        int node = i;
        while (node != parent[node])
            node = parent[node];
        return node;
    }

    private void union(int x, int y, int[] parent, int[] rank) {
        int xParent = findParent(x, parent);
        int yParent = findParent(y, parent);

        // For Union-Find we use the method where rank += other rank
        // Rank will denote the group size
        if (xParent != yParent) {
            if (rank[xParent] > rank[yParent]) {
                parent[yParent] = xParent;
                rank[xParent] += rank[yParent];
            } else {
                parent[xParent] = yParent;
                rank[yParent] += rank[xParent];
            }
        }
    }
}