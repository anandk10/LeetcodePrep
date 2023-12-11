class Solution {
    public boolean isPalindrome(String s) {

        // Solution 1: String -> lowercase -> character array
        // String lowerS = s.toLowerCase();
        // char[] lowerCharS = lowerS.toCharArray();
        // Init pointers
        // int i = 0, j = lowerCharS.length - 1;
        // Predicate<Character> isAlphanumeric = 
            // c -> Character.isAlphabetic(c) || Character.isDigit(c) ;
        
        // for (; i <= j; i++, j--) {

        //     if (i == j) return true;

        //     // move pointers until alphanumeric character is found
            
        //     // while (i <= j && !isAlphanumeric.test(lowerCharS[i])) i++;
        //     // while (i <= j && !isAlphanumeric.test(lowerCharS[j])) j--;
        //     while (i <= j && !Character.isLetterOrDigit(lowerCharS[i])) i++;
        //     while (i <= j && !Character.isLetterOrDigit(lowerCharS[j])) j--;
            
        //     if (i <= j && lowerCharS[i] != lowerCharS[j]) return false;
            
        // }
        // return true;

        // Solution 2: Use Character.toLowerCase, and s.charAt()
        // Init pointers
        int i = 0, j = s.length() - 1;

        for (; i <= j ; i++, j--) {
            if (i == j) return true;

            while (i <= j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i <= j && !Character.isLetterOrDigit(s.charAt(j))) j--;

            if (i <= j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }

        return true;
    }
}