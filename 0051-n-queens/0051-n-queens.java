class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> result = new ArrayList<>();
        String[][] board = new String[n][n];

        for (String[] row : board) {
            java.util.Arrays.fill(row, ".");   
        }

        Set<Integer> colSet = new HashSet<>();
        Set<Integer> posDiagSet = new HashSet<>();
        Set<Integer> negDiagSet = new HashSet<>();
        

        backtrack(0, board, colSet, posDiagSet, negDiagSet, result);
        return result;
    }

    private void backtrack(int row, String[][] board, 
                            Set<Integer> colSet,
                            Set<Integer> posDiagSet,
                            Set<Integer> negDiagSet,
                            List<List<String>> result) {
        
        // base condition
        if (row == board.length) {
            List<String> rowList = new ArrayList<>();
            for(String[] r : board) {
                // String rowStr = Arrays.stream(r)
                //       .collect(Collectors.joining(""));
                // rowList.add(rowStr);

                StringBuilder sb = new StringBuilder();
                for (String c : r) {
                    sb.append(c);
                }
                rowList.add(sb.toString());
            }
            result.add(rowList);
            return;
        }

        int COLS = board[row].length;
        for (int col = 0; col < COLS; col++) {

            if (colSet.contains(col) || posDiagSet.contains(row + col) || negDiagSet.contains(row - col)) {
                continue;
            }

            colSet.add(col);
            posDiagSet.add(row + col);
            negDiagSet.add(row - col);
            board[row][col] = "Q";

            backtrack(row + 1, board, colSet, posDiagSet, negDiagSet, result);

            colSet.remove(col);
            posDiagSet.remove(row + col);
            negDiagSet.remove(row - col);
            board[row][col] = ".";
        }



    }
}