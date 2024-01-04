class Solution {

    // x,y
    // 1,3.  0
    // -2,-2 1

    // √(x1 - x2)2 + (y1 - y2)2
    // private int computeDist(final int[] pointA) {
    //     return (int) Math.pow((0 - pointA[0]), 2) + (int) Math.pow((0 - pointA[1]), 2);
    // }

    private int computeDist(final int[] pointA) {

        return ( pointA[0] * pointA[0] ) + ( pointA[1] * pointA[1]);
        // return (int) Math.pow((0 - pointA[0]), 2) + (int) Math.pow((0 - pointA[1]), 2);
    }



    public int[][] kClosest(int[][] points, int k) {
        
        Queue<int[]> pq = new PriorityQueue<>(
            (pointA, pointB) -> Integer.compare(pointA[2], pointB[2]));

        for (int i = 0; i < points.length; i++) {
            // System.out.println(computeDist(points[i]));
            int[] pointToPush = { points[i][0], points[i][1], computeDist(points[i]) };
            pq.offer(pointToPush);
        }

        // System.out.println(pq.peek()[0] +","+ pq.peek()[1] +","+ pq.peek()[2]);
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] closestPoint = pq.poll();
            // System.out.println(closestPoint[0] + ", " + closestPoint[1]);
            result[i][0] = closestPoint[0];
            result[i][1] = closestPoint[1];
        }

        return result;
    }


    // kClosest() {

    //     queue = new
    //     iterate over all points
    //     offer to the queue
    //     [x,y,dist(x,y)]
    // }
}