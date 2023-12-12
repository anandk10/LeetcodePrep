class Solution {

    // top down
    private int maxCoinsForTotalTopDown(int[] coins, int total, Map<Integer, Integer> map) {

        if (total == 0) return 0;

        if (map.containsKey(total)) return map.get(total);

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (coin > total) {
                continue;
            } 

            // calculate for total - coin
            int val = maxCoinsForTotalTopDown(coins, total - coin, map);

            // if min val of number of coins received then update
            if (val < min) {
                min = val;
            }

        }

        // if min stays at Integer.MAX_VALUE that indicates that no possible 
        // coin could sum upto the total
        if (min != Integer.MAX_VALUE) {
            // Adding 1 because we are choosing the current coin 
            min = 1 + min;
        }

        // memoizing the value for total
        map.put(total, min);

        return min;
    }

    private int maxCoinsForTotalBottomUp(int[] coins, int total) {
        int[] dp = new int[total + 1];

        for (int j = 0 ; j <= total ; j++) {
            dp[j] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for(int i = 0;  i < coins.length; i++) {
            for (int j = 1; j <= total ; j++) {
                if (j < coins[i]) continue;
                int min = Math.min(dp[j], 1 + dp[j - coins[i]]);
                dp[j] = min;
            }
        }

        if (dp[total] == Integer.MAX_VALUE) return -1;
        
        return dp[total];

    }

    public int coinChange(int[] coins, int amount) {

        if (amount <= 0) return 0;

        System.out.println("Bottom up : " + maxCoinsForTotalBottomUp(coins, amount));
        
        Map<Integer, Integer> map = new HashMap<>();
        int counts = maxCoinsForTotalTopDown(coins, amount, map);

        if (counts == Integer.MAX_VALUE) {
            return -1;
        }

        return map.getOrDefault(amount, -1);
    }
}