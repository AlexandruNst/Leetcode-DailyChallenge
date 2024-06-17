class Solution17 {
    public boolean judgeSquareSum(int c) {
        double l = 0;
        double r = Math.floor(Math.sqrt(c));
        while (l <= r) {
            double prod = l * l + r * r;
            if (prod == c)
                return true;
            else if (prod > c)
                r--;
            else
                l++;
        }

        return false;
    }
}