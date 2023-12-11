/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> result = new ArrayList<>();
        _serialize(root, result);
        return result.stream()
                     .collect(Collectors.joining(","));
    }

    private void _serialize(TreeNode root, List<String> result) {
        if (root == null) {
            result.add("N");
            return;
        }

        result.add(String.valueOf(root.val));
        _serialize(root.left, result);
        _serialize(root.right, result);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
        return _deserialize(queue);
    }

    private TreeNode _deserialize(Queue<String> queue) {
        if (queue.isEmpty()) return null;
        if (queue.peek().equals("N")) {
            queue.poll();
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(queue.poll()));
        node.left = _deserialize(queue);
        node.right = _deserialize(queue);
        return node;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));