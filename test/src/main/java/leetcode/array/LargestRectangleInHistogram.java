package main.java.leetcode.array;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.



 Above is a histogram where width of each bar is 1, given height =[2,1,5,6,2,3].




 The largest rectangle is shown in the shaded area, which has area =10unit.


 For example,
 Given height =[2,1,5,6,2,3],
 return10.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        int res=0;
        int n=height.length;
        for(int i=0;i<n;i++){
            if(i+1<n&&height[i]<=height[i+1]){
                continue;
            }
            int minH=height[i];
            for(int j=i;j>=0;j--){
                minH=Math.min(height[j],minH);
                int area=(i-j+1)*minH;
                res=Math.max(res,area);
            }
        }
        return res;
    }
}
