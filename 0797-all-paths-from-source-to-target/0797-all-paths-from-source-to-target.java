class Solution {

    /**
    Perform DFS from node 0 i.e. graph[0] 
    add 0 to the path, add to the visited set
    then load neighbors of graph[0]
    iterate those 
        while iterating if the node ith is N-1 then 
        we found a path from 0 to N, add this path to solution

    [[1,2],
    [3],
    [3],
    []]

    [t,f,t,f]
    
    0
    [1,2]
    
    1 {0}
    [3]

    3 {0->1}
    3==N-1

    {0->1->3} [{0,1,3}]

    1 {0}
    [...] // 3 is processed

    no neighbors to process

    0 {}
    [2]

    2 {0}
    [3]

    3 {0->2}
    3 == N-1

    {0->2->3} [{0,1,3},{0,2,3}]

    2 {0}
    [...] // 3 is processed

     */

    boolean[] visited;
    List<List<Integer>> result;

    private void dfs(int currNode, 
                    int[][] graph, 
                    List<Integer> solution) {

        if (currNode == graph.length) return;

        if (currNode == graph.length - 1) {
            solution.addLast(currNode);
            result.add(new ArrayList<>(solution));
            solution.removeLast();
            return;
        }

        solution.addLast(currNode);

        // explore neighbors
        for(int neighbor : graph[currNode]) {
            visited[neighbor] = true;
            dfs(neighbor, graph, solution);
            visited[neighbor] = false;
        }

        solution.removeLast();

    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        visited = new boolean[graph.length];
        result = new ArrayList<>();
        dfs(0, graph, new LinkedList<>());
        return result;
    }
}