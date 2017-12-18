package leetcode.stack;

import java.util.Stack;

/* Given a string containing just the characters'(',')','{','}','['and']',
determine if the input string is valid.

The brackets must close in the correct order,"()"and"()[]{}"are all valid
but"(]"and"([)]"are not. */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char ch:s.toCharArray()){
            if (ch == '(') {
                stack.push(')');
            }else if(ch=='['){
                stack.push(']');
            }else if(ch=='{'){
                stack.push('}');
            }else if(stack.isEmpty()||stack.pop()!=ch){
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses test = new ValidParentheses();
        String s = "([)]";
        String s1 = "()[]";
        String s2 = "";
        String s3 = "{";
        String s4 = "{[";
        System.out.println(test.isValid(s));
        System.out.println(test.isValid(s1));
        System.out.println(test.isValid(s2));
        System.out.println(test.isValid(s3));
        System.out.println(test.isValid(s4));
    }
}
