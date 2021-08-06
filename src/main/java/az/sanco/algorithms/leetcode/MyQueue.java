package az.sanco.algorithms.leetcode;

import java.util.Stack;

/**
 * Created by sanco on 27.07.21.
 * algorithms
 */
class MyQueue {
    private Stack<Integer> head;
    private Stack<Integer> tail;

    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        mq.push(1);
        mq.push(2);
        mq.push(3);
        mq.push(4);
        mq.pop();
        mq.push(5);
        mq.pop();
        mq.pop();
        mq.pop();
        mq.pop();
    }

    /** Initialize your data structure here. */
    public MyQueue() {
        head = new Stack<Integer>();
        tail = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(head.isEmpty()){
            head.push(x);
        }else{
            tail.push(x);
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int x = head.pop();

        if(head.isEmpty()) {
            while (!tail.isEmpty())
                head.push(tail.pop());
        }
        return x;
    }

    /** Get the front element. */
    public int peek() {
        return head.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return head.isEmpty() && tail.isEmpty();
    }
}
