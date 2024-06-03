class Solution3 {
    public int appendCharacters(String s, String t) {
        int p_s = 0;
        int p_t = 0;
        while (p_s < s.length() && p_t < t.length()) {
            if (s.charAt(p_s) == t.charAt(p_t))
                p_t++;
            p_s++;
        }
        if (p_t == t.length())
            return 0;
        else
            return t.length() - p_t;
    }
}