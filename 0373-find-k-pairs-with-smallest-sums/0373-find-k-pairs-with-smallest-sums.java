import java.util.AbstractMap.SimpleEntry;

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