class Solution {
    public boolean isAnagram(String s, String t) {
        // Two strings
        // s 
        // t
        // frequence of characters in both the strings to match. 

        
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        // Brute force
        // Idea is to create frequency map from 's'
        // and decrement those counters while iterating 't'
        // eventually an empty frequency map will indicate the 
        // string were anagram
        // Map<Character, Integer> counters = new HashMap<>();
        // // anagram
        // // a-3
        // // n-1
        // // g-1
        // // r-1
        // // m-1

        // // Create frequency maps
        // for (char sChar : s.toCharArray()) {
        //     Integer charFreq = counters.getOrDefault(sChar, 0);
        //     counters.put(sChar, charFreq + 1);
        // }

        // // nagaram
        // // a-3 --- -1 = 2 --- -1 = 1 --- -1 = 0 = delete
        // // n-1 --- -1 = 0 - delete
        // // g-1 --- -1 = 0 - delete
        // // r-1 --- -1 = 0 - delete
        // // m-1 --- -1 = 0 - delete
        // // if map is empty - return true

        // for (char tChar : t.toCharArray()) {
        //     Integer charFreq = counters.get(tChar);
        //     if (charFreq == null) return false;
        //     if (charFreq == 1) {
        //         counters.remove(tChar);
        //     }
        //     else {
        //         counters.put(tChar, charFreq - 1);
        //     }
        // }
        // return counters.isEmpty();

        // Solution 2: Sorted strings
        // When both strings are sorted, equality of both the strings
        // will immediately indicate them being anagram
        char[] sCharArr = s.toCharArray(); Arrays.sort(sCharArr);
        char[] tCharArr = t.toCharArray(); Arrays.sort(tCharArr);
        return Arrays.equals(sCharArr, tCharArr);

        // Solution 3: Functional style (WARNING - its not efficient)
        // return Arrays.equals(
        //         s.chars().mapToObj(c -> (char) c).sorted().toArray(Character[]::new),
        //         t.chars().mapToObj(c -> (char) c).sorted().toArray(Character[]::new)
        // );
    }
}
