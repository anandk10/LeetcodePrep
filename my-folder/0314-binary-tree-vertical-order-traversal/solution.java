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

    class TreeNodeAndIndex {
        TreeNode node;
        Integer bucketIdx;
        TreeNodeAndIndex(TreeNode node, Integer bucketIdx) {
            this.node = node;
            this.bucketIdx = bucketIdx;
        }

        public String toString() {
            return "[" + node.val + ", " + bucketIdx + "]";
        }
    }
    private Map<Integer, List<Integer>> bucketWithBFS(TreeNode root) {
        if (root == null) return Collections.EMPTY_MAP;
        Map<Integer, List<Integer>> buckets = new TreeMap<>();
        Queue<TreeNodeAndIndex> queue = new LinkedList<>();
        
        queue.offer(new TreeNodeAndIndex(root, 0));
        TreeNodeAndIndex tmp = null;
        while(!queue.isEmpty()) {
            
            while (!queue.isEmpty()) {
                tmp = queue.poll();

                buckets.computeIfAbsent(tmp.bucketIdx, 
                            idx -> new ArrayList<Integer>())
                       .add(tmp.node.val);

                if (tmp.node.left != null) {
                    queue.offer(new TreeNodeAndIndex(tmp.node.left, tmp.bucketIdx - 1));
                }
                if (tmp.node.right != null) {
                    queue.offer(new TreeNodeAndIndex(tmp.node.right, tmp.bucketIdx + 1));
                } 
            }
        }

        return buckets;
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> buckets = bucketWithBFS(root);
        return buckets.values().stream().collect(Collectors.toList());   
    }
}
