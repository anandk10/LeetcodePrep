class Solution {


    // 0--> 1-->2
    //  \-->3  


    // 0 ---> 1 
    //  \----/   

    Set<Integer> visited ;
    
    public boolean dfs(Integer course, Map<Integer, List<Integer>> prereqMap) {

        // base conditions
        if (visited.contains(course)) {
            return false; // also handles cycle
        }

        List<Integer> prereqList = prereqMap.get(course);
        if (prereqList.isEmpty()) {
            // a course with no prerequsites
            return true;
        }

        visited.add(course);

        for (Integer prereq : prereqList) {
            if (!dfs(prereq, prereqMap)) {
                return false;
            }
        }

        prereqMap.put(course, new ArrayList<>());
        visited.remove(course);
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // [0,1],
        // [0,3],
        // [1,2]

        // 0 --> [1,3]
        // 1 --> [2]
        // 2 --> []
        // 3 --> []
        
        Map<Integer, List<Integer>> prereqMap = new HashMap<>();
        // create a prereq map to tracking prereq for all courses
        for (int course = 0; course < numCourses; course++) {
            prereqMap.computeIfAbsent(course, ArrayList<Integer>::new);
        }

        // populate the prerep map with the prereq courses
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            prereqMap.get(course).add(prereq);
        }


        visited = new HashSet<>();
        for (Integer course : prereqMap.keySet()) {
            if (!dfs(course, prereqMap)) {
                return false;
            }
        }

        return true;
    }
}