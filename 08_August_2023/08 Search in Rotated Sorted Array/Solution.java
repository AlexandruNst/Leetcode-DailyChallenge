class Solution {
    public int search(int[] nums, int target) {
        int pivot = nums.length - 1;
        if (nums[0] > nums[nums.length - 1]) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                pivot = (left + right) / 2;
                if (nums[pivot] > nums[pivot + 1])
                    break;
                else if (nums[pivot] < nums[right])
                    right = pivot;
                else
                    left = pivot + 1;
            }
        }
        int left, right;
        if (target >= nums[0]) {
            left = 0;
            right = pivot + 1;
        } else {
            left = pivot;
            right = nums.length;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid])
                left = mid + 1;
            else
                right = mid;
        }

        return -1;
    }
}