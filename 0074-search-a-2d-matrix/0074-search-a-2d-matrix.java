class Solution {
    // 0.  1.  2
    // 10, 20, 30.  0
    // 40, 50, 60   1

    // 10, 20, 30, 40, 50, 60
    // 0.  1.  2.  3.  4.  5

    // mid = 3. (1,0)
    // mid / 3 = 1
    // mid % 3 = 0



    private static boolean binarySearch(final int[][] matrix, 
        int lower, 
        int upper, 
        final int target) {
            // base condition
            if (lower > upper) return false;

            int mid = lower + (upper - lower) / 2;
            int i = mid / matrix[0].length;
            int j = mid % matrix[0].length;

            if (matrix[i][j] == target) return true;

            if (matrix[i][j] < target) {
                // right subarray
                return binarySearch(matrix, mid + 1, upper, target);
            } else {
                // left subarray
                return binarySearch(matrix, lower, mid - 1, target);
            }


    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;  // number of rows
        int n = matrix[0].length - 1;  // number of columns

        // Since the first integer on every row is > the last integer of prev row
        // Can consider this matrix to be a logical single dimensional array
        // and apply simple binary search on it. 

        int lower = 0;
        int upper = matrix.length * matrix[0].length - 1;

        return binarySearch(matrix, lower, upper, target);
    }

    
}