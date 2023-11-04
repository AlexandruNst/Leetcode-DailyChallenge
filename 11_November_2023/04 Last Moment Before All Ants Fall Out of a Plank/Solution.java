class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        if (left.length == 0 && right.length == 0)
            return 0;

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i : left)
            max = Math.max(max, i);
        for (int i : right)
            min = Math.min(min, i);

        if (left.length == 0)
            return n - min;
        if (right.length == 0)
            return max;
        else
            return Math.max(n - min, max);
    }
}