class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // Arrays.sort(arr);
        // arr[0] = 1;
        // for(int i = 1; i < arr.length; i++){
        // if(arr[i] - arr[i - 1] > 1) arr[i] = arr[i - 1] + 1;
        // }

        // return arr[arr.length - 1];

        int l = arr.length;
        int[] counter = new int[l];

        for (int i = 0; i < l; i++) {
            ++counter[Math.min(arr[i] - 1, l - 1)];
        }

        int ans = 1;
        for (int i = 1; i < l; i++) {
            ans = Math.min(i + 1, ans + counter[i]);
        }

        return ans;
    }
}