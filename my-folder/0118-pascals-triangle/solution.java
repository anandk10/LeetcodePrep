import java.io.*;

class Solution {


    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        PrintStream out = System.out;


        // DP 
        // Base cases:
        /**
        if n == 1 then [1]
        if n == 2 then [1,1]
        if n > 2
            scan result[i-1] for the intervals and sum the adjacent
            result.get(i).add(result.get(i-1).get(1) + result.get(i-1).get(2));
         */

        result.add(Arrays.asList(1));
        if (numRows == 1) {
            return result;
        }

        result.add(Arrays.asList(1,1));
        if (numRows == 2) {
            return result;
        }
        
        if (numRows > 2) {
            
            for (int i = 2; i < numRows; i++) {
                List<Integer> currList = new ArrayList<>();
                currList.add(1);
                for (int j = 0; (j + 1) < result.get(i-1).size(); j++) {
                    int prevSum = (result.get(i-1).get(j) + result.get(i-1).get(j + 1));
                    currList.add(prevSum);
                }
                currList.add(1);
                result.add(currList);
            }
        }
        return result;
    }
}
