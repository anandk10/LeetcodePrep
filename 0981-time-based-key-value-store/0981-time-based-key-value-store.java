class TimeMap {

    class Entry {
        String value;
        int timestamp;
        Entry(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }

        public String toString() {
            return "["+value + ", " + timestamp +"]";
        }
    }

    Map<String, List<Entry>> kvStore;

    public TimeMap() {
        kvStore = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {

        kvStore.computeIfAbsent(key, k -> new ArrayList<>())
               .add(new Entry(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        
        List<Entry> entries = kvStore.get(key);
        
        if (entries == null) {
            return "";
        }

        // perform the binary search on the entry
        int left = 0, right = entries.size() - 1;
        int nextBest = entries.size();
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (entries.get(mid).timestamp <= timestamp) {
                // there could another timestamp 
                // closer to the actual timestamp
                // so try to look in the right
                left = mid + 1;

                // however lets save the current best
                nextBest = Math.min(left, mid);
            } else {
                // the mid timestamp is bigger than 
                // expected timestamp, so now look 
                // for closer timestamp in the left
                right = mid - 1;
            }
        }

        if (nextBest == entries.size()) {
            return "";
        }
        return entries.get(nextBest).value;


    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */