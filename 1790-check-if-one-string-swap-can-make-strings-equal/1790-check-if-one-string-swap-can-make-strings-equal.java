class Solution {

    /**
    - Compare the lengths of s1 and s2, if unequal, return false.
    - Track the count of differing characters and their indices.
    - Iterate through each character index.
    - If characters at the same index are different:
    - If the count exceeds 2, return false.
    - Record the index of the differing characters.
    - Check if either there are no differences or exactly two differences with swapped characters.
    - Return true if conditions in step 5 are met, else return false.
     */
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;  
        }

        int count = 0;
        int index1 = -1; 
        int index2 = -1;
        
        for (int i = 0 ; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (count == 2) return false;
                if (count == 0) index1 = i;
                else index2 = i;
                count++;
            }
        }

        return count == 0 || (count == 2 && 
                              s1.charAt(index1) == s2.charAt(index2) &&
                              s1.charAt(index2) == s2.charAt(index1));
    }
}
