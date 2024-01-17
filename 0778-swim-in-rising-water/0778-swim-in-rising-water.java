class Solution {
    /**
    PriorityQueue to pick the next least cell
     */

    class Cell implements Cloneable {
        int h, r, c;

        Cell() {
            this.h = 0;
            this.r = 0;
            this.c = 0;
        }

        Cell(int h, int r, int c) {
            this.h = h;
            this.r = r;
            this.c = c;
        }

        public String toString() {
            return "Cell ("+ h + ", " + r + ", " + c + ")"; 
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Cell cell = (Cell) obj;
            return r == cell.r && c == cell.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

        @Override
        public Cell clone() {
            try {
                return (Cell) super.clone();
            } catch (CloneNotSupportedException c) {
                throw new RuntimeException(c);
            }
        }
    }

    public int swimInWater(int[][] grid) {
        int N = grid.length;

        Set<Cell> visited = new HashSet<>();

        Queue<Cell> minHeap = new PriorityQueue<>(
            (cell1, cell2) -> (cell1.h - cell2.h)
        );

        Cell start = new Cell(grid[0][0], 0, 0);
        minHeap.offer(start);
        visited.add(start);

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!minHeap.isEmpty()) {

            Cell current = minHeap.poll();

            if (current.r == N - 1 && current.c == N - 1) {
                // goal
                return current.h;
            }

            Cell n = new Cell();
            for (int[] dir : dirs) {
                
                n.r = current.r + dir[0];
                n.c = current.c + dir[1];

                if (n.r < 0 || n.r == N ||
                    n.c < 0 || n.c == N ||
                    visited.contains(n)) {
                    continue;
                }

                n.h = Math.max(current.h, grid[n.r][n.c]);
                minHeap.offer(n.clone());
                visited.add(n.clone());
            }

        }
        return -1;
    }
}