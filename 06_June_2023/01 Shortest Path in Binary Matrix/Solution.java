import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0)
            return -1;

        Queue<Node> q = new LinkedList<>();
        Node start = new Node(0, 0);
        Node end = new Node(n - 1, n - 1);

        q.add(start);
        int length = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Node curr = q.poll();
                if (curr.getX() == end.getX() && curr.getY() == end.getY())
                    return length;

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int newX = curr.getX() + i;
                        int newY = curr.getY() + j;
                        if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                            q.add(new Node(newX, newY));
                            grid[newX][newY] = 1;
                        }
                    }
                }
            }

            length++;
        }
        return -1;
    }

    class Node {
        int x;
        int y;

        Node(int x, int y) {
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