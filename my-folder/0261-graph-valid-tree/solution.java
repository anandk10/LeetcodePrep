class Solution {
    public boolean validTree(int n, int[][] edges) {

        // 
        if (n == 0) return true;

        if(edges.length == 0 && n == 1) return true;

        if(edges.length == 0 && n > 1) return false;
                 

        // form the adjacency list
        Map<Integer, List<Integer>> graph = new TreeMap<>();

        populateAdjList(graph, edges);

        Set<Integer> visited = new TreeSet<>();
        int startNode = edges[0][0];
        int prevNode = -1;
        boolean cycleFound = traverse(startNode, prevNode, graph, visited);
        if (cycleFound || visited.size() != n) return false;
        return true;
    }

    private boolean traverse(int startNode, int prevNode, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        
        if (visited.contains(startNode)) return true;
        
        visited.add(startNode);

        boolean cycleFound = false;

        for (Integer neighbor : graph.get(startNode)) {
            if (neighbor == prevNode) { continue; } // prev node shouldn't be considered for cycle detection
            cycleFound = cycleFound | traverse(neighbor, startNode, graph, visited);

            if (cycleFound) { break; } // break if cycle is found
        }

        return cycleFound;
    }


    private void populateAdjList(Map<Integer, List<Integer>> graph, int[][] edges) {
        for (int[] edge :  edges) {
            graph.computeIfAbsent(edge[0], e -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], e -> new ArrayList<>()).add(edge[0]);
        }
    }
}
