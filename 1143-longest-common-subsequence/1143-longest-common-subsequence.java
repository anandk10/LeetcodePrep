class Solution {
    /**
    Recurrence Relation:

    dp[i][j] represents the length of the LCS between the suffixes text1[i:] and text2[j:].
    If text1[i] == text2[j], then dp[i][j] = 1 + dp[i + 1][j + 1].
    If text1[i] != text2[j], then dp[i][j] = max(dp[i][j + 1], dp[i + 1][j]).
     */
    public int longestCommonSubsequence(String text1, String text2) {

        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();

        int[][] dp = new int[t1.length + 1][t2.length + 1];

        // fill up everything with 0
        for(int i = 0 ; i < t1.length + 1; i++) {
            Arrays.fill(dp[i], 0);
            System.out.println(Arrays.toString(dp[i]));
        }

        for (int i = t1.length - 1; i >= 0; i--) {

            for (int j = t2.length - 1; j >=0 ; j--) {

                if (t1[i] == t2[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }

            }
        }
        return dp[0][0];
    }
}