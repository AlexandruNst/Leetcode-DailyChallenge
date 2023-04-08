class Solution {
    public int numEnclaves(int[][] grid) {
        fillMargins(grid);
        int answer = countOnes(grid);
        return answer;
    }

    private void fillMargins(int[][] grid) {
        int[] rows = { 0, grid.length - 1 };
        int[] cols = { 0, grid[0].length - 1 };

        for (int r : rows) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[r][j] == 1)
                    floodLand(grid, r, j);
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int c : cols) {
                if (grid[i][c] == 1)
                    floodLand(grid, i, c);
            }
        }
    }

    private void floodLand(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        if (grid[i][j] == 0)
            return;

        grid[i][j] = 0;
        floodLand(grid, i + 1, j);
        floodLand(grid, i - 1, j);
        floodLand(grid, i, j + 1);
        floodLand(grid, i, j - 1);
    }

    private int countOnes(int[][] grid) {
        int ones = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    ones++;
            }
        }
        return ones;
    }
}