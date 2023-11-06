// import java.util.*;

class MinStack {

    class Entry{
        Integer key;
        Integer value;
        Entry(Integer key, Integer value) {
            this.key = key; 
            this.value = value;
        }
        Integer getKey() { return this.key; }
        Integer getValue() { return this.value; }
        void setValue(int val) { this.value = val; }
    }

    private Stack<Entry> minStack;
    public MinStack() {
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        Entry element = new Entry(val, val);
        if (!minStack.isEmpty()) {
            Integer currMinVal = minStack.peek().getValue();
            if (val > currMinVal) {
                element.setValue(currMinVal);
            }
        }
        minStack.push(element);
    }
    
    public void pop() {
        if (!minStack.isEmpty()) {
            minStack.pop();
        }
    }
    
    public int top() {
        if (!minStack.isEmpty()) {
            return minStack.peek().getKey();
        }
        return Integer.MIN_VALUE;
    }
    
    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek().getValue();
        }
        return Integer.MIN_VALUE;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
