class Solution {
    public int makeConnected(int n, int[][] connections) {
        // initial fail condition
        int cables = connections.length;
        if (cables < n - 1)
            return -1;

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int[] rank = new int[n];

        int clusters = n;
        for (int[] connection : connections) {
            clusters -= union(connection[0], connection[1], parent, rank);
        }

        return clusters - 1;
    }

    private int find(int i, int[] parent) {
        int node = i;
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }

    private int union(int x, int y, int[] parent, int[] rank) {
        int xParent = find(x, parent);
        int yParent = find(y, parent);

        if (xParent == yParent)
            return 0;
        else {
            if (rank[xParent] > rank[yParent]) {
                parent[yParent] = xParent;
                // rank[xParent] += rank[yParent];
            } else if (rank[xParent] < rank[yParent]) {
                parent[xParent] = yParent;
                // rank[yParent] += rank[xParent];
            } else {
                parent[yParent] = xParent;
                rank[xParent]++;
            }
            return 1;
        }
    }
}