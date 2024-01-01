class Solution {
    /**
    The trick is to invert the numbers to its occurring index.
    So, formulate
    1 -> 0,3,4
    2 -> 1,2

    that says, number 1 occurs at 0th, 3rd, 4th index
    number 2 occurs at 1st and 2nd index

    now randomly choose the index (careful you'll be choosing the index
    of the list [0,3,4] which will be bounded by 0-2)
    based on this index get the actual nums index from the list

    Use Random random = new Random();
    random.nextInt(upperBound);
     */
    Map<Integer, List<Integer>> inverseNums;
    static Random random = new Random();

    public Solution(int[] nums) {
       inverseNums = new HashMap<>();

       for (int i = 0; i < nums.length; i++) {
           inverseNums.computeIfAbsent(nums[i], num -> new ArrayList<>())
                                .add(i);
       }
    }
    
    public int pick(int target) {
        List<Integer> indices = inverseNums.get(target);
        // this will return the a number index
        // random.nextInt(indices.size());
        // of the list , NOT the actual index of the nums's ith index
        return indices.get(random.nextInt(indices.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */