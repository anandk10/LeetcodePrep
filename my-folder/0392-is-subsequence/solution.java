class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0, j=0;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        while (i < sArray.length && j < tArray.length) {
            if (sArray[i] == tArray[j]) i++;
            j++;
        }
        return i == sArray.length;
    }
}
