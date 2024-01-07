class Solution {

    /**
    Perform DFS from node 0 i.e. graph[0] 
    once you reach N-1, add the path to the result
     */

    boolean[] visited;
    List<List<Integer>> result;

    private void dfs(int currNode, 
                    int[][] graph, 
                    List<Integer> solution) {
        
        solution.add(currNode);
        if (currNode == graph.length - 1) {
            result.add(new ArrayList<>(solution));
            return;
        }

        // explore neighbors
        for(int neighbor : graph[currNode]) {
            dfs(neighbor, graph, solution);
            if (!solution.isEmpty()) {
                // remove the node that was added in dfs()
                solution.removeLast();
            }
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        visited = new boolean[graph.length];
        result = new ArrayList<>();
        dfs(0, graph, new LinkedList<>());
        return result;
    }
}