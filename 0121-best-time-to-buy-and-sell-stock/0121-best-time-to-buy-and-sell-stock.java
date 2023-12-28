class Solution {
    
    
    /**
    Sliding window problem where left and right pointer indicate a window
    that yields max profit on buy and selling stock
    if we achieve a profit then keep moving towards right
    if we achieve a loss then update the left to the current day where we sold
    i.e. right
    
    */
    private int maxProfitWithBuyAndSellOnDiffDays(int[] prices) {
        // [7,1,5,3,6,4]
        //    l r
        int left = 0;
        int right = left + 1; // sell happens always on day in future
        
        int maxProfit = 0;

        while (right < prices.length) {
            // be assertive about finding profit
            if (prices[left] < prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            } else {
                // we made a loss
                // since prices[right] was a lower price than prices[left]
                // left index is our new buy point
                left = right;
            }
            right += 1;
        }
        
        return maxProfit;
    }
    
    public int maxProfit(int[] prices) {
        return maxProfitWithBuyAndSellOnDiffDays(prices);
    }
}