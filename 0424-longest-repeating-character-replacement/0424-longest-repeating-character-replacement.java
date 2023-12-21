class Solution {
    /**
    
    The idea is to use a window to how many minimum characters are to 
    replaced to make string the same.
    
    The trick here is : for a window (substring), if 
        
            (windowSize - max occurring char count) <= k
    
    that will mean that the other characters are less than the threshold. 
    
    Keep expanding the window until we find another character that violates <=k criteria.
    Once the rule breaks, remove unncessary occurrence from the freq Map / charFreqArr
    
    */
    private int solution1(String s, int k) {
        int res = 0;
        int left = 0, right = 0;
        int maxFreq = 0;
        
        // Map<Character, Integer> charFreq = new TreeMap<>();
        int[] charFreqArr = new int[26];
        Arrays.fill(charFreqArr, 0);
        
        while (right < s.length()) {
            
        int currChar = s.charAt(right) - 'A';
            charFreqArr[currChar]++;
            maxFreq = Math.max(maxFreq, charFreqArr[currChar]);
            
            // windowSize - maxFreq should be <= k
            // if its not, then shrink the window
            // decrement the freq count
            while (((right - left + 1) - maxFreq) > k) {
                // remove the freq count for the character by k
                charFreqArr[s.charAt(left) - 'A']--;
                left++;
            }
            
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
    
    public int characterReplacement(String s, int k) {
        return solution1(s, k);
    }
}