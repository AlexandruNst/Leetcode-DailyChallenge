class Solution {
    public double average(int[] salary) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int s : salary) {
            sum += s;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }

        sum -= min;
        sum -= max;

        double res = (double) sum / ((double) salary.length - 2);

        return res;
    }
}