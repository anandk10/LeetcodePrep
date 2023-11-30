class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        /**
            "internationalization"
                          p
            "i12iz4n" 
                q

            substitutioiwwwwwww
                        p
            s11stitution
               q
        

            "apple"
                p
            "a2e"
               q
         */


        // unequal
         // both characters 
         // leading 0 return false
         // number > length of word

        if (word.length() < abbr.length()) return false;

        int p = 0;
        int q = 0;

        while (p < word.length() && q < abbr.length()){

            char wordChar = word.charAt(p);
            char abbrChar = abbr.charAt(q);

            if (wordChar != abbrChar && 
                (!Character.isDigit(abbrChar) || abbrChar == '0') ) {
                return false;
            }

            int res = 0;

            
            while (q < abbr.length() && Character.isDigit(abbr.charAt(q))) {
                res = res * 10 + Character.getNumericValue(abbr.charAt(q));
                q++;
                // abbrChar = abbr.charAt(q);
            }

            if (res == 0) {
                p++; q++;
            } else {
                p += res;
            }
            
        }

        return p == word.length() && q == abbr.length();

    }
}
