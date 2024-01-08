import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];

            List<List<Integer>> list = adj.getOrDefault(from, new ArrayList<>());
            Integer[] r = new Integer[] { to, 1 };
            List<Integer> road = Arrays.asList(r);
            list.add(road);
            adj.put(from, list);

            list = adj.getOrDefault(to, new ArrayList<>());
            r = new Integer[] { from, 0 };
            road = Arrays.asList(r);
            list.add(road);
            adj.put(to, list);
        }

        // // BFS
        // Queue<Integer> q = new LinkedList<>();
        // Set<Integer> visited = new HashSet<>();
        // int changedRoads = 0;
        // q.offer(0);
        // visited.add(0);
        // while(!q.isEmpty()){
        // int node = q.poll();
        // List<List<Integer>> conns = adj.get(node);
        // for(List<Integer> road: conns){
        // int dest = road.get(0);
        // int toOrFrom = road.get(1);
        // if(!visited.contains(dest)){
        // q.offer(dest);
        // visited.add(dest);
        // changedRoads += toOrFrom;
        // }
        // }
        // }

        // return changedRoads;

        // DFS
        Set<Integer> visited = new HashSet<>();
        return dfs(adj, visited, 0);
    }

    private int dfs(Map<Integer, List<List<Integer>>> adj, Set<Integer> visited, int from) {
        int changedRoads = 0;
        visited.add(from);
        List<List<Integer>> conns = adj.get(from);
        for (List<Integer> road : conns) {
            int to = road.get(0);
            int toOrFrom = road.get(1);
            if (!visited.contains(to)) {
                changedRoads += dfs(adj, visited, to);
                changedRoads += toOrFrom;
            }
        }

        return changedRoads;
    }
}