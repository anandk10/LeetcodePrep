class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {

        if (str1.isEmpty()) return str2;
        if (str2.isEmpty()) return str1;

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        Arrays.fill(dp[0], 0);
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        // build the table
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder lcsBuilder = new StringBuilder();
        int i = dp.length - 1;
        int j = dp[0].length - 1;

        while (i > 0 || j > 0) {

            if (i <= 0) {
                lcsBuilder.append(str2.charAt(j - 1));
                j--;
                continue;
            }

            if (j <= 0) {
                lcsBuilder.append(str1.charAt(i - 1));
                i--;
                continue;
            }

            if (dp[i][j] == dp[i - 1][j]) {
                lcsBuilder.append(str1.charAt(i - 1));
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                lcsBuilder.append(str2.charAt(j - 1));
                j--;
            } else if (dp[i][j] == 1 + dp[i - 1][j - 1]) {
                lcsBuilder.append(str1.charAt(i - 1));
                i--;
                j--;
            }
        }
        
        // System.out.println(lcsBuilder.reverse().toString());
        // System.out.println(str1);
        // System.out.println(str2);


        return lcsBuilder.reverse().toString();
    }
}