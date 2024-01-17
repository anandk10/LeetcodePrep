class Solution {
    /**
    [1,3,4,1,2,3,1]
    frequency counter for each number 
    use that to decide the row of the output matrix

    [1,3,4,1,2,3,1]
       i
     1 - 0 -- defaultCount will be 0, the output lists index will also begin at 0
         (count - 1) 0th row is the row in the matrix
     3 - 1
         (count - 1) 0th row 
    ..same for 4
    
     1 - 2
         (count - 1) 1st row is the row to insert this 1

     */
    public List<List<Integer>> findMatrix(int[] nums) {
        
        Map<Integer, Integer> freqCount = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int expectedRow = freqCount.getOrDefault(nums[i], 0);
            freqCount.put(nums[i], expectedRow + 1);
            if (expectedRow >= result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(expectedRow).add(nums[i]);
            
        }
        return result;
    }
}