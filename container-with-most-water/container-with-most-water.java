class Solution {

    private int compute(final int[] height) {
        int max = 0;
        int left = 0; // we are assured that height array will be minimum of 2 values
        int right = height.length - 1;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;
            max = Math.max(area, max);
            if (height[left] < height[right]) {
                left++;
            } else { // right pointers decrements if height[right] < height[left] or height[left] == height[right]
                right--;
            }

        }

        return max;
    }

    public int maxArea(int[] height) {
        return compute(height);
    }
}