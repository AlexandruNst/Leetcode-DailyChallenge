class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();

        String[] map = new String[] { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        return combos(digits, 0, map);
    }

    private List<String> combos(String digits, int n, String[] map) {
        if (n == digits.length() - 1) {
            List<String> res = new ArrayList<>();
            for (char c : map[digits.charAt(n) - '0' - 2].toCharArray()) {
                res.add(String.valueOf(c));
            }
            return res;
        } else {
            List<String> nextStrings = combos(digits, n + 1, map);
            List<String> res = new ArrayList<>();
            for (String s : nextStrings) {
                for (char c : map[digits.charAt(n) - '0' - 2].toCharArray()) {
                    res.add(String.valueOf(c) + s);
                }
            }
            return res;
        }
    }
}