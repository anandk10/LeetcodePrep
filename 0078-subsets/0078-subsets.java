class Solution {

    /**
    
    Every index of nums, gives two choices
        to include - add to solution
        to exclude - skip/remove from solution

        and then call dfs again, to consider rest of the elements
     */

    List<List<Integer>> result;

    private void dfs(int curr, int[] nums, List<Integer> solution) {

        // base case
        if (curr == nums.length) {
            result.add(new ArrayList<>(solution));
            return;
        }

        // either add this number to the list, 
        // because first choice is to include this number
        solution.add(nums[curr]);

        // with this number added, call dfs to consider rest of the elements
        dfs(curr + 1, nums, solution);

        // or don't add this number to the list, 
        // because the second choice to exclude this number
        // solution.remove(solution.size() - 1);
        solution.removeLast();
        
        // with this number excluded, call dfs to consider rest of the elements
        dfs(curr + 1, nums, solution);
    }

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();

        // dfs(0, nums, new ArrayList<>());
        dfs(0, nums, new LinkedList<>());
        return result;
        
    }
}