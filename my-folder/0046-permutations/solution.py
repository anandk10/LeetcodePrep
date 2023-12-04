class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []

        #  base case
        if (len(nums) == 1):
            # return [nums.copy()]
            return [nums[:]]

        for i in range(len(nums)):
            n = nums.pop(0)
            # print("============"+str(i)+"===============")
            # print("Popped " + str(n))
            # print(nums)
            perms = self.permute(nums)
            # print("Permutations for " + str(n))
            # print(perms)

            for perm in perms:
                perm.append(n)
            
            # print("Appending the " + str(n))   
            nums.append(n)
            # print(nums)
            result.extend(perms)
            # print("============"+str(i)+"===============")
        
        return result

