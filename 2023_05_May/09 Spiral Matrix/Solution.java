import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        int left = 0, up = 0, right = m - 1, down = n - 1;

        while (res.size() < n * m) {
            for (int i = left; i <= right && res.size() < n * m; i++)
                res.add(matrix[up][i]);
            for (int i = up + 1; i < down && res.size() < n * m; i++)
                res.add(matrix[i][right]);
            for (int i = right; i >= left && res.size() < n * m; i--)
                res.add(matrix[down][i]);
            for (int i = down - 1; i > up && res.size() < n * m; i--)
                res.add(matrix[i][left]);

            left++;
            right--;
            up++;
            down--;
        }

        return res;
    }
}