class Solution {
    public int[] sortedSquares(int[] nums) {
        int breakItemIndex = binarySearch(nums, 0, nums.length);
        System.out.println(breakItemIndex);
        int r = breakItemIndex;
        int l = breakItemIndex - 1;
        int[] res = new int[nums.length];
        int index = 0;
        while (l >= 0 && r < nums.length) {
            if (Math.abs(nums[l]) < Math.abs(nums[r]))
                res[index++] = (int) Math.pow(nums[l--], 2);
            else
                res[index++] = (int) Math.pow(nums[r++], 2);
        }
        while (l >= 0) {
            res[index++] = (int) Math.pow(nums[l--], 2);
        }
        while (r < nums.length) {
            res[index++] = (int) Math.pow(nums[r++], 2);
        }

        return res;
    }

    private int binarySearch(int[] nums, int l, int r) {
        if (l >= r)
            return l;
        int mid = (l + r) / 2;
        if (mid > 0 && nums[mid] > 0 && nums[mid - 1] < 0)
            return mid;
        else if (mid > 0 && nums[mid] >= 0 && nums[mid - 1] >= 0)
            return binarySearch(nums, l, mid);
        else
            return binarySearch(nums, mid + 1, r);
    }
}