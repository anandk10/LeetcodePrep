/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    /**
    the ask is to find all the nodes that are at k distance from 
    the given target node. For a tree, navigating to a parent is
    not straightforward, so instead build a sort of graph where
    for a target node its easier to pick its parent.

    And then perform a BFS with this lookup information. 
     */
    
    private void formParentMap(TreeNode root, TreeNode parentNode, Map<Integer, TreeNode> parentMap) {
        if (root == null) {
            return;
        }

        parentMap.put(root.val, parentNode);
        formParentMap(root.left, root, parentMap);
        formParentMap(root.right, root, parentMap);
    }

    private List<Integer> bfs(TreeNode target, Map<Integer, TreeNode> parentMap, int k) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        List<Integer> kthValues = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        while (!q.isEmpty()) {
            
            int size = q.size();
            while (size > 0) {
                TreeNode node = q.poll();
                visited.add(node.val);
                size--;

                if (k > 0) {
                    // queue the next level because k > 0
                    if (node.left != null && !visited.contains(node.left.val)) {
                        q.offer(node.left);
                    }

                    if (node.right != null && !visited.contains(node.right.val)) {
                        q.offer(node.right);
                    }

                    TreeNode parentNode = parentMap.get(node.val);
                    if (parentNode != null && !visited.contains(parentNode.val)) {
                        q.offer(parentNode);
                    }

                    
                } else {
                    // reached the kth level, so add the node to result
                    kthValues.add(node.val);
                }

            }
            // processed a level
            k--;
        }

        return kthValues;


    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<Integer, TreeNode> parentMap = new HashMap<>();
        formParentMap(root, null, parentMap);

        return bfs(target, parentMap, k);
        
    }
}