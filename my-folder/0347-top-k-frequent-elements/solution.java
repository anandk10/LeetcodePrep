class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // My solution
        // Compute frequency counts 
        // Priority Queue to pop k frequent elements

        // Optimized Solution
        // Compute frequence counts
        // Array whose index indicates frequency
        // values are the actual elements of that frequency
        

        // frequency maps
        // Map<Integer, Integer> counts = new HashMap<>();
        // for (int i=0 ; i<nums.length; i++) {
        //     int new_freq = counts.getOrDefault(nums[i], 0) + 1;
        //     counts.put(nums[i], new_freq);
        // }

        // List<List<Integer>> invertedCounts = new ArrayList<>(nums.length+1);
        // for (int i=0; i < nums.length+1; i++) {
        //     invertedCounts.add(new ArrayList<>());
        // }

        // for(Map.Entry<Integer, Integer> entry : counts.entrySet()) {
        //     int j = entry.getValue();
        //     invertedCounts.get(j).add(entry.getKey());
        // }

        // int[] result = new int[k];
        // int res_idx = 0;
        // for (int j = nums.length; k > 0 && j > 0; j--) {
        //     List<Integer> values = invertedCounts.get(j);
        //     if (!values.isEmpty()) {
        //         for (int l=0; l<values.size() && k > 0; l++) {
        //             result[res_idx] = values.get(l);
        //             res_idx++;
        //             k--;

        //         }
                
        //     }
        // }

        // return result;



        // Refactored solution 
        // 24

        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        //  Invert frequency map

        // List<Integer>[] invertedCounts = new int[nums.length + 1];
        List<Integer>[] invertedCounts = new ArrayList[nums.length + 1];

        for (int key : counts.keySet()) {
            int fre = counts.get(key);
            if (invertedCounts[fre] == null) {
                invertedCounts[fre] = new ArrayList<>();
            }
            invertedCounts[fre].add(key);

        }

        int[] result = new int[k];

        for(int end = invertedCounts.length - 1;
                    end > 0 && k > 0; 
                    end--) {
            if(invertedCounts[end] != null) {
                List<Integer> values = invertedCounts[end];

                for (int val : values) {
                    if (k > 0) {
                        // because there is a guarantee of unique answer
                        // we will rely on k 
                        result[k-1] = val;
                        k--;
                    }
                }
            }

        }

        return result;





    }
}
