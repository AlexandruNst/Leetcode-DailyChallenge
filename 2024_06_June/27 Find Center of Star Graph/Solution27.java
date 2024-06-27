import java.util.*;

class Solution27 {
    public int findCenter(int[][] edges) {
        Set<Integer> e = new HashSet<>();
        for (int[] edge : edges) {
            for (int j = 0; j < 2; j++) {
                if (e.contains(edge[j]))
                    return edge[j];
                else
                    e.add(edge[j]);
            }
        }
        return 0;
    }
}