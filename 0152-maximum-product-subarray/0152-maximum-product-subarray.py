class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = max(nums) # init with some value
        curMin, curMax = 1, 1
        
        
        for n in nums:
            # if num is 0, dont handle that and skip it
            if n == 0:
                curMin, curMax = 1, 1
                continue
                
            # n is +ve and curmax is +ve
            # n is -ve and curMin is -ve
            # or n itself
            tmp = n * curMax
            curMax = max(tmp, n * curMin, n) 
            curMin = min(tmp, n * curMin, n)  # [-1 , -8] = 8 but we need -8
            res = max(res, curMax, curMin)
        return res
            
        