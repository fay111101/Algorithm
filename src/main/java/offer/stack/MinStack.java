package offer.stack;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class MinStack {
    Stack<Integer> stack=new Stack<Integer>();
    Stack<Integer> min=new Stack<Integer>();

    public void push(int node) {
        stack.push(node);
        if(min.isEmpty()){
            min.push(node);
        }else{
            int minV=min.peek();
            if(minV>node){
                min.push(node);
            }else{
                min.push(minV);
            }
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return  stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
