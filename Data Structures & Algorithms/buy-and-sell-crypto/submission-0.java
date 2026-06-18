class Solution {
    public int maxProfit(int[] prices) {
        
        int largestProfit = 0;
        int buy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            largestProfit = Math.max(largestProfit, prices[i]-buy);
            if (prices[i] < buy) buy = prices[i];
        }

        return largestProfit;
    }
}
