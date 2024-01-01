class Solution {
    /**
        traverse both the strings from right to left 

            while (i >= 0 && j >= 0);

        traverse first

            while(i>=0);

        traverse second

            while (j >= 0);

        finally append carry if non zero
        
        COMMON LOGIC:
            add carry to the sum, 
            carry = sum / 10 
            rem = sum % 10

            res.append(res)
        

        SIMILAR to a problem where two linked lists are supposed to be added
        the linked list nodes are digits 
        the expected output is to produce a summation of two numbers


             i 
             11
            222
             j

             33

        merging of linked list with node that contains values... 
     */


    public String addStrings(String num1, String num2) {

        int i = num1.length() - 1; 
        int j = num2.length() - 1;

        StringBuilder res = new StringBuilder();

        int carry = 0;

        while (i >=0 && j >= 0) {
            
            
            int sum = carry + (num1.charAt(i) - '0') + (num2.charAt(j) - '0');
            carry = sum / 10;
            res.append(sum % 10);
            i--;
            j--;
        }

        // process remaining num1Arr 
        while (i >= 0) {
            int sum = carry + (num1.charAt(i) - '0');
            carry = sum / 10;
            res.append(sum % 10);
            i--;
        }

        // processing remaining num2Arr
        while (j >= 0) {
            int sum = carry + (num2.charAt(j) - '0');
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