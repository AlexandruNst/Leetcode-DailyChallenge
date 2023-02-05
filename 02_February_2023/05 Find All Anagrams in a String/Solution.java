import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// T: O(N)
// S: O(N)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length())
            return new ArrayList<>();

        final int LOWERCASE_A_ASCII_VALUE = 97;
        final int LETTERS_IN_ALPHABET = 26;

        char[] sCharArr = new char[LETTERS_IN_ALPHABET];
        char[] pCharArr = new char[LETTERS_IN_ALPHABET];
        int windowLength = p.length();
        int start = 0;
        int end = windowLength - 1;
        List<Integer> result = new ArrayList<>();

        for (char c : p.toCharArray()) {
            pCharArr[c - LOWERCASE_A_ASCII_VALUE]++;
        }

        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            sCharArr[c - LOWERCASE_A_ASCII_VALUE]++;
        }

        if (Arrays.equals(sCharArr, pCharArr))
            result.add(start);

        while (end < s.length() - 1) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end + 1);

            sCharArr[startChar - LOWERCASE_A_ASCII_VALUE]--;
            sCharArr[endChar - LOWERCASE_A_ASCII_VALUE]++;

            start++;
            end++;
            if (Arrays.equals(sCharArr, pCharArr))
                result.add(start);

        }

        return result;
    }
}