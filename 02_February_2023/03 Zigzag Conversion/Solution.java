/**
 * Solution
 */
class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2 || s.length() < 3 || s.length() < numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int direction = 1; // 1 - down, -1 - up

        char[] sChars = s.toCharArray();
        int index = 0;
        for (char c : sChars) {
            rows[index].append(c);
            index += direction;
            if (index == 0 || index == numRows - 1)
                direction = (-1) * direction;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }

        return result.toString();
    }
}