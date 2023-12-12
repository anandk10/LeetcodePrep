class Solution {

    boolean[][] visitedPacific;
    boolean[][] visitedAtlantic;

    int ROWS, COLS;

    private void dfs(final int[][] heights, final int previousHeight,
                     int r, int c, final boolean[][] visited) {
        // base conditions

        if (r < 0 || c < 0 || r == ROWS || c == COLS  // boundary conditions
            || visited[r][c] // don't visit already visitied
            || heights[r][c] < previousHeight) { // only go towards peaks
            return;
        }
        visited[r][c] = true;
        dfs(heights, heights[r][c], r, c + 1, visited);
        dfs(heights, heights[r][c], r, c - 1, visited);
        dfs(heights, heights[r][c], r + 1, c, visited);
        dfs(heights, heights[r][c], r - 1, c, visited);

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        

        ROWS = heights.length;
        COLS = heights[0].length;

        visitedPacific = new boolean[ROWS][COLS];
        visitedAtlantic = new boolean[ROWS][COLS];

        for (int j = 0; j < COLS; j++) {
            // first row - all columns
            dfs(heights, heights[0][j], 0, j, visitedPacific); // pacific side - north - upper side

            // last row - all columns
            dfs(heights, heights[ROWS - 1][j], ROWS - 1, j, visitedAtlantic); // atlantic side - south - bottom side
        }

        for (int i = 0; i < ROWS ; i++) {
            // all rows - first column
            dfs(heights, heights[i][0], i, 0, visitedPacific); // pacific side - west - left side

            // all rows - last column
            dfs(heights, heights[i][COLS - 1], i, COLS - 1, visitedAtlantic); // atlantic side - east. - right side
        }


        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            System.out.println("Row-> ");
            for (int j = 0; j < COLS; j++) {
                int[] coordinates = {i, j}; 

                if (visitedPacific[i][j] && visitedAtlantic[i][j]) {
                    List<Integer> coordinatesList = new ArrayList<>();
                    coordinatesList.add(i);
                    coordinatesList.add(j);
                    result.add(coordinatesList);
                }
            }
        }

        return result;

    }
}