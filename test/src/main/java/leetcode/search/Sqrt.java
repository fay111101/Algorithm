package leetcode.search;

/**
 * Created by fay on 2017/12/7.
 * Implementint sqrt(int x).
 Compute and return the square root of x.
 http://www.jianshu.com/p/f1d4a1a8efd2
 */
public class Sqrt {
    public int sqrt(int x) {
        long left=0,right=(x/2)+1;
        while(left<=right){
            long mid=(left+right)>>1;
            long sq=mid*mid;
            if(sq==x){
                return (int)mid;
            }else if(sq<x){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return (int)right;
    }
    public static void main(String[] args){
        Sqrt test=new Sqrt();
        System.out.println(test.sqrt(1));
        System.out.println(test.sqrt(16));
        System.out.println(test.sqrt(2));
        System.out.println(test.sqrt(3));
        System.out.println(test.sqrt(5));
    }
}
