class Solution {
    public int maxProfit(int[] prices) {
        int currMinPrice = Integer.MAX_VALUE;
        int currProfit = 0;
        for (int price : prices) {
            if (price < currMinPrice)
                currMinPrice = price;
            if (price - currMinPrice > currProfit)
                currProfit = price - currMinPrice;
        }

        return currProfit;
    }
}