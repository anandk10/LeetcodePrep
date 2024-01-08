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

    private int rangeSum(TreeNode root, int low, int high) {
        if (root == null) { return 0; }

        if (root.val < low) {
            // current node val is out of the low range
            // so dont explore left any more
            // go to the right
            return rangeSum(root.right, low, high);
        }

        if (root.val > high) {
            // current node val is out of the high range
            // so dont explore right any more
            // go to the left
            return rangeSum(root.left, low, high);
        }

        return root.val + rangeSum(root.left, low, high) + rangeSum(root.right, low, high);
    }

    // private int rangeSum(TreeNode root, int low, int high) {
    //     // Alternate Solution


    //     int currSum = 0;

    //     if (low <= root.val && root.val <= high) {
    //         currSum += root.val;
    //     }

    //     return currSum 
    //             + rangeSum(root.left, low, high)
    //             + rangeSum(root.right, low, high);
    // }

    public int rangeSumBST(TreeNode root, int low, int high) {
        return rangeSum(root, low, high);
    }
}