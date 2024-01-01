class Solution {

    /**
    WRONG assumption
    String -> number - atoi function

    res = res * 10 + digit
     */

    // private int atoi(String num) {

    //     int res = 0;
    //     int i = 0;
    //     while (i < num.length()) {
    //         // scan every character and convert it into a number
    //         res = res * 10 + (num.charAt(i) - '0');
    //         //Character.getNumericValue(num.charAt(i));
    //         i++;
    //     }
    //     return res;
    // }

    /**
             i 
             11
            222
             j

             33

        merging of linked list with node that contains values...

            
     */




    public String addStrings(String num1, String num2) {

        char[] num1Arr = num1.toCharArray();
        char[] num2Arr = num2.toCharArray();

        int i = num1Arr.length - 1;
        int j = num2Arr.length - 1;

        StringBuilder res = new StringBuilder();

        int carry = 0;

        while (i >=0 && j >= 0) {
            int sum = carry + (num1Arr[i] - '0') + (num2Arr[j] - '0');
            carry = sum / 10;
            res.append(sum % 10);
            i--;
            j--;
        }

        // process remaining num1Arr 
        while (i >= 0) {
            int sum = carry + (num1Arr[i] - '0');
            carry = sum / 10;
            res.append(sum % 10);
            i--;
        }

        // processing remaining num2Arr
        while (j >= 0) {
            int sum = carry + (num2Arr[j] - '0');
            carry = sum / 10;
            res.append(sum % 10);
            j--;
        }

        // finally process carry if non zero
        if (carry != 0)
            res.append(carry);
        
        return res.reverse().toString();

    }
}