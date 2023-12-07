class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
      # store the nums as set
      numSet = set(nums)
      longest = 0

      for n in nums:
        # check if n is start of sequence
                                # [100,4,200,1,3,2]
        if (n - 1) not in numSet: # 99 wasn't there so start from 100
          length = 1            # count the 100
          while (n + length) in numSet: # add the length i.e. 100 + 1 = 101
            length += 1         # increment length
          longest = max(longest, length)

      return longest
          
        
