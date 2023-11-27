class Solution {


    public int strStr(String haystack, String needle) {
        
        int m = needle.length();
        int n = haystack.length();

        // Input: haystack = "sadbutsad", needle = "sad"
        // m = 3 n = 8
        // 8 - 3 = 5

        for (int windowStart = 0; windowStart <= n - m; windowStart++) {
            for (int i = 0; i < m; i++) {
                if (needle.charAt(i) != haystack.charAt(windowStart + i)) {
                    break;
                }
                
                if(i == m - 1) {
                    return windowStart;
                }
            }

            
        }
        return -1;

    }
}
