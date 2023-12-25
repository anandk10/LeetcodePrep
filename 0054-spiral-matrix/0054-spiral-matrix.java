class Solution {

    /**
    Idea here is to move horizontally (update j) then vertically (update i)
    for a single iteration this will look like
    #####
        #
        #
        # 
    
    Horizontal traversal - processes a ROW therefore decrement ROW count
    Vertical traversal - processes a COL therefore decrement COL count
    (NO NEED TO BOUNDRY CHECK!!)
    
    then flip the direction to negative, by multiplying it by -1
    Repeat the same traversal, horizontal (update j) then vertical (update i)
    for the next iteration this will look like
    
    #
    #
    #####  

     */
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int direction = 1;
        
        int i = 0, j = -1;
        List<Integer> result = new ArrayList<>();
        int totalElements = m * n;
        
        while (result.size() != totalElements) {
            // move horizontally
            for (int x = 0; x < n; x++) {
                j += direction;
                result.add(matrix[i][j]);
            }
            
            // consumed a row, now decrement m
            m -= 1;
            
            // move vertically
            for (int x = 0; x < m; x++) {
                i += direction;
                result.add(matrix[i][j]);
            }
            
            // consumed a column, now decrement n
            n -= 1;
            
            // switch the direction
            direction = direction * -1;            
        }
        return result;
    }
}