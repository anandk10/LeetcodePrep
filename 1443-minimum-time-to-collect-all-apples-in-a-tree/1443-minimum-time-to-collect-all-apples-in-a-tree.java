class Solution {

    /**
    consider this as a graph and not a tree
    SIMILAR TO FINDING LENGTH OR HEIGHT OF TREE
    we are traversing the graph (DFS) and for a subtree
    the code calculates the time.
    So if its a leaf node and hasApple() is true then 
    it will return 2.
    Every parent must consider what its subtree return
    and if itself contains apple.
    
     */
    
    Map<Integer, List<Integer>> graph;
    List<Boolean> hasApple;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        this.hasApple = hasApple;
        this.graph = formGraph(n, edges);
        return dfs(0, -1);
    }

    private Map<Integer, List<Integer>> formGraph(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        IntStream.range(0, n)
                .forEach(i -> graph.put(i, new ArrayList<>()));
        Arrays.stream(edges)
            .forEach(edge -> { 
                                graph.get(edge[0]).add(edge[1]); 
                                graph.get(edge[1]).add(edge[0]); 
                             }
                    );
        return graph;
    }

    private int dfs(int startNode, int parentNode) {

        int time = 0;
        for(int neighbor : graph.get(startNode)) {
            if (neighbor == parentNode) {
                continue;
            }

            int subTreeTime = dfs(neighbor, startNode);

            if (hasApple.get(neighbor) || subTreeTime != 0) {
                time += 2 + subTreeTime;
            }
        }

        return time;
    }

}