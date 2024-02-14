class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int positiveI = 0;
        int negativeI = 1;

        for(int num : nums){
            if(num > 0){
                res[positiveI] = num;
                positiveI += 2;
            }
            else {
                res[negativeI] = num;
                negativeI += 2;
            }
        }

        return res;
    }
}