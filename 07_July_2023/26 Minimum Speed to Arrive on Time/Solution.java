class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if(hour <= dist.length - 1) return -1;
        int min = 1;
        int max = Integer.MAX_VALUE;
        while(min < max){
            int output = min + (max - min) / 2;
            if(isValid(dist, output, hour)){
                max = output;
            } else {
                min = output + 1;
            }
        }
        return min;
    }

    private boolean isValid(int[] dist, double output, double hour){
        double journey = 0;
        for(int i = 0; i < dist.length - 1; i++){
            journey += Math.ceil(dist[i] / output);
        }
        journey += dist[dist.length - 1] / output;
        if(journey <= hour) return true;
        return false;
    }
}