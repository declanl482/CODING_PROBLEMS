class MinStack {

    // The idea is to maintain the stack as a singly-linked list of Node objects, where each node contains the current value of the node alongside
    // the minimum value for the entire stack.

    // Insertion and deletion (popping and pushing), as well as accessing the top and the minimum value (top and getMin) will all take place at the head,
    // giving us constant-time insertion, deletion, and access.

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