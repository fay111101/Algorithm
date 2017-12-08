package leetcode.dfsbacktracing;

import java.util.ArrayList;

/**
 * Created by fay on 2017/12/6.
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 For example:
 Given"25525511135",
 return["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIpAddress {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result=new ArrayList<>();
        String res=new String();
        dfs(s,res,result,4);
        return result;
    }

    private void dfs(String s, String res, ArrayList<String> result,int k) {
        if(k==0&&s.isEmpty()){
            result.add(res);
            return;
        }else{
            for(int i=1;i<=3;i++){
                if(s.length()>=i&&isValid(s.substring(0,i))){
                    if(k==1){
                        dfs(s.substring(i),res+s.substring(0,i),result,k-1);
                    }else{
                        dfs(s.substring(i),res+s.substring(0,i)+".",result,k-1);
                    }
                }
            }
        }

    }
    private boolean isValid(String s){
        if(s.isEmpty()||s.length()>3||(s.length()>1&&s.charAt(0)=='0')){
            return false;
        }
        int num=Integer.parseInt(s);
        if(0<=num&&num<=255){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        RestoreIpAddress test=new RestoreIpAddress();
        ArrayList<String> result=test.restoreIpAddresses("25525511135");
        for(String s:result){
            System.out.println(s);
        }
    }
}
