class MinStack {

    class Node {
        int val;
        int min;
        Node next;
        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
    
    Node root;
    
    public MinStack() {
        root = null;
    }
    
    public void push(int val) {    
        if (root == null) {
            root = new Node(val, val);
        }
        else {
            Node node = new Node(val, Math.min(val, root.min));
            node.next = root;
            root = node;
        }
    }
    
    public void pop() {
        root = root.next;
    }
    
    public int top() {
        return root.val;
    }
    
    public int getMin() {
        return root.min;
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