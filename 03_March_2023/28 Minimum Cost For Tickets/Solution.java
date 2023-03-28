import java.util.*;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];

        int[] dp = new int[lastDay + 1];
        Set<Integer> travelDays = new HashSet<>();
        for (int day : days) {
            travelDays.add(day);
        }

        for (int i = 1; i <= lastDay; i++) {
            if (!travelDays.contains(i)) {
                dp[i] = dp[i - 1];
            } else {
                int cost1 = dp[i - 1] + costs[0];
                int cost2 = dp[Math.max(i - 7, 0)] + costs[1];
                int cost3 = dp[Math.max(i - 30, 0)] + costs[2];

                dp[i] = Math.min(cost1, Math.min(cost2, cost3));
            }
        }

        return dp[lastDay];
    }
}