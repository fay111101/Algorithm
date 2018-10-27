package leetcode.array;
/*
Say you have an array for which the i th element is the price of a given stock
on day i.
If you were only permitted to complete at most one transaction
(ie, buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.
*/
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices){
        if(prices==null||prices.length==0){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }
            max=Math.max(max,prices[i]-min);
        }
        return max;
    }
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6,7,8,9,13};

    }

}
