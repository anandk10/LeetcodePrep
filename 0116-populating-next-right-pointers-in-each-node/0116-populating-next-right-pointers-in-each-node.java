/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    public Node connect(Node root) {

        // idea is simple, treat every level as its own linked list
        // by being on level n, modify next pointer on level n+1

        if (root == null) return root;

        Node leftMost = root;

        while (leftMost.left != null) {
            // ensuring that the next level is present

            Node head = leftMost;

            head.left.next = head.right;

            while (head!=null) {
                head.left.next = head.right;

                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;
            }

            leftMost = leftMost.left;

        }

        return root;

    }

    /**
    With queue method
     */
    // public Node connect(Node root) {

    //     if (root == null) return root;

    //     Queue<Node> q = new LinkedList<Node>();

    //     q.offer(root);

    //     while (!q.isEmpty()) {

    //         int currSize = q.size();

    //         while (currSize > 0) {
    //             currSize--;
    //             Node front = q.poll();

    //             if (currSize != 0) {
    //                 // we are not on the last node of the current level
    //                 front.next = q.peek();
    //             }
                
    //             if (front.left != null) { q.offer(front.left); }
                
    //             if (front.right != null) { q.offer(front.right); }
    //         }
    //     }

    //     return root;
        
    // }
}