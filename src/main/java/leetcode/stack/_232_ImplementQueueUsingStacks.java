package leetcode.stack;

import java.util.LinkedList;

/**
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes:
 *
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class _232_ImplementQueueUsingStacks {


}
class MyQueue {

    /** Initialize your data structure here. */
    static LinkedList stack1;
    static LinkedList stack2;

    public MyQueue() {
        stack1=new LinkedList();
        stack2=new LinkedList();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.addFirst(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.size()==0){
            while(stack1.size()!=0){
                stack2.addFirst(stack1.removeFirst());
            }

        }
        return (Integer)stack2.removeFirst();
    }

    /** Get the front element. */
    public int peek() {
        if(stack2.size()==0){
            while(stack1.size()!=0){
                stack2.addFirst(stack1.removeFirst());
            }

        }
        return (Integer)stack2.peekFirst();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack1.size()==0&&stack2.size()==0)
            return true;
        else
            return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */