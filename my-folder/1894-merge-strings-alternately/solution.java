class Solution {

    public String mergeAlternately(String word1, String word2) {
        
        int i = 0; // word1 
        int j = 0; // word2

        int len1 = word1.length();
        int len2 = word2.length();

        char[] answer = new char[len1 + len2];
        int k = 0;

        while (i < len1 && j < len2) {
            answer[k++] = word1.charAt(i);
            answer[k++] = word2.charAt(j);
            i++; j++;
        }

        // word1 is remaining
        while (i < len1) {
            answer[k++] = word1.charAt(i++);
        }

        // word2 is remaining
        while(j < len2) {
            answer[k++] = word2.charAt(j++);
        }
        
        return new String(answer);
    }
}
