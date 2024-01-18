import static java.util.function.Predicate.not;

class Solution {

    /**
    
    1. Form a graph by traversing the edges
    2. Then find all the connected components by traversing elements
    3. Perform BFS on every node of every connected graph and 
        use graph coloring in order to
        detect ODD length cycle. 
        3.1 if there is an ODD length cycle, then the output is
            impossible so return -1 for this connection graph
    4. Keep computing the levels for every node and rec
    
    
     */

    private Map<Integer, List<Integer>> formGraph(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // Node start from 1
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    private List<List<Integer>> findConnectedComponents(int n, Map<Integer, List<Integer>> graph) {
        List<List<Integer>> connectedComponents = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int startNode = 1; startNode <= n; startNode++) {
            if (!visited.contains(startNode)) {
                List<Integer> res = findConnected(startNode, graph, visited);
                connectedComponents.add(res); 
            }
        }
        return connectedComponents;
    }

    // Choosing BFS to find connected components
    private List<Integer> findConnected(int startNode, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        List<Integer> connectedNodes = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            if (visited.contains(node)) {
                continue;
            }

            visited.add(node);
            connectedNodes.add(node);
            graph.get(node)
                 .stream()
                 .filter(not(visited::contains))
                 .forEach(queue::offer);
        }

        return connectedNodes;
    }

    // Invoke graph coloring for all connected graphs
    private int findMaxLengths(List<List<Integer>> connectedComponents, Map<Integer, List<Integer>> graph) {

        int result = 0;
        for (List<Integer> connectedComponent : connectedComponents) {
            int maxLength = Integer.MIN_VALUE;
            for (int startNode : connectedComponent) {
                int currentLength = colorGraphBFS(startNode, connectedComponent.size(), graph);
                if (currentLength == -1) {
                    return -1; // it's not possible to divide the graph
                }

                maxLength = Math.max(maxLength, currentLength);
            }

            result += maxLength;
            
        }
        return result;
    }

    // Graph coloring : Invoke BFS from EVERY node in A connected graph
    private int colorGraphBFS(int startNode, int totalConnectedNodes, Map<Integer, List<Integer>> graph) {

        int[] colors = new int[graph.size() + 1];

        Queue<Integer> queue = new LinkedList<>();
        colors[startNode] = 1;
        queue.offer(startNode);
        queue.offer(-1); // acts as barrier between levels
        
        int length = 0; // only one node, so length is 0

        while(!queue.isEmpty()) {
            int node = queue.poll();
            if (node == -1) {
                // barrier node
                if (!queue.isEmpty()) {
                    queue.offer(-1);
                }
                length++; // process a layer     
            } else {
                // actual node
                // for neighbors of node
                // color it with a flipped value
                for (int neighbor : graph.get(node)) {
                    if (colors[neighbor] == 0) {
                        // unexplored neighbor
                        colors[neighbor] = -colors[node];
                        queue.offer(neighbor);
                    } else if (colors[neighbor] == colors[node]) {
                        // explored neighbor i.e. cycle and odd cycle
                        // if the colors are same
                        return -1;
                    }
                }
            }
        }
        // System.out.println("Length :" +length + ", colors : " + Arrays.toString(colors));
        return length;
    }

    

    public int magnificentSets(int n, int[][] edges) {
        
        Map<Integer, List<Integer>> graph = formGraph(n, edges);
        List<List<Integer>> connectedComponents = findConnectedComponents(n, graph);
        return findMaxLengths(connectedComponents, graph);
    }
}