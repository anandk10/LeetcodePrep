/**
Solution uses Monotonic Stack to save only increasing digits, 
and popping digits only k number of times
 */

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char c : num.toCharArray()) {
            
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k -= 1;
            }

            stack.push(c);
        }
        // for 12345 , nothing will be popped in the above loop
        while (k > 0) {
            stack.pop();
            k -= 1;
        }

        return processStack(stack);
    }

    private String processStack(Stack<Character> stack) {

        if (stack.isEmpty()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Character> it = stack.iterator();
        boolean leadingZero = false;
        while (it.hasNext()) {
            char ch = it.next();
            if (ch == '0' && !leadingZero) {
                continue;
            } else {
                leadingZero = true;
            }
            sb.append(ch);
        }

        if (sb.isEmpty()) {
            return "0";
        }
        return sb.toString();
    }
}