class Solution {

    List<List<Integer>> finalSolution;
    int numsSize;

    private void backtrack(Map<Integer, Integer> counts, List<Integer> solution) {

        if (solution.size() == numsSize) {
            finalSolution.add(new ArrayList<>(solution));
            return;
        }

        for (int key : counts.keySet()) {

            if (counts.get(key) == 0) {
                continue;
            }

            counts.put(key, counts.get(key) - 1);
            solution.add(key);

            backtrack(counts, solution);

            counts.put(key, counts.get(key) + 1);
            solution.remove(solution.size() - 1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        finalSolution = new ArrayList<>();
        numsSize = nums.length;

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        backtrack(counts, new ArrayList<Integer>());

        return finalSolution;
    }
}
