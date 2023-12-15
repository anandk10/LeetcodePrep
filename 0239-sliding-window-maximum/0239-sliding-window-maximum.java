class Solution {
    
    private int[] solution1(int[] nums, int k) {
        /**
        
        The idea here is to maintain a monotonic decreasing queue
        Allow the numbers that are only in decreasing order
        Why?
            The window per se, if it reads an increasing number
            then the output is naturally will be the new number
            However, concerns arise, when a decreasing sequence 
            shows up, and still is a part of window.
        
        So keep the numbers in decreasing order in the queue
        And when setting the output, pop from the front, that WILL
        ensure that the highest valued number is at the front, for that
        window size. 
        */
        
        // lets store the indices of the nums
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> outputList = new ArrayList<>();
        
        int left = 0, right = 0;
        
        while (right < nums.length) {
            
            // evict numbers if the current number is greater 
            // than the one in the front of the queue
            
            // poll smaller values from the deque
            while (!deque.isEmpty() &&  nums[right] > nums[deque.peekLast()] ) {
                // this nums[right] > nums[deque.peekFirst()] means
                // the new number is the maximum number in the current window
                // that's why we are popping or pollingLast()
                deque.pollLast();
            }
            
            // now either the deque is empty or it contains number that 
            // is greater than the current number
            // so offerLast() the index of current number
            
            deque.offerLast(right);
            
            // check if left is pointing to an index that 
            // will oust the left most (or element at the front) of the deque
            // left value is out of bounds
            if (left > deque.peekFirst()) {
                deque.pollFirst();
            }
            
            // now check if the current window size is equally the expected size
            // i.e. left ---> right window == k
            if ((right + 1) >= k) { 
                // you could use (right - left + 1) >= k
                
                // now that we reached the size of the window k
                // we know that the maximum element (due to the monotonic
                // decreasing queue) is at the front.
                // deque.peekFirst() stores the index of the max number
                
                outputList.add(nums[deque.peekFirst()]);
                
                // now that we have processed this window of size k 
                left += 1;
            }
            
            // always increment right 
            right += 1;
        }
        
        return outputList.stream().mapToInt(Integer::intValue).toArray();
        
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        return solution1(nums, k);
    }
}