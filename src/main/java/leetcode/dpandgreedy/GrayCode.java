package leetcode.dpandgreedy;

import java.util.ArrayList;

/**
 * Created by fay on 2017/12/14.
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 For example, given n = 2, return[0,1,3,2]. Its gray code sequence is:
 00 - 0
 01 - 1
 11 - 3
 10 - 2
 Note:
 For a given n, a gray code sequence is not uniquely defined.
 For example,[0,2,3,1]is also a valid gray code sequence according to the above definition.
 For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

 */
public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<Math.pow(2,n);i++){
            res.add((i>>1)^i);
        }
        return res;
    }
    public static void main(String[] args){
        GrayCode test=new GrayCode();
        ArrayList<Integer> res=test.grayCode(3);
        for(int i:res){
            System.out.println(i+" ");
        }
    }
}
