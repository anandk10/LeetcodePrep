class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;

        // the window of size k is considered for the binary search
        // left is the index 0 and right is length - k
        // stating that the window starting at right is the maximum window 
        // that we could shift upto

        while (left < right) {

            int mid = left + (right - left) / 2;

            // consider the window starting at mid
            // and compare the element just outside
            // this window with x

            int leftWindow = x - arr[mid];
            int rightWindow = arr[mid + k] - x;

            if (rightWindow < leftWindow) {
                // rightWindow is closer to x
                // move towards right
                left = mid + 1;
            } else {
                // leftWindow is closer to x
                // move towards left
                right = mid;
            }
        }

        // once left and right cross over, the left pointer
        // is at the correct point in the array
        // now return the subarray starting from left and containing k numbers
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}