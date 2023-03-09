class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minBananasPerHour = 1;
        int maxBananasPerHour = -1;
        for (int bananas : piles) {
            maxBananasPerHour = Math.max(maxBananasPerHour, bananas);
        }

        int result = binarySearchBananas(minBananasPerHour, maxBananasPerHour, piles, h);
        return result;
    }

    private int binarySearchBananas(int minBananasPerHour, int maxBananasPerHour, int[] piles, int h) {
        while (minBananasPerHour < maxBananasPerHour) {
            int midBananasPerHour = minBananasPerHour + (maxBananasPerHour - minBananasPerHour) / 2;

            boolean isEnoughBanans = isEnoughBananas(midBananasPerHour, piles, h);

            if (isEnoughBanans) {
                maxBananasPerHour = midBananasPerHour;
            } else {
                minBananasPerHour = midBananasPerHour + 1;
            }
        }

        return minBananasPerHour;
    }

    private boolean isEnoughBananas(int midBananasPerHour, int[] piles, int h) {
        int hours = 0;
        for (int bananas : piles) {
            hours += bananas / midBananasPerHour;
            if (bananas % midBananasPerHour != 0)
                hours++;
        }

        return hours <= h;
    }
}