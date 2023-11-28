class Solution {


    private String say(String num) {

        int windowStart = 0;
        int windowEnd = 0;
        
        int size = 0;
        char prevChar = '\0';

        StringBuilder say = new StringBuilder();
        while (windowEnd < num.length()) {

            if (num.charAt(windowEnd) == num.charAt(windowStart)) {
                size = windowEnd - windowStart + 1;
                prevChar = num.charAt(windowEnd);
                windowEnd++;
            } else {
                say.append(size);
                say.append(prevChar);
                windowStart = windowEnd;
            }
        }

        say.append(size);
        say.append(prevChar);

        // System.out.println(say.toString());
        return say.toString();

    }

    public String countAndSay(int n) {
        if (n == 1) return "1";

        return say(countAndSay(n-1));

    }

    /**
    
    countAndSay(3)
        say countAndSay(2)
            say countAndSay(1)
                1
            say "1"
        say "11"
    say "21"


    say 
     */



}
