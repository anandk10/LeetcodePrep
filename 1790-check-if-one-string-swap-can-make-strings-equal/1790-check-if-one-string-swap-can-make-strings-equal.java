class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;  
        }

        // bank - 
        //    i
        // kanb
        // 
        // solution - 
        //        i
        // solntiou
        int[] indices = new int[2];

        int count = 0;
        for (int i = 0 ; i < s1.length(); i++) {

            if (s1.charAt(i) != s2.charAt(i)) {
                if (count == 2) return false;
                indices[count] = i;
                count += 1;
            }

        }


        return count == 0 || (s1.charAt(indices[0]) == s2.charAt(indices[1]) &&
            s1.charAt(indices[1]) == s2.charAt(indices[0]));
    }
}