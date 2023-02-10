import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Land> q = new LinkedList<>();
        int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    Land land = new Land(i, j);
                    q.add(land);
                    visited[i][j] = true;
                } else {
                    visited[i][j] = false;
                }
            }
        }

        // BFS
        int distance = -1;
        int qSize = 0;
        while (!q.isEmpty()) {
            if (qSize == 0) {
                distance++;
                qSize = q.size();
            }

            Land land = q.remove();
            for (int[] direction : directions) {
                int x = land.getX() + direction[0];
                int y = land.getY() + direction[1];

                if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new Land(x, y));
                }
            }

            qSize--;
        }

        return distance == 0 ? -1 : distance;
    }

    private class Land {
        int x;
        int y;

        public Land(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }
}