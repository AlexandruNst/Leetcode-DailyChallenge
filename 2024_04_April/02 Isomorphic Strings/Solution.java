import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (map.containsKey(sChar) && tChar != map.get(sChar))
                return false;
            if (!map.containsKey(sChar) && map.containsValue(tChar))
                return false;
            map.put(sChar, tChar);
        }

        return true;
    }
}