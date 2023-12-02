class Solution {

    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int WALL = -1;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList (
        new int[] {1, 0},
        new int[] {-1, 0},
        new int[] {0, 1},
        new int[] {0, -1}
    );
    

    public void wallsAndGates(int[][] rooms) {
        
        int m = rooms.length;
        if (m == 0) return;

        int n = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // traverse the rooms and add gates to the queue
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) { continue; }
                rooms[r][c] = rooms[row][col] + 1;
                queue.offer(new int[] {r, c});
            }
        }


    }
}
