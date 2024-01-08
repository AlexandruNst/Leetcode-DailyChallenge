class Solution {
    public long zeroFilledSubarray(int[] nums) {
        boolean countingZeros = false;
        long start = -1;
        long end = -1;
        long answer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && !countingZeros) {
                countingZeros = true;
                start = i;
            } else if (nums[i] != 0 && countingZeros) {
                countingZeros = false;
                end = i;
                answer += calcNumberOfSubarrays(end - start);
            }
        }

        if (countingZeros) {
            answer += calcNumberOfSubarrays(nums.length - start);
        }

        return answer;
    }

    private long calcNumberOfSubarrays(long n) {
        return n * (n + 1) / 2;
    }
}

// Slightly faster on Leetcode, but still linear.
// Achives the same idea in a hackier way

class Solution2 {
    public long zeroFilledSubarray(int[] nums) {
        long answer = 0;
        long lenSubarray = 0;
        for (int num : nums) {
            if (num == 0) {
                lenSubarray++;
            } else {
                lenSubarray = 0;
            }
            answer += lenSubarray;
        }

        return answer;
    }
}