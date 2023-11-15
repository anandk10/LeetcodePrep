class Solution {

    int ROWS;
    int COLS;

    private void dfs (char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= ROWS || j >= COLS 
            || board[i][j] == 'X' || board[i][j] == 'T') {
                // if (i < 0 || j < 0 || i >= ROWS || j >= COLS ) {
                //     // System.out.println("(i,j) = " + i + "," + j );
                // } else if (board[i][j] == 'X' || board[i][j] == 'T') {
                //     // System.out.println("(i,j) = " + i + "," + j );
                //     // System.out.println("Cell value = " + board[i][j]);
                // }
                return;
            }
            // System.out.println("Cell value changed from " + board[i][j]);
            board[i][j] = 'T';
            // System.out.println("Cell value changed to " + board[i][j]);

            dfs(board, i - 1, j);
            dfs(board, i + 1, j);
            dfs(board, i, j - 1);
            dfs(board, i, j + 1);
    }
    
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        // board[0][1..n]

        // board[ROWS-1][1..n]

        // board[1..n][0]

        // board[1..n][COLS-1]

        

        for (int j = 0; j < COLS; j++) {
            dfs(board, 0, j);
            dfs(board, ROWS - 1, j);
        }

        for (int i = 0 ; i < ROWS; i++) {
            dfs(board, i, 0);
            dfs(board, i, COLS - 1);
        }
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0 ; j < COLS; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
  
        
    }
}
