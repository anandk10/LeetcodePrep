class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;

        while (right < nums.length) {

            if (nums[right] != 0) {
                swap(nums, left, right);
                left += 1;
            }

            right += 1;

        }
    }

    private void swap(int[] nums, int left, int right) {
        if (left >= 0 && right < nums.length) {
            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
        }
    }
}