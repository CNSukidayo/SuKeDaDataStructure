package cnsukidayo.com.gitee.leetcode;

class MinStack {

    IStack iStack = new IStack();
    IStack minStack = new IStack();
    int min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int val) {
        iStack.push(val);
        if (val <= min) {
            min = val;
            minStack.push(val);
        }
    }

    public void pop() {
        int top = iStack.top();
        iStack.pop();
        if (top == minStack.top()) {
            minStack.pop();
        }
        if (minStack.top != null) {
            min = minStack.top();
        } else {
            min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return iStack.top();
    }

    public int getMin() {
        return minStack.top();
    }

private static class IStack {

    private Node top = null;

    public int top() {
        return top.value;
    }

    public void pop() {
        top = top.pre;
    }

    public void push(int value) {
        Node node = new Node(value, top);
        top = node;
    }
}

private static class Node {
    private int value;
    private Node pre;

    public Node(int value, Node pre) {
        this.value = value;
        this.pre = pre;
    }
}

}
