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


    private int height(final TreeNode root) {

        if (root == null) return 0;
        
        int left = height(root.left);

        int right = height(root.right);

        if (left == -1 || right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;

    }

    public boolean isBalanced(TreeNode root) {
        // A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
        return height(root) != -1;
    }
}
