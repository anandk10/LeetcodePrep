class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
        "abcabcbb"
              i
               j

        c, b

        */
    
        Set<Character> seen = new HashSet<>();

        int size = 0;

        int i = 0, j = 0;

        while(j < s.length()) {
            if (!seen.contains(s.charAt(j))) {
                seen.add(s.charAt(j));
                size = Math.max(size, j - i + 1);
                j++;
            } else {
                
                while(seen.contains(s.charAt(j))) {
                    seen.remove(s.charAt(i));
                    i++;
                }
                
            }
        }
        return size;

    }
}

/**

substring - sequence - sequential access
Longest - maximize  - max() - size
w/o repeating character - aux data structure Set

 */
