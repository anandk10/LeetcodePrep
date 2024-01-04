class Solution {

    /**
    Implementing the optimal sliding window strategy
     */

    
    public String minWindow(String s, String t) {

        // compute the frequency map
        Map<Character, Integer> needMap = computeFreq(t);

        // filter the string s
        List<Pair> filteredS = filter(s, needMap);

        return minWindow(s, filteredS, needMap);
    }

    private String minWindow(String s, List<Pair> filteredS, Map<Character, Integer> needMap) {

        int left = 0;
        int right = 0;

        int finalLeft = -1;
        int finalRight = -1;
        int windowSize = Integer.MAX_VALUE;

        int needCount = needMap.size();

        Map<Character, Integer> haveMap = new HashMap<>();
        int haveCount = 0;

        while (right < filteredS.size()) {

            // growing window
            char currCh = filteredS.get(right).ch;

            // we already have filtered based on the needMap
            // update the haveMap
            haveMap.put(currCh, haveMap.getOrDefault(currCh, 0) + 1);

            if (haveMap.get(currCh) == (int) needMap.get(currCh)) {
                haveCount += 1;
            }

            // shrinking window
            while (haveCount == needCount) {

                Pair windowEnd = filteredS.get(right);
                Pair windowStart = filteredS.get(left);

                // update the finalLeft and finalRight
                if (windowSize > (windowEnd.index - windowStart.index + 1)) {
                    windowSize = windowEnd.index - windowStart.index + 1;
                    finalLeft = windowStart.index;
                    finalRight = windowEnd.index;
                }

                // moving the left pointer
                left += 1;
                
                currCh = windowStart.ch;
                // update the haveMap and decrement the value by 1
                int newVal = haveMap.get(currCh) - 1;
                haveMap.put(currCh, newVal);

                // goes below the required threshold
                if (haveMap.get(currCh) < needMap.get(currCh)) {
                    haveCount -= 1;
                }
                
                
            }
            
            right += 1;
        }

        return windowSize == Integer.MAX_VALUE ? "" : s.substring(finalLeft, finalRight + 1);

    }


    private Map<Character, Integer> computeFreq(String t) {
        Map<Character, Integer> needMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            needMap.put(ch, needMap.getOrDefault(ch, 0) + 1);
        }
        return needMap;
    }

    private List<Pair> filter(String s, final Map<Character, Integer> needMap) {
        List<Pair> filteredS = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (needMap.containsKey(s.charAt(i))) {
                filteredS.add(new Pair(s.charAt(i), i));
            }
        }
        return filteredS;
    }


    class Pair {
        char ch;
        int index;
        Pair(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }

        public String toString() { return "(" + ch + ", " + index + ")"; }
    }
}