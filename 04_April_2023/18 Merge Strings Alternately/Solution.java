class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i1 = 0, i2 = 0;
        StringBuilder res = new StringBuilder();
        while (i1 < word1.length() || i2 < word2.length()) {
            if (i1 < word1.length())
                res.append(word1.charAt(i1++));
            if (i2 < word2.length())
                res.append(word2.charAt(i2++));
        }

        return res.toString();
    }
}