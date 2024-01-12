class Solution {

    /**
    The borders of the matrix would not hold the water 
    So the shortest value of the wall will be the starting point

    1. offer all the edges to the Priority Queue (sorted by height of Cell)
    2. poll a cell from the PQ
    3. check its 4 neighbors
    4. if its valid and unvisited and the neighbor height < polled cell's height then
                5. add to res because it can hold water
    6. offer the updated height to the heap
            // add this neighbor to the minHeap 
            // for the height, we consider whichever is taller
            // so either the current Cell's height is taller or
            // we found a neighbor cell which is taller than the current
            // cell, in which case that will be our new bound of holding water

     */
    
    int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    class Cell {
        int row;
        int col;
        int height;
        Cell(int r, int c, int h) {
            this.row = r;
            this.col = c;
            this.height = h;
        }

        public String toString() {
            return "("+row+","+col+","+height+")";
        }
    }

    public int trapRainWater(int[][] heightMap) {

        Queue<Cell> minHeap = new PriorityQueue<>(
            (cell1, cell2) -> (cell1.height - cell2.height)
        );

        int ROWS = heightMap.length;
        int COLS = heightMap[0].length;

        boolean[][] visited = new boolean[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            Arrays.fill(visited[i], false);
        }

        // offer all the border cells to the minheap
        for (int i = 0; i < ROWS; i++) {

            for (int j = 0; j < COLS; j++) {

                if ((i == 0 || i == ROWS - 1) ||
                    (j == 0 || j == COLS - 1)) {
                        // System.out.println(i + ", " + j);
                        minHeap.offer(new Cell(i, j, heightMap[i][j]));
                        visited[i][j] = true;
                } 
            }
        }

        // System.out.println(visited);

        // System.out.println(minHeap);

        int res = 0;
        while (!minHeap.isEmpty()) {

            Cell cell = minHeap.poll();

            for (int[] dir : dirs) {

                int r = cell.row + dir[0];
                int c = cell.col + dir[1];
                
                if (r < 0 || r == ROWS ||
                    c < 0 || c == COLS ||
                    visited[r][c]) {
                        continue;
                    }
                
                // mark this visited
                visited[r][c] = true;
                
                // add to the res only if the neighbor can store water
                
                // The max() ensures we will only entertain the positives
                // i.e if neighbor is at lower height then the difference
                // will be positive
                res = res + Math.max(0, cell.height - heightMap[r][c]);

                // add this neighbor to the minHeap 
                // for the height, we consider whichever is taller
                // so either the current Cell's height is taller or
                // we found a neighbor cell which is taller than the current
                // cell, in which case that will be our new bound of holding water
                minHeap.offer(new Cell(r, c, Math.max(cell.height, heightMap[r][c])));

            }
        }

        return res;
    }


}