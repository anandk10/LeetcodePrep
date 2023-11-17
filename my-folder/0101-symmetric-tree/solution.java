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

    // private void lvr(TreeNode root, List<Integer> values) {
    //     if (root == null) { return; }
    //     lvr(root.left, values);
    //     values.add(root.val);
    //     lvr(root.right, values);
    // }

    // private void rvl(TreeNode root, List<Integer> values) {
    //     if (root == null) { return; }

    //     rvl(root.right, values);
    //     if (values.get(0) == root.val) {
    //         values.remove(0);
    //     }
    //     rvl(root.left, values);
    // }


    public boolean isMirror(TreeNode root1, TreeNode root2) {
        // is both root node are null then mirror
        if (root1 == null && root2 == null) return true;

        // if either of the root's are non null that is 
        // asymmetrical
        if (root1 == null || root2 == null) return false;

        // if values are unequal
        if (root1.val != root2.val) return false;

        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
}
