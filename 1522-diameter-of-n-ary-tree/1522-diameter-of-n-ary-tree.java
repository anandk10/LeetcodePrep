/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int diameter = 0;
    
    private int solution1(Node root) {
        if (root == null) return 0;
        
        // Even though it is N ary tree, the diameter only
        // considers the path with only two maximum heights
        // Therefore rather than storing all the heights 
        // and then focussing on the two max values
        // I'm maintaining two max variables instead
        int max1 = 0;
        int max2 = 0;
        
        for (Node child : root.children) {
            int depth = solution1(child);
            if (max1 < depth) {
                max2 = max1;
                max1 = depth;
            } else if (max2 < depth) {
                max2 = depth;
            }
        }
        
        // Same idea as computing diameter for binary tree
        // Look for the summation of max1 and max2 
        diameter = Math.max(diameter, max1 + max2);
        
        
        // Return the max height from either of the subtrees
        return 1 + Math.max(max1, max2);
        
    }
    
    public int diameter(Node root) {
        solution1(root);
        return diameter;
    }
}