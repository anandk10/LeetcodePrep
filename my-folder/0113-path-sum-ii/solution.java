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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        
        List<Integer> currentPath = new ArrayList<Integer>();
        
        findPaths(root, targetSum, currentPath, paths);
        
        return paths;
        
    }
    
    public void findPaths(TreeNode root, int targetSum, List<Integer> currentPath, List<List<Integer>> paths) {
        
        // 1. base case of recursion
        if (root == null) return;
        
        currentPath.add(root.val);
        
        // check if this is a leaf node and it adds up to the targetSum
        if (root.left == null && root.right == null && root.val == targetSum) {
            paths.add(currentPath); return;
        }
        
        findPaths(root.left, targetSum - root.val, new ArrayList<Integer>(currentPath), paths);
        findPaths(root.right, targetSum - root.val, new ArrayList<Integer>(currentPath), paths);
        
    }
}
