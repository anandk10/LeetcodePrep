class Solution {

    /**
    Use of STACK to keep track of char and count that we saw
    composite key

     */
    
    class CharCount {
        char ch;
        int count;
        CharCount(char c, int co) {
            this.ch = c;
            this.count = co;
        }
    }

    public String removeDuplicates(String s, int k) {
        
        Stack<CharCount> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {

            // if the curr character is the top element
            // of the stack
            // System.out.println(stack);
            char currCh = s.charAt(i);
            if (!stack.isEmpty() && stack.peek().ch == currCh) {
                stack.peek().count += 1;
            } else {
                // seeing this character first or atleast a new 
                // sequence of currCh 
                stack.push(new CharCount(currCh, 1));
                
            } 

            if (stack.peek().count == k) {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        // now iterate through the stack for get the string
        for (int i = 0; i < stack.size(); i++) {
            CharCount charCount = stack.get(i);
            for (int j = 0; j < charCount.count; j++) {
                sb.append(charCount.ch);
            }
            
        }

        return sb.toString();

    }
}