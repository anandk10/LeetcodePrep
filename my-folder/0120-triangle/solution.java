class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        // root of the tree/triangle: triangle.get(0).get(0); 

        // rows 
        int i = triangle.size() - 1;
        int[] dp = new int[triangle.get(i).size() + 1];

        for ( ; i>=0; i--) {
            // [4,1,8,3]
            List<Integer> currentList = triangle.get(i);
            for(int j=0; j < currentList.size(); j++) {
                dp[j] = currentList.get(j) + Math.min(dp[j], dp[j+1]);
            }

            // dp : 4, 1, 8, 3, 0

            // [6 5 7]
            // dp : 7, 6, 10, 3, 0

            // [3 4]
            // dp : 9, 10, 10, 3, 0

            // [2]
            // dp : 11, 10, 10, 3, 0
        }
        return dp[0];
    }
}
