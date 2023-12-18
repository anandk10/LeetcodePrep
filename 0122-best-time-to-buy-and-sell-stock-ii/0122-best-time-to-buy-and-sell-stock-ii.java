class Solution {
    
    /**
    A natural intuition for solving this is 
    find the valleys and peaks and maximize
    the valley and peak difference to make max profit
    */
    
    private int maxProfitWithValleyAndPeak(int[] prices) {
        
        // initially consider both the valley and peak
        // to be the first stock price itself
        int valley = prices[0];  
        int peak = prices[0];
        int maxProfit = 0;
        
        for (int i = 0; i < prices.length - 1;) {
            
            // if we hit a valley, keep looking for 
            // the next lowest point
            // look for negative slope
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            
            // found the valley point
            valley = prices[i];
            
            // now look for peaks
            // look for positive slope
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            
            peak = prices[i];
            
            // we found a valley to peak transition
            maxProfit += peak - valley;
            
        }
        return maxProfit;
        
    }
    
    public int maxProfit(int[] prices) {
        return maxProfitWithValleyAndPeak(prices);
    }
}