class Solution {

    public String minRemoveToMakeValid(String s) {
        
        // holds index of the opening "("
        Stack<Integer> stack = new Stack<>();

        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            // if '(' then push the index
            if (ch[i] == '(') {
                stack.push(i);
            } else if (ch[i] == ')') {
                // if ')' then pop if stack contains '('
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    // found ')' without a matching '('
                    ch[i] = '#'; // set the tombstone character
                }

            }
        }

        while (!stack.isEmpty()) {
            // this will contain only '(' indices
            // these characters will have to be marked
            // in the character array
            int i = stack.pop();
            ch[i] = '#';
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ch.length; i++) {
            // skip tombstone character
            // '#'

            if (ch[i] != '#') {
                sb.append(ch[i]);
            }
        }

        return sb.toString();

    }
}