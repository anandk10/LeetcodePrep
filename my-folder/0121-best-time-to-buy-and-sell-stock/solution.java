class Solution {
    public int maxProfit(int[] prices) {
    
      // Using a two pointer technique to find the max profit. 
      int left = 0;
      int right = 1;
      int max = 0;

      while (right < prices.length) {
        if (prices[left] < prices[right]) {
          max = Math.max(max, prices[right] - prices[left]);
        } else {
          left = right;
        }
        right += 1;
      }
      return max;



    }
}
