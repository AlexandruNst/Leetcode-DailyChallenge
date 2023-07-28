class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int p1Score = 0;
        int p2Score = 0;
        boolean turn = true;

        return predict(nums, left, right, p1Score, p2Score, turn);
    }

    private boolean predict(int[] nums, int left, int right, int p1Score, int p2Score, boolean p1Turn) {
        if (left > right)
            return p1Score >= p2Score;
        else {
            return p1Turn ? predict(nums, left + 1, right, p1Score + nums[left], p2Score, !p1Turn)
                    || predict(nums, left, right - 1, p1Score + nums[right], p2Score, !p1Turn)
                    : predict(nums, left + 1, right, p1Score, p2Score + nums[left], !p1Turn)
                            && predict(nums, left, right - 1, p1Score, p2Score + nums[right], !p1Turn);
        }
    }
}