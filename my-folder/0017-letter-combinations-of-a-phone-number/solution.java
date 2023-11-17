class Solution {


    List<String> combinations;
    String[] keypad = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    private void backtrack(final int index, final String digits, 
                        StringBuilder solution) {
        
        // base condition
        if (index == digits.length()) {
            if (!solution.isEmpty())
                combinations.add(solution.toString());
            return;
        }

        // recursive logic
        int digit = Character.getNumericValue(digits.charAt(index)); // dailed digit

        for(char key : keypad[digit].toCharArray()) {
            solution.append(key);
            backtrack(index + 1, digits, solution);
            solution.deleteCharAt(solution.length() - 1);
        }


    }

    public List<String> letterCombinations(String digits) {

        combinations = new ArrayList<>();

        backtrack(0, digits, new StringBuilder());

        // 67
        // 669
        // explore the tree - characters for that digit
        // 6 - m,n,o
        // ["m" , "n", "o"]

        // 6 - m,n,o
        // ["mm", "mn", "mo"]

        // ["nm", "nn", "no"]

        // ["om", "on", "oo"]

        return combinations;
    }
}
