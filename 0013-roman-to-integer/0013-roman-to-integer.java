class Solution {

    /**
    left to right

    precedence higher to lower exception of special 
    cases
    for e.g. IV
    I >= V
    I = 10
    V = 50
    V - I = 50 - 10 = 40


    "LVIII"

    "LIX"

    50 1  < 10
    1 < 10; peek() < new_num
    pop() until peek() >= new_num

    keep summing the popped numbers
    1

    newnum - sum = 10 - 1 = 9

    50 9

    = 59
        

    "MCMXCIV"

    1000 > 100  < 1000

    sum_popped = 100

    1000 - 100 = 900

    1000 > 900 > 10 < 100

    sum_popped = 10

    100 - 10 = 90

    1000 > 900 > 90 > 1

    1000 > 900 > 90 > 1 < 5

    sum_popped = 1

    5 - 1 = 4

    1000 > 900 > 90 > 4


     */
    public int romanToInt(String s) {
        
        Map<Character, Integer> lookup = new HashMap<>();
        lookup.put('I', 1);
        lookup.put('V', 5);
        lookup.put('X', 10);
        lookup.put('L', 50);
        lookup.put('C', 100);
        lookup.put('D', 500);
        lookup.put('M', 1000);

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            int val = lookup.get(s.charAt(i));
            int poppedSum = 0;
            while(!stack.isEmpty() && stack.peek() < val) {
                poppedSum += stack.pop();
            }

            int pushVal = val - poppedSum;
            stack.push(pushVal);
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;


    }
}