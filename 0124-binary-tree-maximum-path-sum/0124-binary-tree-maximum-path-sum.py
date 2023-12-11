# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        res = [root.val]

        # return max path without splitting
        def dfs(root):
            if not root:
                return 0

            leftMax = dfs(root.left)
            rightMax = dfs(root.right)

            leftMax = max(leftMax, 0) # insulation against negative in the left subtree path
            rightMax = max(rightMax, 0) # insulation against negative in the right subtree path

            # compute max path sum WITH split
            res[0] = max(leftMax + rightMax + root.val, res[0])

            return max(leftMax, rightMax) + root.val
        
        dfs(root)
        return res[0]
            
        