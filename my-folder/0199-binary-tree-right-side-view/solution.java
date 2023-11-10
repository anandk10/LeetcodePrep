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

    public List<Integer> breadthFirstTraverse(final TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        queue.add(root);

        

        while ( !queue.isEmpty() ) {

            int currentQueueSize = queue.size();
            int i = 0;
            while (i < currentQueueSize) {

                TreeNode tmp = queue.remove();
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }

                // first queue.remove() gurarantees that
                // its the element that can be seen from the right
                // its because, the approach to enqueue the elements is
                // enqueing the right most elements first
                if (i == 0) { // first element
                    result.add(tmp.val);
                }
                i++;
            }
        }

        return result;

    }


    public List<Integer> rightSideView(TreeNode root) {
        return breadthFirstTraverse(root);
    }
}
