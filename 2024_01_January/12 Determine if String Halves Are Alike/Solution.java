import java.util.*;

class Solution {
    public boolean halvesAreAlike(String s) {
        int len = s.length();
        int vowels = 0;
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        for (int i = 0; i < len; i++) {
            if (vowelSet.contains(s.charAt(i))) {
                if (i < len / 2)
                    vowels++;
                else
                    vowels--;
            }
        }

        return vowels == 0;
    }
}