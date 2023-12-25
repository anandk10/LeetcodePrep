class Solution {
    
    static class Cell {
        int x, y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "("+x+", "+y+")";
        }
    }
    
    static int[][] directions = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}  
    };
    
    public int shortestDistance(int[][] grid) {
        
        int ROWS = grid.length;
        int COLS = grid[0].length;
        
        int[][] distances = new int[ROWS][COLS];
        int finalDist = Integer.MAX_VALUE;
        
        int currentEmptySpot = 0; // will decrement this at very iteration

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                
                // only building matter at this stage
                if (grid[i][j] == 1) {
                    
                    finalDist = Integer.MAX_VALUE;
                    
                    // BFS traversal at every building
                    int steps = 0; // initial from the building to the building it will be 0
                                    // for every neighboring level it will be +1
                    Cell cell = new Cell(i, j);
                    Queue<Cell> queue = new LinkedList<>();
                    
                    queue.offer(cell);
                    
                    while(!queue.isEmpty()) {
                        
                        steps++; // will process the current spot
                                 // so count a step here
                        
                        int size = queue.size();
                        while (! queue.isEmpty() && size > 0 ) {
                            
                            // pop the queue
                            cell = queue.poll();
                            int x = cell.x;
                            int y = cell.y;
                            
                            size--;
                            
                            // enqueue all the neighbors that are valid empty places
                            for(int[] dir : directions) {
                                int r = x + dir[0];
                                int c = y + dir[1];
                                
                                // validity of the cell
                                if (r == ROWS || c == COLS || r < 0 || c < 0 ||
                                   grid[r][c] != currentEmptySpot) {
                                    continue; // don't engage
                                }
                                
                                // enqueue the neighbor
                                queue.offer(new Cell(r, c));
                                
                                // marking visited by the current building
                                grid[r][c] -= 1; // makes the value negative
                            
                                // increment the distance
                                distances[r][c] += steps;
                                
                                // minimum final distance
                                finalDist = Math.min(finalDist, distances[r][c]);
                                
                                // for the current building finalDist indicates the least distance amongst all its neighbors
                                // for every other building's starting point, the distance[r][c] for its neighbors will be potentially very high if its is visited by prior building
                            }
                            
                        }
                        
                    }
                    
                    currentEmptySpot--;
                }
                
            }
        }
        
        return finalDist == Integer.MAX_VALUE ? -1 : finalDist;
        
    }
}