package leetcode.array;

/**
 * Created by fay on 2017/12/11.
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 For example,
 Given[0,1,0,2,1,0,1,3,2,1,2,1], return6.

 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 https://yq.aliyun.com/articles/3880
 http://blog.csdn.net/nameix/article/details/52797313
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        int result=0;
        int n=A.length;
        int[] dp=new int[n];
        int max=0;
        //max记录左边最大值
        for(int i=0;i<n;i++){
            dp[i]=max;
            max=Math.max(max,A[i]);
        }
        max=0;
        //max记录右边最大值
        int h=0;
        for(int i=n-1;i>=0;i--){
            h=Math.min(dp[i],max);
            max=Math.max(max,A[i]);
            if(h-A[i]>0){
                result+=h-A[i];
            }
        }
        return result;
    }
    public static void main(String[] args){
        TrappingRainWater test=new TrappingRainWater();
        int[] arrs={0,1,0,2,1,0,1,3,2,1,2,1};
        test.trap(arrs);
    }
}
