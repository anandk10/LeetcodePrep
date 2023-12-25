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

    public Node lowestCommonAncestor(Node p, Node q) {
        
        Node a = p;
        Node b = q;

        while (a != b) {
            if (a == null) {
                // start with the other list
                a = q; 
            } else {
                a = a.parent;
            }

            if(b == null) {
                // start with the other list
                b = p;
            } else {
                b = b.parent;
            }
        }

        return a;
    }

    // private int getHeight(Node node) {
    //     int count = 0;
    //     while (node != null) {
    //         node = node.parent;
    //         count++;
    //     }
    //     return count;
    // }

    // public Node lowestCommonAncestor(Node p, Node q) {


    //     // first count the nodes
    //     int heightP = getHeight(p);
    //     int heightQ = getHeight(q);

    //     // System.out.println("Height p : " + heightP);

    //     // System.out.println("Height q : " + heightQ);

    //     Node higher = null;
    //     Node lower = null;
        
    //     while (heightP > heightQ) {
    //         p = p.parent;
    //     }
        
    //     while (heightQ > heightP) {
    //         q = q.parent;
    //     }
        
    //     while (p != q && p != null && q != null) {
    //         p = p.parent;
    //         q = q.parent;
    //     }
        
    //     return p;

    //     // if (heightP > heightQ) {
    //     //     higher = traverseDelta(p, heightP - heightQ);
    //     //     lower = q;
    //     // } else {
    //     //     higher = traverseDelta(q, heightQ - heightP);
    //     //     lower = p;
    //     // }

    //     // while (higher != lower && higher != null && lower != null) {
    //     //     higher = higher.parent;
    //     //     lower = lower.parent;
    //     // }
    //     // return higher;

    // }
}