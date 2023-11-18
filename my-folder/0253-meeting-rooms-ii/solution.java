class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        // Sort both start and end

        Arrays.sort(startTimes); // O(n.log(n))

        Arrays.sort(endTimes);// O(n.log(n))

        int maxRoomCount = 0;
        int currRoomCount = 0;

        // [[0,30],[5,10],[15,20]]
        // startTimes = 0,5,15
        // endTimes = 10,20,30

        // O(n)
        for (int i = 0, j = 0; i < intervals.length && j < intervals.length;) {

            if (startTimes[i] < endTimes[j]) {
                // startTimes[i] < endTimes[j] that means,
                // a meeting started before some ongoing meeting ended
                // this will need a room 
                currRoomCount++;
                // since meeting is started, go to the next startTime
                i++;
            } else {
                // startTimes[i] >= endTimes[j]
                // some meeting starts after some meeting ends
                // room is freed
                currRoomCount--;
                // considered the endTimes as a meeting 
                // thats completed
                j++;
                // and startTimes[i] hasn't really started yet
            }
            
            maxRoomCount = Math.max(currRoomCount, maxRoomCount);

        }

        return maxRoomCount;

    }
}
