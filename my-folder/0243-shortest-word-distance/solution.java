class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        
        List<Integer> words1Indices = new ArrayList<>();
        List<Integer> words2Indices = new ArrayList<>();

        
        for (int i=0; i<wordsDict.length; i++) {
            
            if (wordsDict[i].equals(word1)) {
                words1Indices.add(i); 
            }
            
            if (wordsDict[i].equals(word2)) {
                words2Indices.add(i);
            }        
        }
        
        int distance = wordsDict.length;
        for (int i = 0; i < words1Indices.size(); i++) {
            for (int j = 0; j < words2Indices.size(); j++) {
                int differ = Math.abs(words1Indices.get(i) - words2Indices.get(j));
                distance = Math.min(distance, differ);
            }
        }
        
        return distance;
        
        
        
    }
}
