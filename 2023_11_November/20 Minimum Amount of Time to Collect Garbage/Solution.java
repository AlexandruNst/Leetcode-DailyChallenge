class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        // right to left

        int min = 0;
        for (int t : travel)
            min += 3 * t;
        for (String g : garbage)
            min += g.length();

        for (int i = garbage.length - 1; i > 0; i--) {
            if (!garbage[i].contains("M"))
                min -= travel[i - 1];
            else
                break;
        }

        for (int i = garbage.length - 1; i > 0; i--) {
            if (!garbage[i].contains("G"))
                min -= travel[i - 1];
            else
                break;
        }

        for (int i = garbage.length - 1; i > 0; i--) {
            if (!garbage[i].contains("P"))
                min -= travel[i - 1];
            else
                break;
        }

        return min;

        // left to right

        // int m = 0;
        // int g = 0;
        // int p = 0;
        // int min = 0;
        // for(int i = 0; i < garbage.length; i++){
        // String grb = garbage[i];
        // for(char c: grb.toCharArray()){
        // if(c == 'M') {
        // min += m;
        // min++;
        // m = 0;
        // }
        // if(c == 'G') {
        // min += g;
        // min++;
        // g = 0;
        // }
        // if(c == 'P') {
        // min += p;
        // min++;
        // p = 0;
        // }

        // }

        // if(i < travel.length){
        // m += travel[i];
        // g += travel[i];
        // p += travel[i];
        // }
        // }

        // return min;
    }
}