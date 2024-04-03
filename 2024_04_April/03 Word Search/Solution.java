class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                res = res || checkBoard(board, visited, word, i, j, 0);
                if (res)
                    return true;
            }
        }
        return false;
    }

    private boolean checkBoard(char[][] board, boolean[][] visited, String word, int i, int j, int pos) {
        if (pos >= word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if (board[i][j] != word.charAt(pos))
            return false;
        if (visited[i][j] == true)
            return false;
        visited[i][j] = true;
        boolean res = checkBoard(board, visited, word, i + 1, j, pos + 1) ||
                checkBoard(board, visited, word, i - 1, j, pos + 1) ||
                checkBoard(board, visited, word, i, j + 1, pos + 1) ||
                checkBoard(board, visited, word, i, j - 1, pos + 1);
        visited[i][j] = false;
        return res;
    }
}