import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0)
            return true;

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] req : prerequisites) {
            int from = req[1];
            int to = req[0];
            List<Integer> conns = adj.getOrDefault(from, new ArrayList<>());
            conns.add(to);
            adj.put(from, conns);
        }

        Map<Integer, Boolean> dp = new HashMap<>();
        for (int course : adj.keySet()) {
            if (!dfs(course, dp, adj)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course, Map<Integer, Boolean> dp, Map<Integer, List<Integer>> adj) {
        if (dp.containsKey(course))
            return dp.get(course);

        if (adj.containsKey(course)) {
            dp.put(course, false);
            for (int conn : adj.get(course))
                if (!dfs(conn, dp, adj))
                    return false;
        }
        dp.put(course, true);
        return true;
    }
}