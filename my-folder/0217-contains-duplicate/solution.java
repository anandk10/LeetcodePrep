class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> freq = new HashSet<Integer>();
        for (int i : nums) {
            freq.add(new Integer(i));
        }
        return freq.size() == nums.length ? false : true;
    }
}
