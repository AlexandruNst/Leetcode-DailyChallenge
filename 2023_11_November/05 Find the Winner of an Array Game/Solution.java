class Solution {
    public int getWinner(int[] arr, int k) {
        if (k > arr.length) {
            int max = 0;
            for (int i : arr)
                max = Math.max(max, i);
            return max;
        }

        int winner = arr[0];
        int streak = 0;
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            if (winner > num) {
                streak++;
            } else {
                winner = num;
                streak = 1;
            }
            if (streak == k)
                return winner; // the streak CAN be just 1
        }

        return winner;
    }
}