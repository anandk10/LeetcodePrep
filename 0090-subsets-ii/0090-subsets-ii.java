class Solution {

    //             1,2,2. ----- sorted O(n.log n)
    //             /   \
    //         [1]        []
    //    2,2  /. \         /  \
    //       [1,2]    [1]  [2]  []
    //   2  /.   \.        /  \
    //   [1,2,2] [1,2]   [2,2] [2]

    //     1,2,3

    //     O(N.2^N)

    List<List<Integer>> finalSolution;

    private void backtrack(final int[] nums, int curr, List<Integer> solution) {

        // base condition
        if (curr == nums.length) { // single element
            // System.out.println("Solution: " + solution + " finalSolution : " + finalSolution );
            finalSolution.add(new ArrayList<>(solution));
            // System.out.println("Solution: " + solution + " finalSolution : " + finalSolution );
            return;
        }
        // include
        solution.add(nums[curr]);
        
        backtrack(nums, curr + 1, solution);

        // exclude
        solution.remove(solution.size() - 1);

        // [2,2]
        
        // for (; curr + 1 < nums.length && nums[curr] == nums[curr + 1]; curr++);
        while (curr < nums.length - 1 && nums[curr] == nums[curr + 1]) {
            curr++;
        }

        backtrack(nums, curr + 1, solution);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {    

        finalSolution = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return finalSolution;
    }
}