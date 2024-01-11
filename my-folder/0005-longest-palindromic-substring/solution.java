class Solution {
    /**
    Find palindrome using outward expansion technique
    be at i (left = i, right = i), and then start looking at left and right indexes. and keep
    on going until you hit different character

    for even palindrome (left = i, right = i + 1), and carry out the same process. 
     */
    public String longestPalindrome(String s) {

        String res = "";
        // "babadbabadbabad"
        
        for (int i = 0 ; i < s.length(); i++) {


            res = expandPalindrome(s, i, i, res);
            res = expandPalindrome(s, i, i + 1, res);
            
            // int left = i, right = i;
            // while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            //     if (resLen < (right - left + 1)) {
            //         resLen = right - left + 1;
            //         res = s.substring(left, right + 1);
            //     }
            //     left--;
            //     right++;
            // }

            // left = i; right = i + 1;
            // while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            //     if (resLen < (right - left + 1)) {
            //         resLen = right - left + 1;
            //         res = s.substring(left, right + 1);
            //     }
            //     left--;
            //     right++;
            // }


        }

        return res;
        
    }

    private String expandPalindrome(String s, int left, int right, String res) {
        int len = s.length();

        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            left -= 1;
            right += 1;
        }

        // right - left - 1 is correct here because the above loop has been broken
        // and the window sizing works slightly differently
        if (res.length() < (right - left - 1)) { 
            // see how we needed to increment left and restrict to right
            res = s.substring(left + 1, right); 
        }

        return res;
    }
}
