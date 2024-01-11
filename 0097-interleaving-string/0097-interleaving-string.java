class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        // both strings are empty; the result string 
        // i.e.  character at 0
        dp[0][0] = true; 
        
        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();
        char[] s3arr = s3.toCharArray();

        // first fill up the row 0th
        for (int j = 1; j < s2.length() + 1; j++) {
            if (s3arr[j - 1] == s2arr[j - 1]) {
                dp[0][j] = dp[0][j - 1];
            }
        }
        

        // then fill up the column 0th
        for (int i = 1; i < s1.length() + 1; i++) {
            if (s3arr[i - 1] == s1arr[i - 1]) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < s1.length() + 1; i++) {

            for (int j = 1; j < s2.length() + 1; j++) {

                if (s3arr[i + j - 1] == s1arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }

                if (s3arr[i + j - 1] == s2arr[j - 1]) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }


            }

        }

        return dp[s1.length()][s2.length()];
    }
}