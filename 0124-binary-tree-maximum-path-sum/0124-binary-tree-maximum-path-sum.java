/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int res;
    private int dfs(TreeNode root) {
        if (root == null) return 0;

        // max path sum w/o splitting
        var leftMax = dfs(root.left);
        var rightMax = dfs(root.right);

        // we dont need to consider the negative values
        // insulate against the negative values
        leftMax = Math.max(leftMax, 0);  
        rightMax = Math.max(rightMax, 0);

        // let compute the max path sum WITH splitting
        var currMax = root.val + leftMax + rightMax;
        res = Math.max(currMax, res);

        // now return the max path sum WITHOUT splitting
        // the caller expects this value
        // because the caller node is already a split point
        // and we can split again

        return Math.max(leftMax, rightMax) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        res = root.val;
        dfs(root);
        return res;
    }
}