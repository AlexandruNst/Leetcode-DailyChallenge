import java.util.*;

//T: O(n)
//S: O(26) = O(1) just the size of the alphabet
class Solution {
    public int partitionString(String s) {
        Set<Character> visited = new HashSet<>();
        int substrings = 0;
        for (char c : s.toCharArray()) {
            if (visited.contains(c)) {
                substrings++;
                visited.clear();
            }
            visited.add(c);
        }

        return substrings + 1;
    }
}