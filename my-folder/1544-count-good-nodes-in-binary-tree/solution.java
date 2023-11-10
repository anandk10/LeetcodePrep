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

    int goodNodeCount = 0;

    private void _goodNodes(final TreeNode root, int currentMax) {

        if (root == null) 
            return;
        if (root.val >= currentMax) 
            goodNodeCount++;
        
        _goodNodes(root.left, Math.max(currentMax, root.val));
        _goodNodes(root.right, Math.max(currentMax, root.val));

    }
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        _goodNodes(root, root.val);
        return goodNodeCount;
    }
}
