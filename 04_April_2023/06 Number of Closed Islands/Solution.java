class Solution {
    public int closedIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        fillMargins(grid, visited);
        int islands = fillCenter(grid, visited);
        return islands;
    }

    private void fillMargins(int[][] grid, int[][] visited) {
        int[] rows = { 0, grid.length - 1 };
        int[] cols = { 0, grid[0].length - 1 };
        for (int r : rows) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[r][j] == 0)
                    floodLand(grid, r, j, visited);
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int c : cols) {
                if (grid[i][c] == 0)
                    floodLand(grid, i, c, visited);
            }
        }
    }

    private int fillCenter(int[][] grid, int[][] visited) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    floodLand(grid, i, j, visited);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void floodLand(int[][] grid, int i, int j, int[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        if (visited[i][j] == 1 || grid[i][j] == 1)
            return;

        visited[i][j] = 1;
        grid[i][j] = 1;
        floodLand(grid, i - 1, j, visited);
        floodLand(grid, i + 1, j, visited);
        floodLand(grid, i, j - 1, visited);
        floodLand(grid, i, j + 1, visited);
    }

    // private boolean floodLand(int[][] grid, int i, int j, int[][] visited){
    // if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return false;
    // if(visited[i][j] == 1 || grid[i][j] == 1) return true;

    // visited[i][j] = 1;
    // grid[i][j] = 1;
    // return floodLand(grid, i - 1, j, visited)
    // & floodLand(grid, i + 1, j, visited)
    // & floodLand(grid, i, j - 1, visited)
    // & floodLand(grid, i, j + 1, visited);
    // }

}