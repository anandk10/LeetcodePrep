class Solution {
    
    /**
    This works but Time outs for larger input only because
    of the inner loop that goes over all the values to 
    compute earlierTransactionsMaxProfit.
    */
    private int maxProfit(int[] prices, int transactions) {
        // [3,3,5,0,0,3,1,4]        
        int[][] T = new int[transactions + 1][prices.length];
        
        // 0 transaction base case - 0 profit
        Arrays.fill(T[0], 0);
        for (int i = 0; i < transactions; i++) {
            // first day will not yield any profit
            // for any number of transactions
            T[i][0] = 0;
        }
        
        for (int i = 1; i < transactions + 1; i++) {
            // for transaction i
            for (int j = 1; j < prices.length; j++) {
                // for day j - starting with 1st day and not the 0th day
                // profit without performing transaction i
                // on day j
                
                // profit from earlier day
                int profitWithoutDayJ = T[i][j - 1];
                
                
                
                int earlierTransactionsMaxProfit = Integer.MIN_VALUE;
                // sum up the earlier transaction's profit
                for (int m = 0; m < j; m++) {
                    // bought on day m + profit on day m
                    earlierTransactionsMaxProfit = 
                    Math.max(T[i - 1][m] - prices[m], earlierTransactionsMaxProfit);
                }
                
                // performing transaction on day j means selling
                // on day j and adding max profit gained by previous transaction
                // upto the previous day
                // prices[j];
                int profitWithDayJ = prices[j] + earlierTransactionsMaxProfit;
                
                T[i][j] = Math.max(profitWithoutDayJ, profitWithDayJ);
            }
        }
        return T[transactions][prices.length - 1];
        
    }
    
    private int maxProfitOptimized(int[] prices, int transactions) {
        // [3,3,5,0,0,3,1,4]        
        int[][] T = new int[transactions + 1][prices.length];
        
        // 0 transaction base case - 0 profit
        Arrays.fill(T[0], 0);
        for (int i = 0; i < transactions; i++) {
            // first day will not yield any profit
            // for any number of transactions
            T[i][0] = 0;
        }
        
        // optimization on computing previous transaction's
        // max profit
        

        for (int i = 1; i < transactions + 1; i++) {
            // for transaction i
            int earlierTransactionsMaxProfit = Integer.MIN_VALUE;
            for (int j = 1; j < prices.length; j++) {
                // for day j - starting with 1st day and not the 0th day
                // profit without performing transaction i
                // on day j
                
                // profit from earlier day
                int profitWithoutDayJ = T[i][j - 1];
                
                
                // performing transaction on day j means selling
                // on day j
                // prices[j];
                
                earlierTransactionsMaxProfit = Math.max(
                                       earlierTransactionsMaxProfit,
                                        T[i - 1][j - 1] - prices[j - 1]
                                        );

                // performing transaction on day j means selling
                // on day j and adding max profit gained by previous transaction
                // upto the previous day
                // prices[j];
                int profitWithDayJ = prices[j] + earlierTransactionsMaxProfit;
                
                T[i][j] = Math.max(profitWithoutDayJ, profitWithDayJ);
            }
        }
        return T[transactions][prices.length - 1];
        
    }
    
    
    public int maxProfit(int[] prices) {
        // return maxProfit(prices, 2);
        return maxProfitOptimized(prices, 2);
    }
}