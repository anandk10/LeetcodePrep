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
    
    
    /**
    The idea here is to perform a BFS traversal (Queue) 
    and use a Map (TreeMap) for bucketing nodes from each level
    
    Queue should accept a pair of TreeNode and the index
    
    going to the left means idx - 1
    
    going to the right means idx + 1
    
    finally TreeMap values are the answer
    
    T - O(N log N) due to sorted nature of TreeMap
    S - O(N)
    
    */
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        return getBuckets(root);
    }
    
    
    class TreeNodeAndIndex {
        TreeNode node;
        int bucketIdx;
        TreeNodeAndIndex(TreeNode node, int bucketIdx) {
            this.node = node;
            this.bucketIdx = bucketIdx;
        }
    }
    
    private List<List<Integer>> getBuckets(final TreeNode node) {
        if (node == null) return Collections.EMPTY_LIST;
        
        Map<Integer, List<Integer>> buckets = new TreeMap<>();
        Queue<TreeNodeAndIndex> queue = new LinkedList<>();
        
        // push the root node
        queue.offer(new TreeNodeAndIndex(node, 0));
        
        while (!queue.isEmpty()) {
            
            TreeNodeAndIndex tmp = queue.poll();
            int bucketIdx = tmp.bucketIdx;
            TreeNode tmpNode = tmp.node;
            
            // set the values for the bucket
            buckets.computeIfAbsent(bucketIdx, idx -> new ArrayList<>()).add(tmpNode.val);
            
            // offer the left child if present
            if (tmpNode.left != null) {
                queue.offer(new TreeNodeAndIndex(tmpNode.left, bucketIdx - 1));
            }

            // offer the right child if present
            if (tmpNode.right != null) {
                queue.offer(new TreeNodeAndIndex(tmpNode.right, bucketIdx + 1));
            }
        }
        
        return buckets.values().stream().collect(Collectors.toList());
    }
    
}