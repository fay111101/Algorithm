package leetcode.search;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */

public class _34_SearchForARange {

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int left = 0, right = nums.length - 1;
        int temp = -1;
        while (left <= right) {
//            int mid = (left + right) >> 1;
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                temp = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int i = temp - 1, j = temp + 1;

        while (i >= 0) {
            if (nums[i] != target) {
                break;
            }
            i--;
        }
        while (j < nums.length) {
            if (nums[j] != target) {
                break;
            }
            j++;
        }
        result[0] = i + 1;
        result[1] = j - 1;
        return result;
    }


    public int[] searchRange1(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;
        int high = binSearchUp(nums, target, 0, nums.length - 1);
        int low = binSearchLow(nums, target, 0, nums.length - 1);
        //注意：未寻找到target值，通过前后指针的判断，当low>high的时候未找到符合条件的值
        if (high >= low) {
            res[0] = low;
            res[1] = high;
            return res;
        }
        return res;
    }

    //122311 2
    private int binSearchLow(int[] nums, int target, int begin, int end) {
        if (begin > end) {
            return begin;
        }
        int mid = begin + (end - begin) / 2;
        if (nums[mid] < target) {
            return binSearchLow(nums, target, mid + 1, end);
        } else {
            return binSearchLow(nums, target, begin, mid - 1);
        }
    }

    private int binSearchUp(int[] nums, int target, int begin, int end) {
        if (begin > end) {
            return end;
        }
        int mid = begin + (end - begin) / 2;
        if (nums[mid] > target) {
            return binSearchUp(nums, target, begin, mid - 1);
        } else {
            return binSearchUp(nums, target, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        _34_SearchForARange test = new _34_SearchForARange();
        int[] res = test.searchRange(arr, 8);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
/*
class Solution {
private:
    int binarySearchLow(vector<int>& nums, int target, int begin, int end)
    {
        if(begin > end) return begin;
        int mid = begin + (end - begin) / 2;
        if(nums[mid] < target) return binarySearchLow(nums, target, mid + 1, end);
        else return binarySearchLow(nums, target, begin, mid - 1);
    }
    int binarySearchUp(vector<int>& nums, int target, int begin, int end)
    {
        if(begin > end) return end;
        int mid = begin + (end - begin) / 2;
        if(nums[mid] > target) return binarySearchUp(nums, target, begin, mid - 1);
        else return binarySearchUp(nums, target, mid + 1, end);
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> res(2, -1);
        if(nums.empty()) return res;
        int high = binarySearchUp(nums, target, 0, nums.size() -1);
        int low = binarySearchLow(nums, target, 0, nums.size() - 1);
        if(high >= low)
        {
            res[0] = low;
            res[1] = high;
            return res;
        }
        return res;
    }
};
 */
