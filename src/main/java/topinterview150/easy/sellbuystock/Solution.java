package topinterview150.easy.sellbuystock;

public class Solution {

    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }

        int minIndex = 0;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; ++i) {
            if(prices[i] < prices[minIndex]) {
                minIndex = i;
            }

            maxProfit = Math.max(maxProfit, prices[i] - prices[minIndex]);
        }


        return maxProfit;
    }
}
