/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    Map<Node, Node> lookupClones;


    private Node dfs(final Node origNode) {

        if (origNode == null)
            return null;
        
        // if exists in lookupClones map; return that node
        Node alreadyCloned = lookupClones.get(origNode);
        if (alreadyCloned != null) {
            return alreadyCloned;
        }

        Node clonedNode = new Node(origNode.val);
        lookupClones.put(origNode, clonedNode);

        for (Node neighbor : origNode.neighbors) {
            Node clonedNeighbor = dfs(neighbor);
            clonedNode.neighbors.add(clonedNeighbor);
        }
        return clonedNode;
    }

    public Node cloneGraph(Node node) {
        
        lookupClones = new HashMap<>();
        return dfs(node);
    }
}
