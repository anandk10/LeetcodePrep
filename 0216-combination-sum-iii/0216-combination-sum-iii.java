class Solution {

    /**
    
    Use backtracking
    The tricker here is to understand that
    - k is the bound of solution i.e. we are only allowed to choose k number of elements
    - we are not repeating numbers thus we will explicitly need to define a look
        unlike https://leetcode.com/problems/combination-sum
            where the same number was consider again in the recursion and 
            the next num was part of second recursive call

            thus forming the loop effect.
    - 
     */

    List<List<Integer>> result;
    int targetSum ;

    private void dfs(int i, int bound, int currSum, List<Integer> solution) {

        if (solution.size() == bound) {
            if (currSum == targetSum) {
                // found a solution
                result.add(new ArrayList<>(solution));
            }
            return;
        }

        while (i <= 9) {
            solution.add(i);
            dfs(i + 1, bound, currSum + i, solution);
            solution.remove(solution.size() - 1);
            i++;
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        targetSum = n;
        dfs(1, k, 0, new ArrayList<>());
        return result;
    }
}

/**
nums[i]=[1,2,3,4,5,6,7,8,9]
k = number of elements allowed to form the sum

 */