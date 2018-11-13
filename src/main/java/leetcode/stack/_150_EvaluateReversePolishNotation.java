package leetcode.stack;

import java.util.Stack;

/**
 * 根据逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 *
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class _150_EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack=new Stack<>();
        for(String token:tokens){
            if(token.equals("+")||token.equals("-")||token.equals("*")
                    ||token.equals("/")){
                   int  b=stack.pop();
                   int  a=stack.pop();
                   stack.push(operation(token,a,b));
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    public int operation(String token,int a,int b){
        int result=0;
        switch (token){
            case "+":
                result=a+b;
                break;
            case "-":
                result=a-b;
                break;
            case "*":
                result=a*b;
                break;
            case "/":
                result=a/b;
                break;
            default:
                return 0;
        }
        return result;
    }
    public static void main(String[] args){
        String[] arr={"2", "1", "+", "3", "*"};
        _150_EvaluateReversePolishNotation test=new _150_EvaluateReversePolishNotation();
        System.out.println(test.evalRPN(arr));

    }
}
