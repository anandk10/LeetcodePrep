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

    private Node _cloneGraphUsingDFS(Node node, Map<Node, Node> clonedGraphNodes) {
        if (node == null) return node;

        if (clonedGraphNodes.containsKey(node)) return clonedGraphNodes.get(node);

        Node clonedNode = new Node(node.val);
        List<Node> clonedNeighbors = new ArrayList<>();
        clonedNode.neighbors = clonedNeighbors;

        clonedGraphNodes.put(node, clonedNode);


        for (Node neighbor :  node.neighbors) {
            clonedNode.neighbors.add(_cloneGraphUsingDFS(neighbor, clonedGraphNodes));
        }

        return clonedNode;
    }

    public Node cloneGraph(Node node) {
        return _cloneGraphUsingDFS(node, new HashMap<>());
    }
}