import java.util.*;

//O(m * n log n)
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> answer = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            answer.add(isArithmeticSubarray(nums, l[i], r[i])); // O(m)
        }
        return answer;
    }

    private boolean isArithmeticSubarray(int[] array, int l, int r) {
        int[] subarray = Arrays.copyOfRange(array, l, r + 1); // O(n)
        Arrays.sort(subarray); // O(n log n)
        return isArithmeticArray(subarray);
    }

    private boolean isArithmeticArray(int[] array) {
        if (array.length < 2)
            return true;

        int diff = array[1] - array[0];
        for (int i = 1; i < array.length - 1; i++)
            if (array[i + 1] - array[i] != diff)
                return false;

        return true;
    }
}