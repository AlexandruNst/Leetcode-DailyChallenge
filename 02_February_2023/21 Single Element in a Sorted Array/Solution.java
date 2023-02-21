class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];
            else {
                if (mid % 2 != 0)
                    mid--;
                // we are in an even position. if next element is even, meaning the left side in
                // unperturbed, we look right
                if (nums[mid] == nums[mid + 1])
                    left = mid + 2; // have to skip the checked pair, or we might have infinite loop
                else
                    right = mid;
            }
        }

        return nums[left];
    }
}