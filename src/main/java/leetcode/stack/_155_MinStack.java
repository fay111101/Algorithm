package leetcode.stack;

import java.util.Stack;

/**
 *  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * _21_MinStack minStack = new _21_MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class _155_MinStack {


}
class MinStack {

    /** initialize your data structure here. */
    Stack minS,dataS;
    public MinStack() {
        minS=new Stack();
        dataS=new Stack();
    }

    public void push(int x) {
        dataS.push(x);
        if(minS.size()==0||x<(Integer)minS.peek()){
            minS.push(x);
        }else{
            minS.push((Integer)minS.peek());
        }
    }

    public void pop() {
        minS.pop();
        dataS.pop();
    }

    public int top() {
        return (Integer)dataS.peek();
    }

    public int getMin() {
        return (Integer)minS.peek();
    }
}
