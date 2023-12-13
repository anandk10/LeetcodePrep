class Solution:
    def maxProduct(self, nums: List[int]) -> int:
    #         we maintain a curMin and curMax of the subarray that we are scanning until now
    #         we maintain a curMin specifically to deal with negative values
    #         an odd number of negative values will make the product minimum, however
    #         and even number of negative values can make the product maximum

    #         [1,2,-3,4] -5
    #         res = 4
    #         curMin = 1, curMax = 1
    #         n=1 ; tmp = 1 * 1 = 1
    #             max(tmp, n * curMin, n)
    #             min(1, 1, 1) - 1
    #             curMax=1

    #             min(tmp, n*curMin, n)
    #             curMin = 1

    #             res = max(1,1,1) = 1

    #         n = 2
    #             max(2 * 1, 1, 2) = 2
    #             curMax = 2
    #             min(2 * 1, 1, 1) = 1
    #             curMin = 1
    #             res = max(2,1,1) = 2

    #         n = -3
    #             max(-3 * 2, -3 * 1, -3)
    #             max(-6, -3, -3) = -3
    #             curMax = -3

    #             min(-3 * 2, -3 * 1, -3)
    #             min(-6, -3, -3) = -6
    #             curMin = -6

    #             res = max(-3, -6, 2) = 2

    #         n = 4
    #             max(-3 * 4, -6 * 4, 4) = (-12, -24, 4) = 4
    #             curMax = 4


    #             min(-3 * 4, -6 * 4, 4) = (-12, -24, 4) = -24
    #             curMin = -24

    #             res = max(4, -24, 2) = 4

    #         n = -5
    #             max(4 * -5, -24 * -5, -5) = (-20, 120, -5) = 120
    #             curMax = 120

    #             min(4 * -5, -24 * -5, -5) = (-20, 120, -5) = -20
    #             curMin = -20

    #             res = max(120, -20, 4) = 120
            
        
        
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
    

    
    
    
            
        