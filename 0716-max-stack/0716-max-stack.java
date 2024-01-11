import java.util.NavigableMap;

class MaxStack {

    // DLL
    class Node {
        int val;
        Node prev;
        Node next;
        Node(int value) {
            this.val = value;
            this.prev = null;
            this.next = null;
        }

        // public String toString() {
        //     return "[" + this.val + "]";
        // }
    }

    class CustomLinkedList {
        Node head;
        Node tail;

        CustomLinkedList() {
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
        }

        // public String toString() {
        //     Node tmp = head.next;
        //     StringBuilder output = new StringBuilder();
        //     List<String> values = new ArrayList();
        //     while (tmp != tail) {
        //         values.add(String.valueOf(tmp.val));
        //         tmp = tmp.next;
        //     }

        //     return values.stream().collect(Collectors.joining("->"));
        // }

        public Node insert(int value) {
            Node newNode = new Node(value);
            newNode.next = tail;
            newNode.prev = tail.prev;
            tail.prev.next = newNode;
            tail.prev = newNode;
            return newNode;
        }

        public Node remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
            return node;
        }

        public Node removeLast() {
            return remove(tail.prev);
        }

        public Node getLast() {
            return tail.prev;
        }
    }

    // NavigableMap<>
    NavigableMap<Integer, List<Node>> lookup;
    CustomLinkedList stack;

    public MaxStack() {
        stack = new CustomLinkedList();
        lookup = new TreeMap<>();
    }
    
    public void push(int x) {
        // add to the CustomLinkedList
        Node insertedNode = stack.insert(x);
        lookup.computeIfAbsent(insertedNode.val, 
                               val -> new ArrayList<>())
                               .add(insertedNode);
    }
    
    public int pop() {

        Node topNode = stack.removeLast();
        lookup.get(topNode.val).removeLast();

        if (lookup.get(topNode.val).isEmpty()) {
            lookup.remove(topNode.val);
        }

        return topNode.val;
    }
    
    public int top() {
        return stack.getLast().val;
    }
    
    public int peekMax() {
        return lookup.lastKey();
    }
    
    public int popMax() {
        Map.Entry<Integer, List<Node>> lastEntry = lookup.lastEntry();
        Node maxNode = lastEntry.getValue().removeLast();
        if (lastEntry.getValue().isEmpty()) {
            lookup.remove(lastEntry.getKey());
        }
        stack.remove(maxNode);
        return maxNode.val;
        
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */