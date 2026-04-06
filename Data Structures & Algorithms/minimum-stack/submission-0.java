class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> aideStack;

    public MinStack() {
        stack = new Stack<>();
        aideStack = new Stack<>();

    }
    
    public void push(int val) {
        if (aideStack.isEmpty()) aideStack.push(val);
        else {
            int min = aideStack.peek();
            if (val <= min) aideStack.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
        int p = stack.pop();
        if (aideStack.peek() == p) aideStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() { 
        return aideStack.peek();
    }
}
