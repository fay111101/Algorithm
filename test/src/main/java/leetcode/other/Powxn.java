package leetcode.other;

public class Powxn {
    public double pow(double x, int n) {
        if(n<0){
            return 1/powhelper(x,n);
        }
        return powhelper(x,n);
    }
    private double powhelper(double x,int n){
        if(n==0){
            return 1;
        }
        double half=powhelper(x,n/2);
        double res=0.0;
        if(n%2==0){
            return half*half;
        }else{
            return x*half*half;
        }
    }
}
