class Solution {
    public String largestGoodInteger(String num) {
        int res = -1;
        // Set<Character> set = new HashSet<>();

        // for(int i = 0; i < 3; i++) set.add(num.charAt(i));
        // if(set.size() == 1) res = Math.max(res, num.charAt(0) - '0');

        // int left = 0;
        // int right = 2;
        // while(right < num.length() - 1){
        // set.remove(num.charAt(left));
        // left++;
        // set.add(num.charAt(left));
        // set.add(num.charAt(right));
        // right++;
        // set.add(num.charAt(right));
        // if(set.size() == 1){
        // res = Math.max(res, num.charAt(left) - '0');
        // }
        // }

        for (int i = 2; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i - 1) == num.charAt(i - 2)) {
                res = Math.max(res, num.charAt(i) - '0');
            }
        }

        if (res == -1)
            return "";

        StringBuilder ans = new StringBuilder();
        ans.append(res);
        ans.append(res);
        ans.append(res);

        return ans.toString();
    }
}