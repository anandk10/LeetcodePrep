class Solution {
    /**
    Windowing approach because it's a substring 
    which means contiguous sequence of characters
     */
    public int maxVowels(String s, int k) {
        
        Set<Character> vowels = new HashSet<>(){{
                add('a');
                add('e');
                add('i');
                add('o');
                add('u');
        }};

        int left = 0,  right = 0;
        int maxVowelsSeen = 0;
        int currVowelsSeen = 0;

        while (right < s.length()) {
            if (vowels.contains(s.charAt(right))) {
                currVowelsSeen += 1;
            }

            if (k == (right - left + 1)) {
                maxVowelsSeen = Math.max(currVowelsSeen, maxVowelsSeen);

                // shrink 
                if (vowels.contains(s.charAt(left))) {
                    currVowelsSeen -= 1;
                }
                left += 1;
            }

            right += 1;
        }

        return maxVowelsSeen;

    }
}