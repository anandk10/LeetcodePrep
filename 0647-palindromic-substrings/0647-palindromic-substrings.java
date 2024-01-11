class Solution {
    public int countSubstrings(String s) {
         
        int res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {

            res += countPalindrome(s, i, i);
            res += countPalindrome(s, i, i + 1);
        }

        return res;

    }

    private int countPalindrome(String s, int left, int right) {
        int len = s.length();
        int res = 0;
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            res += 1;
            left -= 1;
            right += 1;
        }
        return res;
    }
}