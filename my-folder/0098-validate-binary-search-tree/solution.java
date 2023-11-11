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

    // private boolean _isValidBST(final TreeNode root) {
    //     // Empty tree or Tree with only leaf node - true
    //     if (root == null || (root.left == null && root.right == null )) return true;

    //     // if left node exists and left.val > root.val return false
    //     if (root.left != null && root.left.val >= root.val) return false;

    //     // if right node exists and right.val < root.val
    //     if (root.right != null && root.right.val <= root.val) return false;

    //     // Check for both subtrees
    //     return isValidBST(root.left) && isValidBST(root.right);

    // }

    private TreeNode lastNode = null;

    private boolean _isValidBST(final TreeNode root) {

        if (root == null) return true;

        if (root.left == null && root.right == null ) {
            if (lastNode == null || root.val > lastNode.val) {
                lastNode = root;
                return true;
            } 
            return false;
        }
        boolean left = _isValidBST(root.left);

        if (lastNode == null || root.val > lastNode.val) {
            lastNode = root;
        } else {
            return false;
        }

        boolean right = _isValidBST(root.right);

        return left && right; 
    }

    public boolean isValidBST(TreeNode root) {
        return _isValidBST(root);
    }
}
