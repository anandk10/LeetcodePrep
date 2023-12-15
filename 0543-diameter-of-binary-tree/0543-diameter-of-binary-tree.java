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
    
    int diameter = 0;
    
    private int solution1(TreeNode root) {
        if (root == null) 
            return 0;
        
        int leftHeight = solution1(root.left);
        int rightHeight = solution1(root.right);
        
        // if the current node is considered for splitting
        // then the diameter will be addition of left height 
        // and the right height
        diameter = Math.max(diameter, leftHeight + rightHeight);
        
        // however, the caller expects me to return the max
        // height because the caller node has considered itself 
        // as the splitting point in the tree.
        return 1 + Math.max(leftHeight, rightHeight);
        
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        solution1(root);
        return diameter;
        
    }
}