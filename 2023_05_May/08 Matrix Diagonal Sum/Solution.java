class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            int j = mat.length - 1 - i;
            if (i != j)
                sum += mat[i][j];
        }

        return sum;
    }
}