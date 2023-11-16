class Solution {
    public int myAtoi(String s) {

        int MAX_INT = Integer.MAX_VALUE;
        int MIN_INT = Integer.MIN_VALUE;

        // 1. whitespace
        // 2. +/-
        // 3. digits
        // 4. number should be between MAX_INT and MIN_INT
        // 5. letters

        // Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.

        // Ignore whitespace , and characters after the digits.
        // if characters are before digits, return 0;
        // no number - then return 0

        int res = 0;
        int negative = 1; // postive

        // 42
        //      -250
        //   +25
        //   
        int length = s.length();
        int i;

        for (i=0; i < length && s.charAt(i) == ' '; i++);

        if (i==length) {
            return res;
        }// reached end of string

        if (s.charAt(i) == '-') {
            negative = -1;
            i++;
        } else if(s.charAt(i) == '+') {
            i++;
        }

        // if (Character.isAlphabetic(s.charAt(i))) return res;

        for(; i < length; i++) {
            if (!Character.isDigit(s.charAt(i))) { break; }
            if (Character.isDigit(s.charAt(i))) {

                // res * 10 > MAX_INT // avoid
                // res * 10 - overflow
                // res = ....5
                // MAX_INT = ....7
                // MIN_INT = ....8
                // res = ....9, negative = -1
                if (res > MAX_INT / 10) {
                    if (negative == -1) { //negative ; MIN_INT
                        return MIN_INT;
                    } else {
                        // postive ; MAX_INT
                        return MAX_INT;
                    }
                } else if (res == MAX_INT / 10 && Character.getNumericValue(s.charAt(i)) > 7){
                    if (negative == -1) { //negative ; MIN_INT
                        return MIN_INT;
                    } else {
                        // postive ; MAX_INT
                        return MAX_INT;
                    }
                }

                res = res * 10 + Character.getNumericValue(s.charAt(i));
            }

        }

        return res * negative;

        
    }
}
