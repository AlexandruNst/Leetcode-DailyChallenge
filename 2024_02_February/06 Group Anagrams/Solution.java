import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            List<String> group = map.getOrDefault(sorted, new ArrayList<>());
            group.add(strs[i]);
            map.put(sorted, group);
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> group : map.values()) {
            res.add(group);
        }

        return res;
    }
}