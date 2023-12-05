class StockPrice {


    /**
    Here the approach is to maintain multiple data structures to record the latest price
    and then also to record the minimum and maximum prices of the stock
     */

    Map<Integer, Integer> record;
    Queue<int[]> minPrices;  // storing the price to timestamp
    Queue<int[]> maxPrices;
    int currentTS;

    public StockPrice() {
        record = new HashMap<>();
        minPrices = new PriorityQueue<>((price1, price2) -> price1[0] - price2[0]);
        maxPrices = new PriorityQueue<>((price1, price2) -> price2[0] - price1[0]);
        currentTS = 0;
    }
    
    public void update(int timestamp, int price) {
        // if timestamp doesn't exists is the record
        // then only it is currentTS

        currentTS = Math.max(currentTS, timestamp);

        record.put(timestamp, price);

        // add to the min and max heap as well
        // these are adding entries to the heap irrespective of 
        // if the prices are max / min than the prev values
        minPrices.offer(new int[]{price, timestamp});
        maxPrices.offer(new int[]{price, timestamp});
    }
    
    public int current() {
        return record.get(currentTS);
    }
    
    public int maximum() {

        // we keep removing from the maxPrices heap until we
        
        // consider the top of the heap to be the value
        int[] maxTop = maxPrices.peek();
        
        // see if the prices in the record map match with this
        // timestamp must exists because the timestamp is never updated
        // just the prices, so record.get(maxTop[1]) will return valid value
        while(record.get(maxTop[1]) != maxTop[0]) {
            maxPrices.poll();
            maxTop = maxPrices.peek();
        }

        return maxTop[0];
        
    }
    
    public int minimum() {
        int[] minTop = minPrices.peek();
        while (record.get(minTop[1]) != minTop[0]) {
            minPrices.poll();
            minTop = minPrices.peek();
        }
        return minTop[0];
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
