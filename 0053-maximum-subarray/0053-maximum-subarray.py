class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        currMax = nums[0];
        globalMax = nums[0]
        
        for i in range(1, len(nums)):
            if currMax < 0:
                currMax = 0
            currMax += nums[i]
            globalMax = max(globalMax, currMax)
        
        return globalMax
        