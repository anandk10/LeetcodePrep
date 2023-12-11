class Solution {
    public int uniquePaths(int m, int n) {
        
        // we will solve this problem by using bottom up approach
        // the last position is our base case
        // wherein the grid[m][n] is counted as 1 unique path
        // to reach itself
        
        // creating a row to indicate the last row path counts
        int[] row = new int[n];
            
        // the movement possible here is only in the right direction
        // therefore all the values will be 1 (because at any position
        // on the last row you can only go right, and that counts as only
        // 1 unique path
        // [1,1,1,1,,1,1.....,1]
        
        // thereby we already have process the last row of the grid
        for(int i = 0; i < n; i++) {
            row[i] = 1;
        }
        
        // Going upwards upto the start of the grid
        // m-2 because last row is already processed
        for (int k = m - 2; k >= 0 ; k--) {
            // the last column also has only one direction to move
            // i.e. down. Therefore only 1 unique path exists in the 
            // last column for every row
            row[n - 1] = 1;
            
            // now for every cell in this row except last column
            // there are two possible moves
            // so consider the down and right locations
            // run a loop from second last column upto the first column
            
            for (int j = n - 2; j >= 0; j--) {
                // Addition of the right and the down cells will give the 
                // current cell's unique paths
                row[j] = row[j+1] + row[j];
                // since this is not actually a grid but only a 1D array
                // manipulation, row[j] before modifying is the value of 
                // down cell and row[j+1] will be the value of the right cell
                
            }
        }
        
        // finally the row[0] will have the total number of unique path
        return row[0];
    }
}