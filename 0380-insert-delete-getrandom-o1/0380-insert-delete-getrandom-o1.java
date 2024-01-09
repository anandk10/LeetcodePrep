class RandomizedSet {

    /**
    We will use a Map and a List
    Map will help with insert and remove
    List will help with getRandom

    Map -> value , index of value in the list
    List -> insert value at the end

    while deleting - 
        find the index in the list
        replace the number with the last element in the list,  O(1)
        and delete the last element from the list - O(1)
        also
        update the Map to point to this new index for the number thats replaced.
    
     */

    Map<Integer, Integer> numMap;
    List<Integer> numList;
    static Random random = new Random();


    public RandomizedSet() {
        numMap = new HashMap<>();
        numList = new ArrayList<>();
    }
    
    public boolean insert(int val) {

        boolean isPresent = numMap.containsKey(val);

        if (!isPresent) {
            // insert into map
            numMap.put(val, numList.size());
            // insert into the list
            numList.add(val);
        }

        // if item was there, then isPresent would be true
        // expectaction is to track if insertion happened
        // that's why !isPresent will be false

        // if item wasn't there, then !isPresent is checked
        // thereby deciding that insertion will happen;
        // in that case - !isPresent will be true
        return !isPresent;
    }
    
    public boolean remove(int val) {

        boolean isPresent = numMap.containsKey(val);

        if (isPresent) {
            // lookup the index
            int idx = numMap.get(val);
            int lastNum = numList.get(numList.size() - 1);
            // replace with the last number
            numList.set(idx, lastNum);

            // remove the last number from the numList
            numList.remove(numList.size() - 1);

            // update the map - replaced number with the new idx
            numMap.put(lastNum, idx);

            // remove the val from the map
            numMap.remove(val);
        }

        return isPresent;

    }
    
    public int getRandom() {

        int idx = random.nextInt(numList.size());
        return numList.get(idx);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */