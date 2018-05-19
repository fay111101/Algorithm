package leetcode.stack;

import java.util.Stack;

/*Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are+,-,*,/. Each operand may be an integer or another expression.
Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6*/
public class EvaluateReversePolishNotation {
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
        EvaluateReversePolishNotation test=new EvaluateReversePolishNotation();
        System.out.println(test.evalRPN(arr));

    }
}
