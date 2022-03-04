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
    public TreeNode sortedArrayToBST(int[] nums) {
        return convertToBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode convertToBST(int[] nums, int lower, int upper) {
        if (lower > upper) return null;
        
        int mid = lower + (upper - lower) / 2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convertToBST(nums, lower, mid - 1);
        root.right = convertToBST(nums, mid + 1, upper);
        return root;
    }
}
