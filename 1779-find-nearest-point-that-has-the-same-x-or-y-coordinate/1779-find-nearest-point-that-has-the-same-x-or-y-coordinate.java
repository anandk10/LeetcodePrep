/**
Given a reference point (x, y) and a list of points.
- Iterate through each point in the list.
- Check if the point is valid (matching either x or y).
- Compute Manhattan distance from the reference point.
- Track the index of the nearest valid point found so far.
- Return the index of the nearest valid point, or -1 if none found.

 */

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        
        int minDist = Integer.MAX_VALUE;
        int idx = -1;
        int res = -1;

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