import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int minScore(int n, int[][] roads) {
        Map<Integer, Map<Integer, Integer>> adjList = new HashMap<>();
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            int dist = road[2];

            Map<Integer, Integer> list = adjList.getOrDefault(from, new HashMap<>());
            list.put(to, dist);
            adjList.put(from, list);

            list = adjList.getOrDefault(to, new HashMap<>());
            list.put(from, dist);
            adjList.put(to, list);
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int min = Integer.MAX_VALUE;
        q.add(1);
        visited.add(1);
        while (!q.isEmpty()) {
            int currNode = q.poll();
            if (adjList.containsKey(currNode)) {
                for (int i : adjList.get(currNode).keySet()) {
                    min = Math.min(min, adjList.get(currNode).get(i));
                    if (!visited.contains(i)) {
                        q.offer(i);
                        visited.add(i);
                    }
                }
            }
        }

        return min;
    }
}
