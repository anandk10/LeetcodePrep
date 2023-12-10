class Solution {
    
    static int ROWS;
    static int COLS;
    static int[][] LIP;
    static int[][] directions = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    
    public int longestIncreasingPath(int[][] matrix) {
        // The logic here is to run a intelligent dfs on all the cell
        //     of the matrix
        
        // What that entails is, during the DFS, as and when we find the 
        //     path, we will keep its track in a separate table
        
        ROWS = matrix.length; 
        COLS = matrix[0].length;
        LIP = new int[ROWS][COLS];
        
        // initialize LIP
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS ; j++) {
                LIP[i][j] = 0; // default path, impossible value, minimum should be 1
            }
        }
        
        int maxPath = Integer.MIN_VALUE;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, -1)); // r, c and prevVal
            }
        }
        
        return maxPath;
        
    }
    
    private static int dfs(int[][] matrix, int row, int col, int prevVal) {
        
        // base condition
        if (row < 0 || col < 0 || 
            row == ROWS || col == COLS ||
            prevVal >= matrix[row][col]) { // only move if the value increases
            return 0;
        }
        
        if (LIP[row][col] != 0) {
            // this value has been already computed 
            // so return it
            return LIP[row][col];
        }
        
        int res = 1; // consider the current [row][col] of length 1
        // exploring neighbors
        for (int[] dir: directions) {
            
            int r = row + dir[0];
            int c = col + dir[1];
            
            // max (path where I dont explore any neighbor, 
            //      path where there is some neighbor adding to my path length)
            res = Math.max(res, 1 + dfs(matrix, r, c, matrix[row][col]));
        }
        
        // update the LIP
        LIP[row][col] = res;
        return res;
    }
}