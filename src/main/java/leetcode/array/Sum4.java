package leetcode.array;

import java.util.*;

/* Given an array S of n integers, are there elements a, b, c, and d in S such
that a + b + c + d = target? Find all unique quadruplets in the array which
gives
 the sum of target.

Note:

    Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie,
    a ≤ b ≤ c ≤ d)
    The solution set must not contain _51_duplicate quadruplets.


    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/
public class Sum4 {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {

        //Set<ArrayList<Integer>> result = new TreeSet<>();
        HashSet<ArrayList<Integer>> result = new HashSet<>();
        Arrays.sort(num);
        int left=0;
        int right=0;
        for (int i = 0; i < num.length-3; i++) {
            for(int j=i+1;j<num.length-2;j++){
                left=j+1;
                right=num.length-1;
                while (left < right) {
                    if ((num[i] + num[j]+num[left]+num[right]) == target) {
                        ArrayList<Integer> res = new ArrayList<>();
                        res.add(num[i]);
                        res.add(num[j]);
                        res.add(num[left]);
                        res.add(num[right]);
                        result.add(res);

                        left++;
                        right--;
                    } else if ((num[i] + num[j]+num[left]+num[right]) <
                            target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        //去冲了但是没有按顺序输出！
        return new ArrayList(result);
    }
    public ArrayList<ArrayList<Integer>> fourSum1(int[] num, int target) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        int left=0;
        int right=0;
        for (int i = 0; i < num.length-3; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])){
                for(int j=i+1;j<num.length-2;j++){
                    left=j+1;
                    right=num.length-1;
                    if (j == i + 1 || (j > i + 1 && num[j] != num[j - 1])){
                        while (left < right) {
                            if ((num[i] + num[j]+num[left]+num[right]) == target) {
                                ArrayList<Integer> res = new ArrayList<>();
                                res.add(num[i]);
                                res.add(num[j]);
                                res.add(num[left]);
                                res.add(num[right]);
                                result.add(res);

                                left++;
                                right--;
                            } else if ((num[i] + num[j]+num[left]+num[right]) <
                                    target) {
                                left++;
                            } else {
                                right--;
                            }
                            while (left != j + 1 && left < right && num[left] == num[left - 1])
                                left++;
                            while (right != num.length - 1 && right > left && num[right] == num[right + 1])
                                right--;
                        }
                    }

                }
            }

        }
        return result;
    }


    public ArrayList<ArrayList<Integer>> fourSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length < 4)
            return result;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            /*
             * 后面两个if判断可以大大缩短测试时间：185ms到31ms
             */
            // first candidate too large, search finished
            if (num[i] + num[i + 1] + num[i + 2] + num[i + 3] > target)
                break;
            // first candidate too small
            if (num[i] + num[num.length - 1] + num[num.length - 2] + num[num.length - 3] < target)
                continue;
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                for (int j = i + 1; j < num.length - 2; j++) {
                    // second candidate too large
                    if (num[i] + num[j] + num[j + 1] + num[j + 2] > target)
                        break;
                    // second candidate too small
                    if (num[i] + num[j] + num[num.length - 1] + num[num.length - 2] < target)
                        continue;
                    if (j == i + 1 || (j > i + 1 && num[j] != num[j - 1])) {
                        int sum = target - num[i] - num[j], left = j + 1, right = num.length - 1;
                        while (left < right) {
                            if (num[left] + num[right] > sum)
                                right--;
                            else if (num[left] + num[right] < sum)
                                left++;
                            else {
                                // 找到数对
                                ArrayList<Integer> list = new ArrayList<Integer>();
                                list.add(num[i]);
                                list.add(num[j]);
                                list.add(num[left]);
                                list.add(num[right]);
                                result.add(list);
                                left++;
                                right--;
                            }
                            while (left != j + 1 && left < right && num[left] == num[left - 1])
                                left++;
                            while (right != num.length - 1 && right > left && num[right] == num[right + 1])
                                right--;
                        }
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] arr={1 ,0 ,-1 ,0 ,-2, 2};
        int[] arr1={-3,-2,-1,0,0,1,2,3};
        int[] arr2={-1,-5,-5,-3,2,5,0,4};
        int[] arr3={-1,0,-5,-2,-2,-4,0,1,-2};
        Sum4 test=new Sum4();
       // ArrayList<ArrayList<Integer>> result1=test.fourSum1(arr2,-7);
        //有重复
        ArrayList<ArrayList<Integer>> result1=test.fourSum1(arr3,-9);
        for(ArrayList<Integer> res:result1){
            for(int a:res){
                System.out.print(a+",");
            }
            System.out.println();
        }
        ArrayList<ArrayList<Integer>> result2=test.fourSum(arr3,-9);
        for(ArrayList<Integer> res:result2){
            for(int a:res){
                System.out.print(a+",");
            }
            System.out.println();
        }
    }

}
