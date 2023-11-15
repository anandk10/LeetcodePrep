class Solution {

    private int operate(int[] nums, int k) {
        // kth largest - minHeap with k element bound - good if elements are incoming in a stream fashion
        // Queue<Integer> minHeap = new PriorityQueue<>();
        
        // if elements are predefined and limited
        // maxHeap
        Queue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );

        for (int num : nums) {
            // minHeap.offer(num);
            maxHeap.offer(num);
        }

        // while (minHeap.size() > k) {
        //     minHeap.poll();
        // }

        while (k > 1 && !maxHeap.isEmpty()) {
            maxHeap.poll();
            k--;
        }

        return maxHeap.peek();
        // return minHeap.peek();

    }
    public int findKthLargest(int[] nums, int k) {
        return operate(nums, k);
    }
}
