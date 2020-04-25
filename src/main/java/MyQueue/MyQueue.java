package MyQueue;

import java.util.Stack;

/**
 * 用栈实现队列
 * 核心思想：队列是FIFO的，因此需要每次插入新值的时候，将新插入值移动到栈的顶部，
 * 从而实现先进先出（需要用到两个栈）
 */
public class MyQueue {

    //主要存储数据
    private Stack<Integer> s1;
    //用于临时存储数据
    private Stack<Integer> s2;

    private int front;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.s1 = new Stack<Integer>();
        this.s2 = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.empty())
            front = x;
        while (!s1.isEmpty())
            s2.push(s1.pop());
        s2.push(x);
        while (!s2.isEmpty())
            s1.push(s2.pop());
    }



    /** Removes the element from in front of queue and returns that element. */
    public void pop() {
        s1.pop();
        if (!s1.empty())
            front = s1.peek();
    }


    /** Get the front element. */
    public int peek() {
        return front;

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}
