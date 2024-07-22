import java.util.*;

class Solution22 {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }

        Arrays.sort(heights);

        String[] res = new String[names.length];
        for (int i = 0; i < heights.length; i++) {
            res[names.length - i - 1] = map.get(heights[i]);
        }

        return res;
    }
}