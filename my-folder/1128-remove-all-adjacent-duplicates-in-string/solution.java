class Solution {

    class CharCount {
        char letter;
        int count;
        CharCount(char ch, int num) {
            this.letter = ch;
            this.count = num;
        }
    }


    public String removeDuplicates(String s) {
        
        Stack<CharCount> stack = new Stack<>();

        int k = 2; // two adjacent characters

        for (int i = 0; i < s.length(); i++) {
            
            char currCh = s.charAt(i);

            if (!stack.isEmpty() && stack.peek().letter == currCh) {
                stack.peek().count += 1;
            } else {
                stack.push(new CharCount(currCh, 1));
            }
            
            if (stack.peek().count == k) {
                stack.pop();
            }

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < stack.size(); i++) {

            CharCount ele = stack.get(i);

            for (int j = 0; j < ele.count; j++) {
                sb.append(ele.letter);
            }
        }

        return sb.toString();

    }
}
