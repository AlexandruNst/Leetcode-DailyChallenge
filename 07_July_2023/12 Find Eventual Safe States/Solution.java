import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Map<Integer, Boolean> safe = new HashMap<>();

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (dfs(i, safe, graph))
                res.add(i);
        return res;
    }

    public boolean dfs(int i, Map<Integer, Boolean> safe, int[][] graph) {
        if (safe.containsKey(i))
            return safe.get(i);

        safe.put(i, false);
        for (int nei : graph[i])
            if (!dfs(nei, safe, graph))
                return false;
        safe.put(i, true);
        return true;
    }
}