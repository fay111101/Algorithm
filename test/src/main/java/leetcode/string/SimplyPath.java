package leetcode.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*Given an absolute path for a file (Unix-style), simplify it.
For example,
path ="/home/", =>"/home"
path ="/a/./b/../../c/", =>"/c"
click to show corner cases.
Corner Cases:
//来自https://www.cnblogs.com/grandyang/p/4347125.html
Did you consider the case where path ="/../"?
In this case, you should return"/".
Another corner case is the path might contain multiple slashes'/'together,
such as"/home//foo/".
In this case, you should ignore redundant slashes and return"/home/foo".*/
public class SimplyPath {


    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        String[] p = path.split("/");
        for (String t : p) {
            if (!s.isEmpty() && t.equals("..")) {
                s.pop();
            } else if (!t.equals(".") && !t.equals("") && !t.equals("..")) {
                s.push(t);
            }
        }
        List<String> list = new ArrayList<>(s);
        return "/" + String.join("/", list);//jdk8新方法String.join()
    }
}
