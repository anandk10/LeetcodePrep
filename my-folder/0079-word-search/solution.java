class Solution {

    boolean [][] visitedBoard;

    private boolean backtrack(final char[][] board, int row, int col, final String word, int w) {

        // If processed all characters in the word, return true
        if (w == word.length()) {
            return true;
        }

        // Do boundary checks, 
        // check if visited
        // check if matching word

        if (row < 0 || col < 0 
            || row >= board.length || col >= board[0].length
            || visitedBoard[row][col]
            || word.charAt(w) != board[row][col]) {
                return false;
        }

        // Mark the visitedBoard
        visitedBoard[row][col] = true;

        boolean res = ( backtrack(board, row, col - 1, word, w + 1) ||
                        backtrack(board, row, col + 1, word, w + 1) ||
                        backtrack(board, row - 1, col, word, w + 1) ||
                        backtrack(board, row + 1, col, word, w + 1) );
        visitedBoard[row][col] = false;
        return res;
    }

    public boolean exist(char[][] board, String word) {

        final int ROWS = board.length;
        final int COLS = board[0].length;

        visitedBoard = new boolean[ROWS][COLS];
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (backtrack(board, row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;

    }
}
