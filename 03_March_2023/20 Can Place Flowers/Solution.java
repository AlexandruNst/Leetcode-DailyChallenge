class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;
        if (flowerbed.length == 1)
            return flowerbed[0] == 0 && n == 1;
        return canPlaceFlowersHelper(flowerbed, n);
    }

    private boolean canPlaceFlowersHelper(int[] flowerbed, int n) {
        int emptySpots = 0;
        int index = 0;
        if (flowerbed[index] == 0 && flowerbed[index + 1] == 0) {
            emptySpots++;
            flowerbed[index] = 1;
        }
        index++;
        while (index < flowerbed.length - 1) {
            if (flowerbed[index] == 0 && flowerbed[index - 1] == 0 && flowerbed[index + 1] == 0) {
                emptySpots++;
                flowerbed[index] = 1;
            }
            index++;

            if (emptySpots >= n)
                return true;
        }
        if (flowerbed[index] == 0 && flowerbed[index - 1] == 0)
            emptySpots++;

        return emptySpots >= n;
    }
}