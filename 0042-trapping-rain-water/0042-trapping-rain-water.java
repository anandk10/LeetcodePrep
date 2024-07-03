class Solution {
    public int trap(int[] height) {

      if (height.length == 0)
        return 0;

      // # The time complexity is O(N)
      // # Space complexity is O(1)

      // # another solution which also needs O(N) TC and O(N) SC
      // # where we prefix compute the max heights on the left boundaries
      // # and postfix compute the max height on the right boundaries
      // # and then compute min(leftMax, rightMax) - height[i]

      int left = 0;
      int right = height.length - 1;
      int res = 0;

      int leftMax = height[left];
      int rightMax = height[right];

      // This also works even when the heights array will be something like this:
      // [0,1,0]
      //  l   r (leftMax = 0, rightMax = 0, res = 0)
      //  l r   (leftMax = 0, rightMax = 1, res = 0)
      //    lr   (leftMax = 1, rightMax = 1, res = 0)

      while (left < right) {
        if(leftMax < rightMax) {
          left += 1;
          leftMax = Math.max(leftMax, height[left]);
          res += leftMax - height[left];

        } else {
          right -= 1;
          rightMax = Math.max(rightMax, height[right]);
          res += rightMax - height[right];
        }
      }

      return res;
    }
}