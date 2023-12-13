class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        
        # [1,2,-3,4]
    
        # we maintain a curMin and curMax of the subarray that we are scanning until now
        # we maintain a curMin specifically to deal with negative values
        # an odd number of negative values will make the product minimum, however
        # and even number of negative values can make the product maximum
        
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
    

    
    
    
            
        