package topinterviewquestions.design.minstack;

import java.util.Stack;

public class MinStack {
    private final Stack<MinNode> stack = new Stack<>();

    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(new MinNode(val, val));
        } else {
            MinNode minNode = stack.peek();
            stack.push(new MinNode(val, Math.min(val, minNode.min)));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }

    private static class MinNode {
        int val;
        int min;

        public MinNode(int val, int min) {
            this.val = val;
            this.min = min;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static void main(String[] args) {
        var minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}
