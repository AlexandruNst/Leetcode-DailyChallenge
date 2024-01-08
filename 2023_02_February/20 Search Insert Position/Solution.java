class Solution {
    public int searchInsert(int[] nums, int target) {
        return searchInsertHelper(nums, 0, nums.length, target);
    }

    private int searchInsertHelper(int[] nums, int start, int end, int target) {
        if (start >= end)
            return start;

        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return mid;
        else {
            if (target < nums[mid])
                return searchInsertHelper(nums, start, mid, target);
            else
                return searchInsertHelper(nums, mid + 1, end, target);
        }
    }
}