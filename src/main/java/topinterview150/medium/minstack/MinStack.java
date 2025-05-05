package topinterview150.medium.minstack;

import java.util.LinkedList;

class MinStack {

    private final LinkedList<Node> stack;

    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int val) {
        int min = val;
        if(!stack.isEmpty()) {
            min = Math.min(val, stack.getLast().min);
        }

        stack.add(new Node(val, min));
    }

    public void pop() {
        stack.removeLast();
    }

    public int top() {
        return stack.getLast().val;
    }

    public int getMin() {
        return stack.getLast().min;
    }

    private static class Node {
        private int val;
        private int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }

        public int getVal() {
            return val;
        }

        public int getMin() {
            return min;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}