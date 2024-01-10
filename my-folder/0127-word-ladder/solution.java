class Solution {


    /**
    Helps creating strings by replacing i th character by *
    doesn't do validation
     */
    private String createPattern(String word, int i) {
        StringBuilder sb = new StringBuilder(word);
        sb.setCharAt(i, '*');
        return sb.toString();
    }

    private void formAdjList(Map<String, List<String>> adjList, List<String> wordList ) {
        // form the adjacency list of words formed by replacing just 1 character
        // generate patterns like *ot, h*t, ho*

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++){
                String pattern = createPattern(word, i);
                // hot -> *ot
                // {"*ot" : ["hot"]}

                // dot -> *ot
                // {"*ot" : ["hot", "dot"]}
                adjList.computeIfAbsent(pattern, w -> new ArrayList<>()).add(word);
            }
        }
    }
    

    private int bfs(Map<String, List<String>> adjList, String beginWord, String endWord) {
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();

            for(int k = 0; k < size; k++) {
                
                String word = queue.poll();

                if (word.equals(endWord)) {
                    return step;
                }

                // now we enqueue all the unvisited neighbors from this word
                // create patterns and get the neighbors from the adjList
                for(int i = 0; i < word.length(); i++) {
                    String pattern = createPattern(word, i);
                    for(String neighbor : adjList.get(pattern)) {

                        if (neighbor.equals(endWord)) {
                            return step;
                        }

                        if (!visited.contains(neighbor)) {
                            queue.offer(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }

        }

        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
       if (!wordList.contains(endWord)) {
           return 0;
       }

        wordList.add(beginWord);

        // adjacency list
        Map<String, List<String>> adjList = new HashMap<>();
        formAdjList(adjList, wordList);

        return bfs(adjList, beginWord, endWord);

    }
}
