class Solution {

    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> listOutput = new ArrayList<>();

        int idx = 0;
        for (int i = 0; i < intervals.length; i++) {
            
            // if the newInterval occurs before the interval
            if (newInterval[1] < intervals[i][0]) {
                // end of new < start of existing
                // output[idx++] = newInterval;
                listOutput.add(newInterval);
                // add rest of the intervals to the output
                for (; i < intervals.length; i++) {
                    // output[idx++] = intervals[i];
                    listOutput.add(intervals[i]);
                }
                // return output;
                return listOutput.toArray(new int[listOutput.size()][]);
            }

            // if the newInterval is after i.e. interval[i] is before the
            // newInterval
            if (intervals[i][1] < newInterval[0]) {
                // add the interval to the output
                listOutput.add(intervals[i]);
            } else {
                // overlap scenario
                
                // update the newInterval to merge the interval[i] and newInterval
                // widen the interval by updating start and end
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }

        }

        // if the merged newInterval never occurs before any existing interval
        // we will miss adding that in the output
        // Thus now add that newInterval to the output
        listOutput.add(newInterval);

        return listOutput.toArray(new int[listOutput.size()][]);

    }
}
