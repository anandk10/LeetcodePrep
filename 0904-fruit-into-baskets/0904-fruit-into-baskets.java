class Solution {
    
    private int totalFruits(int[] fruits) {
        int total = 0;
        
        int upper = 0 ;
        Set<Integer> bucket = new HashSet<>();
        
        for (int lower = 0 ; lower < fruits.length && upper < fruits.length; ) {
            
            if (bucket.contains(fruits[upper])) {
                
                total = Math.max(total, upper - lower + 1);
                // System.out.println("Already present..." + fruits[upper]);
                upper++;
                
                
            } else {
                
                if (bucket.size() == 2) {
                    // earlier element was already seen before
                    upper--;
                    
                    // bring the upper to the left, until the same fruit type is repeating.
                    // 3 1 3 1 1 2 1
                    // i     j  <j
                    //.     i,j
                    while (upper > 0 && fruits[upper] == fruits[upper - 1]) {
                        // bucket.remove(fruits[upper]);
                        upper--;
                    }
                    // System.out.println("Reseting upper ... " + upper);
                    lower = upper;
                    // bucket.remove(fruits[upper]);
                    // System.out.println("Reseting lower ... " + lower);
                    // start the window again - afresh
                    bucket.clear();
                    // System.out.println("Buckets size " + bucket.size());
                    
                } else {
                    bucket.add(fruits[upper]);
                    // System.out.println("Adding..." + fruits[upper]);
                    total = Math.max(total, upper - lower + 1);
                    // System.out.println("Total : " + total);
                    upper++;
                }
                
                
                
                
            }
            
        }
        
        
        return total;
        
    }
    public int totalFruit(int[] fruits) {
        return totalFruits(fruits);
    }
}