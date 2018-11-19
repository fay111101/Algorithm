/*************************************************************************
	> File Name: _215_findKthLargest.cpp
	> Author: 
	> Mail: 
	> Created Time: 2018年11月19日 星期一 16时03分24秒
 ************************************************************************/

#include<iostream>
using namespace std;
class Solution {
public:
    // int findKthLargest(vector<int>& nums, int k) {
    //     sort(nums.begin(),nums.end());
    //     return nums[nums.size()-k];
    // }

    // int findKthLargest(vector<int>& nums,int k){
    //     priority_queue<int> q(nums.begin(),nums.end());
    //     for(int i=0;i<k-1;i++){
    //         q.pop();
    //     }
    //     return q.top();
    // }

    int findKthLargest(vector<int>& nums,int k){
        int left=0,right=nums.size()-1;
        while(true){
            int pos=partition(nums,left,right);
            if(pos==k-1){
                return nums[pos];
            }else if(pos<k-1){
                left=pos+1;
            }else{
                right=pos-1;
            }

        }
    }
    int partition(vector<int>& arr,int low,int high){
        int base = arr[low];

        while (low < high) {
            while (low < high && arr[high] <= base) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] >= base) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = base;
        return low;
    }
};
