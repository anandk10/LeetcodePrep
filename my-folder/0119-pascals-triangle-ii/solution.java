class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> result = new ArrayList<>(rowIndex + 1) {
            { add(1); }     // init the array , add is the list operation
        };

        for (int i = 1; i <= rowIndex; i++) {
            
            for (int j = result.size() - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
            result.add(1);
        }


        return result;


        /**
        1
        
        1,1


        1,1
        1,2,1

        to compute the next row just focus on the previous row
        1,2,1
        append 1 (or you can choose to append after performing the update)
        1,2,1,1
           \|
        1,2,3,1

        1,2,3,1
         \|
        1,3,3,1

        1,3,3,1
        append 1

        1,3,3,1,1

        1,3,3,1,1
             \|
        1,3,3,4,1

        1,3,3,4,1
           \|
        1,3,6,4,1

        1,3,6,4,1
         \|
        1,4,6,4,1

        1,4,6,4,1
        append 1
        1,4,6,4,1,1

        1,4,6,4,1,1
               \| 
        1,4,6,4,5,1
        
        1,4,6,4,5,1
             \| 
        1,4,6,10,5,1

        1,4,6,10,5,1
           \| 
        1,4,10,10,5,1

        1,4,10,10,5,1
         \| 
        1,5,10,10,5,1
        
         */

    }
}
