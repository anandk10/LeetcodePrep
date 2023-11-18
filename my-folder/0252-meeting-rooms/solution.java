class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        /**
        We're given intervals
        sort it according to the start time
        the task is to find overlap. if there's
        an overlap then the person will not be able to attend
        all the meetings
         */

        Arrays.sort(intervals, 
            (int1, int2) -> Integer.compare(int1[0], int2[0]));


        for (int i = 1; i < intervals.length; i++){
            // current's start < previous end time
            if (intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }
        return true;
    }
}
