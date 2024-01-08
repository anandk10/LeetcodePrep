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

    private int solution1(TreeNode root, int low, int high) {
        if (root == null) { return 0; }

        int currSum = 0;

        if (low <= root.val && root.val <= high) {
            currSum += root.val;
        }

        return currSum + 
                        solution1(root.left, low, high)
                        +
                        solution1(root.right, low, high);

    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        return solution1(root, low, high);
    }
}