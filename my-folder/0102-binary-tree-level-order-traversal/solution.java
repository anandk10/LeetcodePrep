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

    private List<List<Integer>> breadthFirstTraversal(final TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int currentQueueSize = queue.size();
            
            List<Integer> valuesToAdd = new ArrayList<>();
            while (currentQueueSize > 0) {
                currentQueueSize--;
                
                // remove from queue
                TreeNode tmp = queue.remove();
                // add the children to the queue
                if (tmp.left != null) 
                    queue.add(tmp.left);
                if (tmp.right != null)
                    queue.add(tmp.right);
                
                // add the values to the result
                valuesToAdd.add(tmp.val);
            }

            result.add(valuesToAdd);

        }
        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.add(root);
        // List<List<Integer>> result = new ArrayList<>();

        // while (!queue.isEmpty()) {
        //     int currentQueueSize = queue.size();
            
        //     List<Integer> valuesToAdd = new ArrayList<>();
        //     while (currentQueueSize > 0) {
        //         currentQueueSize--;
                
        //         // remove from queue
        //         TreeNode tmp = queue.remove();
        //         // add the children to the queue
        //         if (tmp.left != null) 
        //             queue.add(tmp.left);
        //         if (tmp.right != null)
        //             queue.add(tmp.right);
                
        //         // add the values to the result
        //         valuesToAdd.add(tmp.val);
        //     }

        //     result.add(valuesToAdd);

        // }
        // return result;
        if (root == null) return new ArrayList<>();
        return breadthFirstTraversal(root);

    }
}
