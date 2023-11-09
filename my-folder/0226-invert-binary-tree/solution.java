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

    private static void preorder(final TreeNode root) {
        if( root == null ) return ;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        preorder(root.left);
        preorder(root.right);

    }

    public TreeNode invertTree(TreeNode root) {
        preorder(root);
        return root;
    }
}
