import java.util.Arrays;

class Solution20 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        if (m == 2)
            return position[position.length - 1] - position[0];

        int left = 1;
        int right = position[position.length - 1] - position[0];

        while (left <= right) {
            int mid = (left + right) / 2;
            if (countBalls(mid, position) >= m)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right;
    }

    private int countBalls(int d, int[] position) {
        int balls = 1;
        int curr = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - curr >= d) {
                curr = position[i];
                balls++;
            }
        }

        return balls;
    }

}