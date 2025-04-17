package io.dsa.miscQ;

import java.util.Stack;

class QueueUsingStack {
    private Stack<Integer> input;
    private Stack<Integer> output;

    QueueUsingStack() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!(input.isEmpty())) {
                int element = input.pop();
                output.push(element);
            }
        }
        return output.peek();
    }

    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }

    public int pop() {
        peek();
        return output.pop();
    }
}