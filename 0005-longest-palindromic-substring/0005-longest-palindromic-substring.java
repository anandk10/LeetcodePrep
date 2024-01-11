class Solution {
    /**
    Manacher's algorithm - O(N)
     */
    public String longestPalindrome(String s) {

        String res = null;
        int resLen = 0;
        // "babadbabadbabad"
        int len = s.length();
        for (int i = 0 ; i < s.length(); i++) {

            int left = i, right = i;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                if (resLen < (right - left + 1)) {
                    resLen = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            left = i; right = i + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                if (resLen < (right - left + 1)) {
                    resLen = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }


        }

        return res;
        
    }
}