import java.util.AbstractMap.SimpleEntry;

/**

Three things to leverage:
1) SORTED ARRAYS - the answer can be derived from either ends 
(if the same problem asks MAX SUM pair but gives INCREASING ordered array - then start from the right of the arrays)
2) HEAP - use it to get the next best MAX / MIN sum
    - store the state in the heap like, the sum, the indices that made it possible
3) SET - use it to prevent the indices from consideration if they have already been a part of the heap
    JAVA: Composite Key involving a key -> value construct, is a pain when it comes to comparison. If you intend to use your own class then its a hassle to implement and usually a higher chance to get it wrong. 
    Unless you depend on JavaFx which provides a Pair class, you've another option by utilizing Map.Entry<K, V> and its concrete implmentation AbstractMap.SimpleEntry<K, V>. Applies for Java 6 and above. 

    import java.util.AbstractMap.SimpleEntry;
    Set<Map.Entry<Integer, Integer>> visited = new HashSet<>(); 
    visited.add(new SimpleEntry<>(1,2));
    visited.contains(new SimpleEntry<>(1,2)); // returns true

    In Java 9+, leverage Map.entry(k, v) to achieve the same effect

    Set<Map.Entry<Integer, Integer>> visited = new HashSet<>(); 
    visited.add(Map.entry(2,3));
    visited.contains(Map.entry(2,3)); // returns true

 */

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        // storing [sum, i, j] where 
        // sum is nums1[i] + nums2[j]
        // i is index from nums1 and j is from nums2
        
        Queue<int[]> minHeap = new PriorityQueue<>(
            (entry1, entry2) -> (entry1[0] - entry2[0])
        );

        minHeap.offer(new int[] {nums1[0] + nums2[0], 0, 0});
        visited.add(new SimpleEntry<>(0, 0)); // recording visited indices

        while (k > 0 && !minHeap.isEmpty()) {

            // pop the next minimum sum
            int[] nextMin = minHeap.poll();
            int i = nextMin[1];
            int j = nextMin[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            // prepare to add the next possibilities

            // if there are still numbers is nums1
            if (i + 1 < nums1.length && !visited.contains(new SimpleEntry<>(i + 1, j))) {
                minHeap.offer(new int[] {nums1[i + 1] + nums2[j], i + 1, j});
                visited.add(new SimpleEntry<>(i + 1, j));
            }

            if (j + 1 < nums2.length && !visited.contains(new SimpleEntry<>(i, j + 1))) {
                minHeap.offer(new int[] {nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(new SimpleEntry<>(i, j + 1));
            }
        }

        return result;
    }
}