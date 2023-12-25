/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

/**
This problem could be seen as finding the intersection of two lists at some node (LCA)
Look at the TreeNode as LinkedList node, where parent is like the next pointer

        4 ---> 3 ---> 2 ---> 1 ---> null
6 ---> 5----> 10 ---/

the root of the tree is 1, but parent pointer traversal start from any node in the tree would reach 
its convergence at their LCA

so if two nodes were 4 and 6, these lie in different subtrees divided by TreeNode 3

We need three traversals
from 4 to 1 (end of list) - count these
from 6 to 1 (end of list) - count these

4 (1-2-3-4) nodes vs 5 nodes ( 1-2-10-5-6 )
the delta is 1
so traverse the big  delta number of times

and then start both the traversals at the same

so final traversal will start at

        4 ---> 3 ---> 2 ---> 1 ---> null
        5----> 10 ---/

if memory (4) == memory (5) then
    lca found
else
    move both the lists

if memory (3) == memory (10) then
    lca found
else
    move both the lists

if memory (2) == memory (2) then
    lca found --- true
else
    move both the lists


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


}