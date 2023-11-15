class Solution {

    Queue<Integer> maxHeap = new PriorityQueue<>(
        (a, b) -> Integer.compare(b,a)
    );

    //         8
    //       /   \
    //     7       4
    //    / \.    /
    //   1.  2   1

    // y = poll(), x = poll()

    // x <= y
    // 7 <= 8

    // 7 != 8 , 7 is eliminated (x) 
    // y = y - x = 8 - 7 = 1
    // offer(y - x) offer(1)

    // if the top two elements are same, remove both
    // otherwise, the difference needs to be added to the heap
    // do until the size == 1 or empty

    // peek()

    


    

    public int lastStoneWeight(int[] stones) {
        
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            if (x != y) {
                maxHeap.offer(y-x);
            }
        }

        return maxHeap.size() == 1 ? maxHeap.peek() : 0;

    }
}
