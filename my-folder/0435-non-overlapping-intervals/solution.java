class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, 
         (int1, int2) -> Integer.compare(int1[0], int2[0]));

        // Now that the intervals are sorted we can 
        // choose the 0th as our starting point and treat it
        // as valid. We're interested in its end time
        int prevEnd = intervals[0][1];

        // counter for removals
        int removalCounts = 0;

        // keep comparing adjacent intervals
        // if overlap there has to be atleast one removal
        // remove the interval that has the max end time, 
        // since that would avoid any future overlaps
        for(int i = 1; i < intervals.length; i++) {
            if (prevEnd <= intervals[i][0]) {
                // non overlapping
                // curr interval's start is equal or greater
                // than previous end time
                
                // update the prevEnd time
                prevEnd = intervals[i][1];
            } else {
                // overlapping
                removalCounts += 1;
                
                // update the prevEnd time
                // we're removing the interval with maximum end time
                // so update the prevEnd to the minimum out of the overlapping 
                // interval.
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            }

        }
        return removalCounts;
        


    }
}
