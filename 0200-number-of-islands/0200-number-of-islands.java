class Solution {


    // this problem can be solved by running a DFS and traversing all the nodes that are connected. 
    // and repeating for all the elements in the grid. 


    boolean[][] visited;
    int ROWS;
    int COLS;

    public boolean dfs(final char[][] grid, int row, int col) {

        // base condition
        if (row < 0 || col < 0 ||
            row >= ROWS || col >= COLS ||
            grid[row][col] == '0' ||
            visited[row][col]) {
                return false;
            }
        visited[row][col] = true;

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);

        return true;

    }

    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        visited = new boolean[ROWS][COLS];
        int count = 0;
        for (int i = 0; i < ROWS ; i++) {
            for (int j = 0; j < COLS; j++) {
                // System.out.println("Before Visiting: (" + i + "," + j + ")");
                if (dfs(grid, i, j)) count++;
                // System.out.println("After Visiting: (" + i + "," + j + ")");
            }
        }

        return count;

    }
}