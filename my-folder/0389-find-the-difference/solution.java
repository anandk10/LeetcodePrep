class Solution {

    private char findThatDiff(String s, String t) {

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);
        
        int i = 0;
        for (char c : tArr) {
            if (i < sArr.length && c == sArr[i++]) {
                // good work, nothing to do
            } else {
                // either sArr is exhausted or we find inequality,
                // in either case, char c is the different one.
                return c;
            }
        }

        return ' ';
    }

    private char findThatDiffBitwise(String s, String t) {

        char ch = 0;

        // System.out.println(s + " becomes ");
        
        for (int i = 0; i < s.length(); i++) {
            ch ^= s.charAt(i);
            // System.out.println(ch);
        }

        
        System.out.println(t + " becomes ");
        for (int i = 0; i < t.length(); i++) {
            ch ^= t.charAt(i);
            // System.out.println(ch);
        }

        // System.out.println(ch);

        return ch;
    }

    public char findTheDifference(String s, String t) {
        // return findThatDiff(s, t);  
        return findThatDiffBitwise(s, t);  
    }
}
