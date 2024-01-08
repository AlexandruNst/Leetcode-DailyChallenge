class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int across = Math.abs(sx - fx);
        int above = Math.abs(sy - fy);

        if (above + across == 0)
            return t != 1;

        int shortest = Math.max(across, above);
        if (shortest > t)
            return false; // shortest takes longer than t
        else
            return true;
    }
}