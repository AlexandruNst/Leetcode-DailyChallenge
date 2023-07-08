import java.util.Arrays;

class Solution {
    public long putMarbles(int[] weights, int k) {
        long[] coupledWeights = new long[weights.length - 1];
        for (int i = 0; i < weights.length - 1; i++) {
            coupledWeights[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(coupledWeights);
        int n = coupledWeights.length;
        long res = 0;
        for (int i = 0; i < k - 1; i++) {
            res += coupledWeights[n - i - 1] - coupledWeights[i];
        }

        return res;
    }
}