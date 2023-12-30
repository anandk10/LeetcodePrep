class Solution {

    private void countChars(String word, int[] freq) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            freq[ch - 'a']++;
        }
    }

    public boolean makeEqual(String[] words) {
        
        int[] freq = new int[26];
        int len = words.length;

        for (int i = 0; i < len ; i++) {
            countChars(words[i], freq);
        }

        for (int fre : freq) {
            if (fre % len != 0) {
                return false;
            }
        }

        return true;
    }
}