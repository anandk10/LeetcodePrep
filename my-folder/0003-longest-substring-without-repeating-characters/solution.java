class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // stores uniquely seen characters in that sliding window
        Set<Character> seen = new HashSet<>();

        int left = 0;
        int right = 0;
        int longest = 0;
        for(;right < s.length(); right++) {
            if (!seen.contains(s.charAt(right))) {
                seen.add(s.charAt(right));
                longest = Math.max(longest, right - left + 1);
            } else {
                // shrink the sliding window until the duplicate element is out of the window
                // also remove those characters from the set
                while (seen.contains(s.charAt(right))) {
                    seen.remove(s.charAt(left));
                    left++;
                }
                seen.add(s.charAt(right));
            }
        }
        return longest;

    }
}

