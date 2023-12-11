class Solution {
    public long distinctNames(String[] ideas) {
        
        // swapping the initial char from two words that have the same
        // suffix is going to create the same set of words
        // coffee , toffee
        // toffee , coffee (we swapped c and t, but the suffix offee was the same)
        // so can't count these
        
        // idea is to store the words in a map with their starting char
        // as the key and the rest of string as the value (in a set)
        
        // then iterate through all the char key in the map
        // iterate through all the char keys, continue if comparing same char
        // find the intersect i.e. if the values from the maps in the two nested loops 
        //  are same, then it means its a common suffix, and remember we already are
        // two different char keys, therefore swapping those char in the words with same 
        // suffix is not going to help
        
        // Lets create the map
        Map<Character, Set<String>> wordMap = new TreeMap();
        for (String idea :  ideas) {
            wordMap.computeIfAbsent(idea.charAt(0), HashSet::new)
                        .add(idea.substring(1));
        }
        
        long result = 0;
        for (Character key1 : wordMap.keySet()) {
            for (Character key2: wordMap.keySet()) {
                if (key1 == key2) continue;

                long intersect = 0;

                // visiting all the suffixes and checking if 
                // they exists in another grouping of suffixes

                // i.e. intersect of two sets
                for (String suffix :  wordMap.get(key1)) {
                    if (wordMap.get(key2).contains(suffix)) {
                        intersect += 1;
                    }
                }
                
                // distinct suffix in wordMap with char key1 as prefix
                long distinct1 = wordMap.get(key1).size() - intersect;

                // distinct suffix in wordMap with char key2 as prefix
                long distinct2 = wordMap.get(key2).size() - intersect;

                // # c : [afe, offee]

                // # t : [ime, om, offee]

                // # intersect = 1
                // # distinct1 = 2 - 1 = 1
                // # distinct2 = 3 - 1 = 2

                // # the suffix 'offee' cant be used to form words.

                // # between characters c and t, 'afe', 'ime' and 'om'
                // # can be used

                // # cime, com, tafe

                // # "tafe cime"
                // # "tafe com"

                // # second interation:

                // # "cime tafe"
                // # "com tafe"

                result += distinct1 * distinct2;
            }
        }
        
        return result;
    }
}