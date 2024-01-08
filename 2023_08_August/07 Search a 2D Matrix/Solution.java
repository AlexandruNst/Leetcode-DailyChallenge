class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int up = 0;
        int down = matrix.length;
        int row = 0;
        while (up < down) {
            row = (up + down) / 2;
            if (target == matrix[row][0])
                return true;
            else if (target < matrix[row][0])
                down = row;
            else if (target > matrix[row][matrix[0].length - 1])
                up = row + 1;
            else
                break;
        }
        int left = 0;
        int right = matrix[0].length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (target == matrix[row][mid])
                return true;
            else if (target < matrix[row][mid])
                right = mid;
            else
                left = mid + 1;
        }

        return false;
    }
}