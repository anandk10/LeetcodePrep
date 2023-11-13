class Solution {

    List<List<Integer>> finalList;

    private void backtrack(final int[] nums, 
                            final int curr, 
                            final List<Integer> parentList) {

        // return if no more elements to process
        if (curr == nums.length) {
            // List<Integer> currentList = parentList.stream().collect(Collectors.toList());
            finalList.add(new ArrayList<>(parentList));
            // finalList.add(currentList);
            return;
        }

        List<Integer> currentList = parentList;
        // include element call
        currentList.add(nums[curr]);
        backtrack(nums, curr + 1, currentList);
        
        // Remove the last element from currentList
        currentList.remove(currentList.size() - 1);
        backtrack(nums, curr + 1, currentList);

    }

    public List<List<Integer>> subsets(int[] nums) {
        finalList = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());
        return finalList;
    }
}
