import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int windowEnd = intervals[0][1];
        int deleted = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int start = interval[0];
            int end = interval[1];

            if (start >= windowEnd) {
                windowEnd = end;
            } else {
                deleted++;
                windowEnd = Math.min(windowEnd, end);
            }
        }

        return deleted;
    }
}