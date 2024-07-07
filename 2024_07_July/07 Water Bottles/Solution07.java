class Solution07 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int emptyBottles = numBottles;

        while (emptyBottles >= numExchange) {
            int fullBottles = emptyBottles / numExchange;
            int unexchangesBottles = emptyBottles % numExchange;

            res += fullBottles;

            emptyBottles = fullBottles + unexchangesBottles;
        }

        return res;
    }
}