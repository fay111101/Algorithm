package offer.stack;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序， * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class _22_IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA){
        if(pushA==null||popA==null||pushA.length!=popA.length||pushA.length==0){
            return false;
        }
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(pushA[0]);
        int i=0,j=0;
        while(!stack.isEmpty()){

            if(stack.peek()==popA[j]){
                stack.pop();
                j++;
                continue;
            }
            if(++i<pushA.length){

                stack.push(pushA[i]);
            }else{
                break;
            }
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
