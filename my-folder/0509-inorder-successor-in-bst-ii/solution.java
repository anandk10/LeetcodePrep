/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        // successor in a BST is a node whose value would be greater than the current node 
        if (node == null) return node;
        Node temp = node;
        
        // check if the right subtree could be explored
        if (temp.right != null) {
            // System.out.println("> " + temp.val);
            temp = temp.right;
            // keep going to the left until we hit terminal node
            while (temp.left != null) { 
                // System.out.println(temp.val + " < "); 
                temp = temp.left; 
            }
            return temp;
        }

        // by this time you reach a node that is the left most node that doesn't
        if (node.val < temp.val) {
            return temp;
        }

        // no right tree exists/ is explored, it's possible that
        // the parent or some node in the parent path is the inorder
        // successor
        // immediate parent is not the inorder successor, so keep going up
        while (temp.parent != null && temp.val > temp.parent.val) {
            temp = temp.parent;
        }
        return temp.parent;
    }
}
