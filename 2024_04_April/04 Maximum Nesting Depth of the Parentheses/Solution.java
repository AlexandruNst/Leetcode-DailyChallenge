class Solution {
    public int maxDepth(String s) {
        int res = 0;
        int stack = 0;
        for(char c : s.toCharArray()){
            if(c == '(') stack++;
            if(c == ')') stack--;
            res = Math.max(res, stack);
        }

        return res;
    }
}