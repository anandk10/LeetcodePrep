class LRUCache {

    /**
    The principle is to achieve faster lookup so utilizing a Map data structure.
    Also achieving faster cache eviction by using doubly linked list. 
     */

    Map<Integer, Node> cache;
    Node head; 
    Node tail;

    class Node {
        int key; int val;
        Node prev; 
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val  = val;
            this.next = null;
            this.prev = null;
        }
    }

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node hit = cache.getOrDefault(key, new Node(-1,-1));
        if (hit.val != -1) {
            markRecentAccess(hit);
        }

        return hit.val;
    }
    
    public void put(int key, int value) {
        
        Node hit = this.cache.getOrDefault(key, new Node(-1, -1));
        if (hit.val == -1) {
            // new entry
            hit = new Node(key, value);
        } else {
            hit.val = value; // assign new value
            removeNode(hit);
        }

        addToCache(hit);
        addToFront(hit);

        if (cache.size() > capacity) {
            removeFromCache(tail.prev);
            removeNode(tail.prev);
        }
    }

    private void markRecentAccess(Node hit) {
        removeNode(hit);
        addToFront(hit);
    }

    private void removeNode(Node hit) {
        hit.prev.next = hit.next;
        hit.next.prev = hit.prev;
    }

    private void addToFront(Node hit) {
        hit.next = head.next;
        hit.prev = head;
        head.next.prev = hit;
        head.next = hit;
    }

    private void addToCache(Node newEntry) {
        cache.put(newEntry.key, newEntry);
    }

    private void removeFromCache(Node oldestEntry) {
        cache.remove(oldestEntry.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */