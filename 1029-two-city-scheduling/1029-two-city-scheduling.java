class Solution {

    /**
    The intuition is to be a little greedy about solving it

    prefer city A to all candidates , and calculate the delta
    i.e. what's the profit of sending a person to city A over city B

    then sort this delta array values and treat the second half to 
    send to city A, and the first half sending to city B.


    
     */
    public int twoCitySchedCost(int[][] costs) {

        int[][] preferCityA = new int[costs.length][3];

        for (int i = 0 ; i < costs.length ; i++) {
            preferCityA[i][0] = 
                    - costs[i][0] // paying for city A so minus
                    + costs[i][1]; // saving for city B so plus
            preferCityA[i][1] = costs[i][0];
            preferCityA[i][2] = costs[i][1]; // keep original values as is
        }

        // sort the preferCityA array ascending - so the max profit
        // by sending to city A will be at the end
        // 0th index contains the profit we could gain from choosing city A
        Arrays.sort(preferCityA, (a, b) -> (a[0] - b[0]));

        int res = 0;

        // iterate through the array preferCity
        for(int i = 0; i < preferCityA.length; i++) {

            if (i < preferCityA.length / 2) {
                // this half will be city B
                // preferCityA[i][0] is the delta value
                res = res + preferCityA[i][2]; // city B 
            } else {
                // preferCityA[i][0] is the delta value
                res = res + preferCityA[i][1]; // city A

            }
        }


        return res;
        
    }
}

