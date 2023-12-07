class Solution:
    def trap(self, height: List[int]) -> int:

      if not height:
        return 0

      # The time complexity is O(N)
      # Space complexity is O(1)

      # another solution which also needs O(N) TC and O(N) SC
      # where we prefix compute the max heights on the left boundaries
      # and postfix compute the max height on the right boundaries
      # and then compute min(leftMax, rightMax) - height[i]

      # Writing the optimal solution to apply what needcode taught
      # trapping water cares about what the min height out of the 
      # left and right max heights.
      # we would focus on that


      # we would start with two pointer technique
      left, right = 0, len(height) - 1
      leftMax = height[left]
      rightMax = height[right]

      res = 0


      # // This also works even when the heights array will be something like this:
      # // [0,1,0]
      # //  l   r (leftMax = 0, rightMax = 0, res = 0)
      # //  l r   (leftMax = 0, rightMax = 1, res = 0)
      # //    lr   (leftMax = 1, rightMax = 1, res = 0)
      while left < right:
        if leftMax < rightMax:
          # increment the left pointer
          left += 1
          leftMax = max(leftMax, height[left])
          res += leftMax - height[left]
          
        else:
          # decrement the right pointer
          right -= 1
          rightMax = max(rightMax, height[right])
          res += rightMax - height[right]
          
      return res

        
