class Solution {

    public int[][] merge(int[][] intervals) {
        
        List<int[]> listOutput = new ArrayList<>();
        Arrays.sort(intervals, 
                (interval1, interval2) -> Integer.compare(interval1[0], interval2[0]));
        int[] newInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            // if the newInterval is before
            if (newInterval[1] < intervals[i][0]) {
                listOutput.add(newInterval);
                newInterval = intervals[i];
            } else if (intervals[i][1] < newInterval[0]) {
                // if the newInterval is after
                listOutput.add(intervals[i]);
            } else {
                // merge the intervals
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        listOutput.add(newInterval);

        return listOutput.toArray(new int[listOutput.size()][]);

    }
}
