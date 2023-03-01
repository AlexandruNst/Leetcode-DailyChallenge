class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);

            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int leftArrSize = mid - left + 1;
        int rightArrSize = right - mid;
        int[] leftArr = new int[leftArrSize];
        int[] rightArr = new int[rightArrSize];

        for (int i = 0; i < leftArrSize; i++) {
            leftArr[i] = nums[left + i];
        }

        for (int i = 0; i < rightArrSize; i++) {
            rightArr[i] = nums[mid + 1 + i];
        }

        int k = left;
        int i = 0, j = 0;
        while (i < leftArrSize && j < rightArrSize) {
            if (leftArr[i] < rightArr[j]) {
                nums[k++] = leftArr[i++];
            } else {
                nums[k++] = rightArr[j++];
            }
        }

        while (i < leftArrSize) {
            nums[k++] = leftArr[i++];
        }

        while (j < rightArrSize) {
            nums[k++] = rightArr[j++];
        }
    }
}