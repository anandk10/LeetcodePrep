class Solution {

    /**
        Longest substring
        (max).  (sequential)

        criteria: k distinct characters

        max length of the substring
        sliding window technique

        s = "eceba", k = 2

        HashMap<Character, Integer>


        violate the criteria?

        window - e - at most k distinct character - yes; size = 1
                ec - at most k - yes; size = 2
                ece - at most k - yes ; size  = 3
                        e - 2, c - 1
                eceb - 
                        e - 2, c - 1, b - 1
                    violates at most k distinct
                    while(map.size() > k) {
                        if(map.get(s.charAt(windowStart)) == 1)
                            map.remove(s.charAt(windowStart))
                        else    
                            map.put(s.charAt(windowStart), map.get(s.charAt(windowStart) - 1))
                        
                        windowStart++;
                    }

                ceb  - e - 1, c - 1, b - 1

                eb - e - 1, b - 1
                    size = max(size, windowEnd - windowStart + 1)
                    windowEnd++
                eba - 
                    e - 1, b - 1, a - 1

                ba
                    b - 1, a - 1
     */



    public int findLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> counts = new HashMap<>();

        int windowStart = 0;
        int windowEnd = 0;

        int size = Integer.MIN_VALUE;

        for ( ; windowEnd < s.length();) {

            char ch = s.charAt(windowEnd);
            int chCount = counts.getOrDefault(ch, 0) + 1;
            counts.put(ch, chCount);

            while(counts.size() > k) {
                // violated constraint
                // resolve the contraint and move the slinding window

                // remove from the map
                if (counts.get(s.charAt(windowStart)) == 1) {
                    counts.remove(s.charAt(windowStart));
                } else {
                    int updatedChCount = counts.get(s.charAt(windowStart)) - 1;
                    counts.put(s.charAt(windowStart), updatedChCount);
                }
                // move the windowStart
                windowStart++;
            }

            size = Math.max(size, windowEnd - windowStart + 1);
            windowEnd++;

        }

        return size;
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        return findLongestSubstringKDistinct(s, k );
    }
}
