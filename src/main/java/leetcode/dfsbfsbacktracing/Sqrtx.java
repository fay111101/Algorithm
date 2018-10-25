package leetcode.dfsbfsbacktracing;
/*
Implementint sqrt(int x).
Compute and return the square root of x.
* */
public class Sqrtx {
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
}
