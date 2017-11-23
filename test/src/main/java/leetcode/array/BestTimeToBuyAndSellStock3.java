package leetcode.array;
/*

Say you have an array for which the i th element is the price of a given stock
on day i.

Design an algorithm to find the maximum profit. You may complete at most two
transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell
 the stock before you buy again).
 http://blog.csdn.net/acema/article/details/27317687
 */

/*
       if(prices==null||prices.length<2) return 0;
       int[]pre=new int[prices.length];
       int []post=new int[prices.length];
       int min=prices[0];
       for(int i=1;i<prices.length;i++){
           min=Math.min(min,prices[i]);
           pre[i]=Math.max(pre[i-1],prices[i]-min);
       }
       int max=prices[prices.length-1];
       for(int i=prices.length-2;i>=0;i--){
           max=Math.max(max,prices[i]);
           post[i]=Math.max(post[i+1],max-prices[i]);
       }
       int maxProfit=0;
       for(int i=0;i<prices.length;i++){
           maxProfit=Math.max(maxProfit,pre[i]+post[i]);
       }
       return  maxProfit;
*/
public class BestTimeToBuyAndSellStock3 {
    public int maxProfit(int[] prices){
        if(prices==null||prices.length<=1){
            return 0;
        }
        int max=0;
        int n=prices.length;
        for(int i=0;i<n;i++){
            int p=profit(prices,0,i)+profit(prices,i,n-1);
            max=Math.max(p,max);
        }
        return max;
    }
    public int profit(int[] prices,int start,int end){

        int max=Integer.MIN_VALUE;
        //System.out.println(start);
        int min=prices[start];
        for(int i=start;i<=end;i++){
            max=Math.max(max,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return max;
    }
    public static void main(String[] args){
        int[] prices={1,2};
        BestTimeToBuyAndSellStock3 test=new BestTimeToBuyAndSellStock3();
        System.out.println(test.maxProfit(prices));
    }
}
