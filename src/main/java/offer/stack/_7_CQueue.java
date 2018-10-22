package offer.stack;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 *
 */
public class _7_CQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }
    private void shiftStacks(){
        //一次性将栈中所有的结点都倒入到辅助栈中；只有在辅助栈是空的情况下才执行倒入
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
    }
    public int pop() {
        shiftStacks();
        return stack2.pop();
    }
}
