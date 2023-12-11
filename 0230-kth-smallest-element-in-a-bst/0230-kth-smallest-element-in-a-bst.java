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
    
    
    public int kthSmallest(TreeNode root, int k) {
        // List<Integer> inorderList = new ArrayList<>(k);
        // inorder(root, inorderList , k);
        // return inorderList.get(k-1);

        return iterativeTraverse(root, k);
        
    }


    private int iterativeTraverse(final TreeNode root, int k) {

        if (root == null) return Integer.MIN_VALUE;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        int count = 0;
        while(tmp != null || !stack.isEmpty()) {

            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }

            tmp = stack.pop();
            count++;

            if (k == count) {
                return tmp.val;
            }

            tmp = tmp.right;
            
        }
        return -1;
    }

    
    private void inorder(TreeNode root, List<Integer> inorderList, int k) {
        if (root == null) return;
        if (inorderList.size() == k) return;
        inorder(root.left, inorderList, k);
        inorderList.add(root.val);
        inorder(root.right, inorderList, k);
    }
    
    
    
    
}