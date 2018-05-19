package leetcode.search;

import java.util.ArrayList;

/* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()" */
public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result=new ArrayList();
        StringBuffer res=new StringBuffer();
        String resstr=new String();
        dfs(n,n,resstr,result);
        return result;
    }
    public void dfs(int left,int right,String res,ArrayList<String> result){
        if(left<0||right<0||left>right){
            return;
        }
        if(left==0&&right==0){
            result.add(res.toString());
            return;
        }
        dfs(left-1,right,res+'(',result);
        dfs(left,right-1,res+')',result);
    }
    //TODO 有错误没有删除上一步的缓存
    public void dfs1(int left,int right,StringBuffer res,ArrayList<String> result){
        if(left<0||right<0||left>right){
            return;
        }
        if(left==0&&right==0){
            result.add(res.toString());
            return;
        }
        dfs1(left-1,right,res.append('('),result);
        dfs1(left,right-1,res.append(')'),result);
    }
    public static void main(String[] args){
        ArrayList<String> res=new ArrayList<>();
        GenerateParentheses t=new GenerateParentheses();
        res=t.generateParenthesis(2);
        for(String str:res){
            System.out.println(str);
        }
    }
}
