class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = 0; // default  profit
        int currProfit = 0;

        int buyPoint = 0;
        int sellPoint = buyPoint + 1;

        while (sellPoint < prices.length) {
          if (prices[buyPoint] < prices[sellPoint]) {
            maxProfit = Math.max(maxProfit, prices[sellPoint] - prices[buyPoint]);
          } else {
            // found a better buyPoint
            buyPoint = sellPoint;
          }
          sellPoint++;
        }

        

        

        return maxProfit;

        



    }
}
