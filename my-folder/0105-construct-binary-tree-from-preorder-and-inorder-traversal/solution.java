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
    // Keeps track of the value in preorder array to be processed next
    int preIndex = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return buildTree(preorder, inorder, 0, inorder.length-1);
    }
    
    private TreeNode buildTree(final int[] preorder, final int[] inorder, final int lower, final int upper) {
        // Base condition
        if (preIndex >= preorder.length || lower > upper) return null;
        
        // Get root value from preorder traversal
        int rootVal = preorder[preIndex++];
        
        // Search that value in inorder traversal
        int rootValIndex = searchInorder(rootVal, inorder, lower, upper);
        
        // Simple error handling if search were to fail
        if (rootValIndex == Integer.MAX_VALUE) return null;
        
        // Now that we have the rootVal present in inorder
        // we build a TreeNode
        TreeNode root = new TreeNode(rootVal, null, null);
        
        // Repeat the process for left sub array
        root.left = buildTree(preorder, inorder, lower, rootValIndex-1);
        
        // Repear the process for right sub array
        root.right = buildTree(preorder, inorder, rootValIndex+1, upper);
        
        // Finally return the root.
        return root;
    }
    
    private int searchInorder(final int searchVal, final int[] inorder, final int lower, final int upper) {

        for(int i=lower ; i <= upper; i++) {
            if(searchVal == inorder[i]) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }
}
