class Solution {

    /**
    Motivation: This calls for a windowing approach
    Focus: Keep an eye out for the contraints 
            where in the window we would want to satisfy
            that the character count from t is exactly a match
            with the character cound in s.

    So utilize something called as "have" vs "need" maps

    need map tells how many count of character are there in t.
    have map will keep a track of count of characters we see in s.
     */


    private String findMinimumWindowSubstring(final String s, final String t) {

        // s = "ADOBECODEBANC", t = "ABC"
        //       [   ]

        // if(t.trim().isEmpty()) return "";

        int left = 0, right = 0;
        int finalLeft = 0, finalRight = -1;
        int windowSize = Integer.MAX_VALUE;

        Map<Character, Integer> haveChars = new HashMap<>();
        Map<Character, Integer> needChars = new HashMap<>();
        
        for (char sChar : t.toCharArray()) {
            needChars.put(sChar, needChars.getOrDefault(sChar, 0) + 1);
        }

        int haveCount = 0;
        // unique characters in t
        int needCount = needChars.size(); 

        while (right < s.length()) {

            char currChar = s.charAt(right);
            haveChars.put(currChar, 1 + haveChars.getOrDefault(currChar, 0));

            if (needChars.containsKey(currChar) && 
                haveChars.get(currChar).intValue() == (int) needChars.get(currChar)) {
                    haveCount++;
                // System.out.println("Have count " + haveCount + " Need count " + needCount);
            }

            

            // found a window that has all the character with the right counters 
            // now shrink the window
            while (haveCount == needCount) {
                    
                if (windowSize > (right - left + 1)) {
                    // found a new min window
                    windowSize = right - left + 1;
                    finalLeft = left;
                    finalRight = right;
                }

                currChar = s.charAt(left);
                haveChars.put(currChar, haveChars.get(currChar) - 1);

                // does removing the currChar actually impact and is the count less then what we need
                if (needChars.containsKey(currChar) && haveChars.get(currChar) < needChars.get(currChar)) {
                    haveCount--;
                }
                left += 1;

            }

            right += 1;

        }

        return s.substring(finalLeft, finalRight + 1);
    }

    public String minWindow(String s, String t) {
        return findMinimumWindowSubstring(s, t);
        
    }
}