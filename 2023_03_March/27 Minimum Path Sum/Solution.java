class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int path = minPath(0, 0, grid, dp);
        return path;
    }

    private int minPath(int row, int col, int[][] grid, int[][] dp) {
        // at the last item
        if (row == grid.length - 1 && col == grid[0].length - 1)
            return grid[row][col];

        // if down or right exist, calculate them, else -1
        int nextPathRight;
        if (col < grid[0].length - 1) {
            if (dp[row][col + 1] != 0)
                nextPathRight = dp[row][col + 1];
            else {
                nextPathRight = minPath(row, col + 1, grid, dp);
                dp[row][col + 1] = nextPathRight;
            }
        } else {
            nextPathRight = -1;
        }

        int nextPathDown;
        if (row < grid.length - 1) {
            if (dp[row + 1][col] != 0)
                nextPathDown = dp[row + 1][col];
            else {
                nextPathDown = minPath(row + 1, col, grid, dp);
                dp[row + 1][col] = nextPathDown;
            }
        } else {
            nextPathDown = -1;
        }

        if (nextPathRight == -1)
            dp[row][col] = grid[row][col] + nextPathDown; // if no right, it's grid + down
        else if (nextPathDown == -1)
            dp[row][col] = grid[row][col] + nextPathRight; // if no down, it's grid + rigght
        else
            dp[row][col] = Math.min(grid[row][col] + nextPathRight, grid[row][col] + nextPathDown); // min between the
                                                                                                    // two

        return dp[row][col];
    }
}