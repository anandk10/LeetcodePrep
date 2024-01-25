import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 1) {
            return n;
        }

        int maxPoints = 1;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int duplicate = 0, vertical = 0, localMax = 1;

            for (int j = i + 1; j < n; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];

                if (p1[0] == p2[0] && p1[1] == p2[1]) {
                    duplicate++;
                } else if (p1[0] == p2[0]) {
                    vertical++;
                    localMax = Math.max(localMax, vertical + 1);
                } else {
                    int deltaX = p2[0] - p1[0];
                    int deltaY = p2[1] - p1[1];
                    int gcd = gcd(deltaX, deltaY);

                    String slope = (deltaX / gcd) + "_" + (deltaY / gcd);
                    slopeCount.put(slope, slopeCount.getOrDefault(slope, 1) + 1);
                    localMax = Math.max(localMax, slopeCount.get(slope));
                }
            }

            maxPoints = Math.max(maxPoints, localMax + duplicate);
        }

        return maxPoints;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
