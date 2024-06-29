import java.util.*;

class Solution29 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            List<Integer> froms = map.getOrDefault(to, new ArrayList<>());
            froms.add(from);

            map.put(to, froms);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(i)) {
                res.add(new ArrayList<>());
                continue;
            }

            Set<Integer> ancestors = new HashSet<>();
            Queue<Integer> q = new LinkedList<>();

            for (int from : map.get(i)) {
                q.add(from);
            }

            while (!q.isEmpty()) {
                int node = q.poll();
                ancestors.add(node);
                if (map.containsKey(node)) {
                    for (int from : map.get(node)) {
                        if (!ancestors.contains(from))
                            q.add(from);
                    }
                }
            }

            List<Integer> ancestorsList = new ArrayList<>(ancestors);
            Collections.sort(ancestorsList);

            res.add(ancestorsList);
        }

        return res;

    }
}