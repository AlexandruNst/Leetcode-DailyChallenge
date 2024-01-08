import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); // O(n log n)

        int m = spells.length;
        int[] pairs = new int[m];
        for (int i = 0; i < m; i++) {
            pairs[i] = calcSuccessfulPairs(spells[i], potions, success); // O(m * n log n)
        }

        return pairs;
    }

    private int calcSuccessfulPairs(int spell, int[] potions, long success) {
        // sanity check
        if ((long) spell * (long) potions[potions.length - 1] < success)
            return 0;

        int l = 0;
        int r = potions.length;
        int mid = 0;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (isSuccessfulPair(spell, potions[mid], success))
                r = mid;
            else
                l = mid + 1;
        }

        return potions.length - r;
    }

    private boolean isSuccessfulPair(int spell, int potion, long success) {
        return (long) spell * (long) potion >= success;
    }
}