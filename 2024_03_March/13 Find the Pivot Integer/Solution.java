class Solution {
    public int pivotInteger(int n) {
        int l = 1;
        int r = n;
        int total = n * (n + 1) / 2;
        while(l <= r){
            int mid = (l + r) / 2;
            int leftTotal = mid * (mid + 1) / 2;
            int rightTotal = total - leftTotal + mid;
            if(leftTotal == rightTotal) return mid;
            else if(leftTotal < rightTotal) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}