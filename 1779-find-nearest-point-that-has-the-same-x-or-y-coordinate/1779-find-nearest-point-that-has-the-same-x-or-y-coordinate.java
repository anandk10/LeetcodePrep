class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        
        int minDist = Integer.MAX_VALUE;
        int idx = -1;
        int res = -1;
        // iterate
        // if valid
        // compute manhattan dist
        // check if minimum? update the index

        // for (int[] point : points) {
        //     idx += 1;
        //     if (isValid(x, y, point)) {
        //         int currDist = computeManhattanDistance(x, y, point);
        //         if (currDist < minDist) {
        //             minDist = currDist;
        //             res = idx;
        //         } 
        //     } 
        // }

        for (int i = 0; i < points.length; i++) {
            if (isValid(x, y, points[i])) {
                int currDist = computeManhattanDistance(x, y, points[i]);
                if (currDist < minDist) {
                    minDist = currDist;
                    res = i;
                }
            }
        }
        return res;
    }

    private boolean isValid(int x, int y, int[] point) {
        return point[0] == x || point[1] == y;
    }

    private int computeManhattanDistance(int x, int y, int[] point) {
        return Math.abs(point[0] - x) + Math.abs(point[1] - y);
    }
}