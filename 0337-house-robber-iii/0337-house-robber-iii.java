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
    
    // returns [robbed, not_robbed] value
    // for the robbed element consider summing up current node's val 
    // and its subtree's not_robbed value
    // for the not robbed calculation, sum up the robbed element from
    // its subtree return value
    private int[] dfs (final TreeNode root) {
        if (root == null) return new int[]{0, 0};
        
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        
        // rob the current node so add the not robbed parts of the subtree
        int robbedCurrVal = root.val + left[1] + right[1];

        // do not rob the current node, now think of what part of
        // 1. left subtree maximizes the profit? - including the child or excluding the child
        // i.e. left[0] or left[1] - which is max ?
        // 2. right subtree maximizes the profit? - including the child or excluding it
        // i.e. right[0] or right[1] - which is max ?
        // combine those two decisions and insert it as part of not robbed element
        // for the current node

        int notRobbedCurrVal = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[]{robbedCurrVal, notRobbedCurrVal};
    }
    
    public int rob(TreeNode root) {
        int[] robbery = dfs(root);
        return Math.max(robbery[0], robbery[1]);
    }
}