class Solution {
    public int myAtoi(String s) {
        
        // traverse the string s
        // if while space - ignore
        // if encounter negative - make note of it
        // for digits record it and multiply by 10 to get the result
        // res = 0;
        // 42 - 
        // 4
        // res = res * 10 + 4
        // res = 4

        // 2
        // res = res * 10 + 2
        // res = 4 * 10 + 2
        // res = 42
        // res > MAX_INT then return MAX_INT;
        // res < MIN_INT then return MIN_INT;


        // ignore the whitespace
        int n = s.length();

        if( n == 0 || s.trim().isEmpty()) return 0;
        
        int i = 0;
        for ( ;i < n && s.charAt(i) == ' '; i++) {}

        // now either it should be number or a sign indicator
        
        int sign = 1;

        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }


        // now its a chance for the digits
        int res = 0;
        for(; i < n ; i++) {

            if (Character.isDigit(s.charAt(i))) {

                // handling 2147483647 - edge
                // res = 2147483640 + 8

                // handle 21474836489999
                // res * 10 > MAX_VALUE - wont work because res * 10 itself will overflow
                
                if (res > Integer.MAX_VALUE / 10) {
                    // need to check the sign 
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                } else if (res == Integer.MAX_VALUE / 10 && Character.getNumericValue(s.charAt(i)) > 7) {
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE; 
                }
                // System.out.println(res);

                res = res * 10 + Character.getNumericValue(s.charAt(i));
            } else {
                break;
            }
        }
        System.out.println(Integer.MAX_VALUE);

        res = res * sign;
        return res;





    }
}