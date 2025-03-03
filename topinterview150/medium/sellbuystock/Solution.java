package topinterview150.medium.sellbuystock;

public class Solution {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentBuyIndex = 0;

        for(int i = 0; i < prices.length; ++i) {
            if(prices[i] > prices[currentBuyIndex]) {
                maxProfit += prices[i] - prices[currentBuyIndex];
            }

            currentBuyIndex = i;
        }

        return maxProfit;
    }
}
