class BoundedBlockingQueue {
    
    Queue<Integer> queue;
    int capacity;
        
    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }
    
    public synchronized void enqueue(int element) throws InterruptedException {
        while (this.queue.size() == capacity) {
            wait();
        }
        
        this.queue.offer(element);
        notifyAll();
    }
    
    public synchronized int dequeue() throws InterruptedException {
        
        while (this.queue.size() == 0) {
            wait();
        }
        
        int element = this.queue.poll();
        notifyAll();
        return element;
    }
    
    public synchronized int size() {
        return this.queue.size();
    }
}