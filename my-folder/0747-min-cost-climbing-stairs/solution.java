class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] newCost = Arrays.copyOf(cost, cost.length + 1);
        
        int step1, step2;

        // can reach 1st step at index 0
        step1 = newCost[0];

        step2 = Math.min(newCost[1], newCost[1] + step1);

        if (cost.length == 2) {
            // if there are only two stairs
            // whichever yeilds minimum cost
            return Math.min(step1, step2);
        }

        for (int stair = 2; stair < newCost.length; stair++) {
            int tmp = step2;
            // min (current stair cost + cost of current - 1 step, current stair cost + cost of current - 2 steps)
            step2 = Math.min(newCost[stair] + step2, newCost[stair] + step1);
            step1 = tmp;
        }
        return step2;


    }
}
