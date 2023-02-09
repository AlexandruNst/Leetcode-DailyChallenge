class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;

        int far = 0, end = 0, answer = 0;
        for (int i = 0; i < nums.length; i++) {
            far = Math.max(far, i + nums[i]);

            if (far >= nums.length - 1)
                return answer + 1;

            if (i == end) {
                answer++;
                end = far;
            }
        }

        return answer;
    }
}