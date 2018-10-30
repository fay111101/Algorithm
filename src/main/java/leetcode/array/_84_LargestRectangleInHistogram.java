package main.java.leetcode.array;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.



 Above is a histogram where width of each bar is 1, given height =[2,1,5,6,2,3].




 The largest rectangle is shown in the shaded area, which has area =10unit.


 For example,
 Given height =[2,1,5,6,2,3],
 return10.

 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

 求在该柱状图中，能够勾勒出来的矩形的最大面积。





 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。





 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 */
public class _84_LargestRectangleInHistogram {

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
