class Solution {
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