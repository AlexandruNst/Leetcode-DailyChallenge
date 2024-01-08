class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long minTime = 1;
        long maxTime = -1;
        for(int t : time){
            maxTime = Math.max(maxTime, t);
        }
        maxTime *= totalTrips;
        long result = binarySearchTime(minTime, maxTime, time, totalTrips);
        return result;
    }

    private long binarySearchTime(long minTime, long maxTime, int[] time, int totalTrips){
        while(minTime < maxTime){
            long midTime = minTime + (maxTime - minTime) / 2;
            boolean isEnoughTime = isEnoughTime(time, midTime, totalTrips);

            if(isEnoughTime){
                maxTime = midTime;    
            } else {
                minTime = midTime + 1;
            }
        }

        return minTime;
    }

    private boolean isEnoughTime(int[] time, long midTime,  int totalTrips){
        long trips = 0;
        for(int t: time){
            trips += midTime / t;
            if(trips >= totalTrips) return true; 
        }

        return false;
    }
}