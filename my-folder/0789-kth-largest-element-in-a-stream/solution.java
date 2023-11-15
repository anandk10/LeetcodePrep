class KthLargest {

    PriorityQueue<Integer> minHeap;
    int kth;
    public KthLargest(int k, int[] nums) {
        // maxHeap = new PriorityQueue<>( (a, b) -> Integer.compare(b, a) );
        minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
        }

        while (minHeap.size() > k) {
            // System.out.println("Removing : " + minHeap.peek());
            minHeap.poll();
        }

        System.out.println(minHeap);
        kth = k;
    }
    
    public int add(int val) {

        minHeap.offer(val);
        while (minHeap.size() > kth) {
            // System.out.println("Removing : " + minHeap.peek());
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
