class Solution {
    public boolean isValid(String s) {
        // Push the opening parenthesis on to the stack
        // if closing parenthesis is encountered then 
        // pop/peek the stack
        // if matching opening parenthesis is found
        // pop the stack and continue this process

        // Initialize stack 'tracker'
        // for every char c in string s
        //     if c is an opening parenthesis then
        //         push c in tracker

        //     if c is a closing parenthesis then
        //         pop the top element from the tracker into 'd'
        //         if d is not the matching opening parenthesis for c then 
        //             return false
                
        //     if tracker is empty then 
        //         return true

        // if tracker is not empty then
        //     return false

        // "()[]{}"
        // "([{}])"
        // "]]"
        // ""
        // "((("

        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> tracker = new Stack<>();

        // for(Character parenthesis : s.toCharArray()) {
        //     if (parenthesis == '(' || parenthesis == '[' || parenthesis == '{') {
        //         tracker.push(parenthesis);
        //     }

        //     if (parenthesis == ')' || parenthesis == ']' || parenthesis == '}') {
        //         if (tracker.isEmpty()) {
        //             return false;
        //         }
        //         Character topChar = tracker.pop();
        //         if (parenthesis == ')' && topChar != '(' ||
        //                parenthesis == ']' && topChar != '[' || 
        //                parenthesis == '}' && topChar != '{') {
        //             return false;
        //         }
        //     }

            
        // }

        // return tracker.isEmpty() ? true : false;


        for(Character c : s.toCharArray()) {
            if (isOpeningParenthesis(c)) {
                tracker.push(closingParenthesis(c));
            } else {
                if (tracker.isEmpty() || c != tracker.pop()) {
                    return false;
                }
            }
        }
        return tracker.isEmpty();

    }

    private static boolean isOpeningParenthesis(Character c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static Character closingParenthesis(Character c) {
        if (c== '(') return ')';
        if (c== '[') return ']';
        if (c == '{') return '}';
        return '0';
    } 
}
