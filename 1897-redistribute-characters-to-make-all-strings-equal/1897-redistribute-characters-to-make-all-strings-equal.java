class Solution {

    public boolean makeEqual(String[] words) {
        // only one word then return true
        if (words.length == 1)
            return true;
        
        // get the total char counts 
        // and mod by the words length
        // to check if the characters as 
        // a whole could be distributed
        int totalCharCount = 0;
        for (String word : words) {
            totalCharCount += word.length();
        }

        if (totalCharCount % words.length != 0)
            return false;
        
        // to equally distribute the words
        // we just need to ensure that the 
        // character frequency for all the  
        // words can be evenly distributed
        
        int[] freq = new int[26];

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }
        }

        // once you've the frequency counts
        // compare for all the character
        // frequencies if it can be divided
        // across the words.length
        for (int fre : freq) {
            if (fre % words.length != 0) {
                return false;
            }
        }

        return true;
    }
}