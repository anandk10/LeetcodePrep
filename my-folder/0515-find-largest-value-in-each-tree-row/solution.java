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

import java.util.*;
import java.util.stream.Stream;


class Solution {
        public List<Integer> largestValues(TreeNode root) {

        List<Integer> values = new ArrayList<>();

        if (root == null)
            return values;

        LinkedList<TreeNode> priorLevel = new LinkedList();
        priorLevel.add(root);
        while (!priorLevel.isEmpty()) {
            values.add(getQueueMax(priorLevel));
            LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
            priorLevel.stream()
                    .forEach(node -> {
                        if (node.left!=null)
                            nextLevel.add(node.left);
                        if (node.right!=null)
                            nextLevel.add(node.right);
                    });
            priorLevel = nextLevel;
        }
        
        return values;
    }
    
    private Integer getQueueMax(LinkedList<TreeNode> q) {

        Optional<Integer> max = q.stream().flatMap(node -> Stream.of(node.val))
                .max(Integer::compareTo);
        return  max.get();

    }
}
