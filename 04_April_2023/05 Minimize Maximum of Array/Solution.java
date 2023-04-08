class Solution {
    public int minimizeArrayValue(int[] nums) {
        long answer = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int countNums = i + 1;
            long currMax = (sum + countNums - 1) / countNums; // this somehow achieves Math.ceil
            // But if you don't want to use Ceil then just add (denominator-1) to the
            // numerator and perform normal integer division. The answer will be the same.
            // Consider this integer division examples
            // 51/10 = 5 (but we want 6)
            // (51+10-1)/10 = 60/10 = 6
            answer = Math.max(answer, currMax);
        }

        return (int) answer;
    }
}