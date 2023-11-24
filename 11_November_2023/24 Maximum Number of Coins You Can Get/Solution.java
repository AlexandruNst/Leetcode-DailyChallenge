import java.util.Arrays;

class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int r = piles.length - 1;
        int l = 0;
        int sum = 0;
        while (l < r) {
            r--;
            sum += piles[r];
            r--;
            l++;
        }

        return sum;
    }
}