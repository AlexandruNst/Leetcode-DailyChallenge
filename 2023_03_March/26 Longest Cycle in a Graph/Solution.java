import java.util.*;

// DFS

class Solution {
    int answer = -1;

    public int longestCycle(int[] edges) {
        int n = edges.length;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                Map<Integer, Integer> dist = new HashMap<>();
                // dist.put(i, 0);
                dfs(i, 0, edges, dist, visited);
            }
        }
        return answer;
    }

    private void dfs(int i, int d, int[] edges, Map<Integer, Integer> dist, Set<Integer> visited) {
        visited.add(i);
        dist.put(i, d);
        int connection = edges[i];

        if (connection != -1) {
            if (!visited.contains(connection)) {
                dfs(connection, d + 1, edges, dist, visited);
            } else if (dist.containsKey(connection)) { // we do this check because we might have come across this node
                                                       // in a prev dfs
                int nodesInThisCycle = dist.get(i) - dist.get(connection) + 1;
                answer = Math.max(answer, nodesInThisCycle);
            }
        }
    }
}

// Khan's algorithm

class Solution2 {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        Set<Integer> visited = new HashSet<>();
        int[] indegree = new int[n];

        // Count indegree of each node i.e. how many nodes go into this node
        for (int edge : edges) {
            if (edge != -1)
                indegree[edge]++;
        }

        // Khan's algorithm starts

        // Add the nodes with indegree == 0 in the queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        // Take the nodes they point to, delete a degree and see if they're also now
        // indegree==0
        // basically start from leafs up
        while (!q.isEmpty()) {
            int node = q.poll();
            visited.add(node);
            int connection = edges[node];
            if (connection != -1) {
                indegree[connection]--;
                if (indegree[connection] == 0) {
                    q.offer(connection);
                }
            }
        }

        // Khan's algorithm ends

        // We now only have cycles in indegrees array, rest are 0
        // We know which ones are != 0 cus they're not in visited
        // check the longest cycle
        // the length of a cycle is how many steps it takes for a node to reach itself
        // back

        int answer = -1;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                int connection = edges[i];
                int cycleLength = 1;
                while (i != connection) {
                    visited.add(connection);
                    connection = edges[connection];
                    cycleLength++;
                }
                answer = Math.max(answer, cycleLength);
            }
        }

        return answer;

    }
}

// Iterative

class Solution3 {
    public int longestCycle(int[] edges) {
        int answer = -1;
        int n = edges.length;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                int connection = edges[i];
                int cycleLength = 1;
                Map<Integer, Integer> dist = new HashMap<>();
                dist.put(i, 0);
                while (connection != -1 && !visited.contains(connection)) {
                    dist.put(connection, cycleLength);
                    visited.add(connection);
                    connection = edges[connection];
                    cycleLength++;
                }
                if (connection != -1 && dist.containsKey(connection)) {
                    int d = cycleLength - dist.get(connection);
                    answer = Math.max(answer, d);
                }

            }
        }
        return answer;
    }

}