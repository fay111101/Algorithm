/*************************************************************************
	> File Name: _30_getLeastNumbers.cpp
	> Author: 
	> Mail: 
	> Created Time: 2018年11月19日 星期一 19时57分33秒
 ************************************************************************/

#include<iostream>
#include<functional>
#include<algorithm>
#include<vector>
#include<queue>
#include<set>
#include <cstdio>
using namespace std;
class Solution {
    public:
        vector<int> GetLeastNumbers_Solution(vector<int> input, int k) {
            int size = input.size();
            vector<int> ret;
            if (size == 0 || k <= 0 || k > size)
                return ret;
            priority_queue<int> q;
            for (int i = 0; i < size; i++) {
                if (q.size() < k)
                    q.push(input[i]);
                else {
                    if (input[i] < q.top()) {
                        q.pop();
                        q.push(input[i]);
                    }
                }
            }
            while (!q.empty()) {
                ret.push_back(q.top());
                q.pop();

            }
            reverse(ret.begin(), ret.end());
            return ret;
    }

    int main(){
        cout << endl;
        printf("123");
        return 0;
    }

};
class Solution1{
    public:
    vector<int> GetLeastNumbers(vector<int> input, int k){
        if(input.size() < k || k < 0)
            return vector<int>();

        multiset<int, std::greater<int> >  leastNumbers;
        vector<int> ::const_iterator iter = input.begin();
        for(; iter != input.end(); iter++){
            if(leastNumbers.size() < k)
                leastNumbers.insert(*iter);
            else{
                multiset<int, greater<int> >::iterator iterGreatest = leastNumbers.begin();
                if(*iter < * iterGreatest){
                    leastNumbers.erase(*iterGreatest);
                    leastNumbers.insert(*iter);

                }

            }

        }
        return vector<int>(leastNumbers.begin(), leastNumbers.end());

    }
//typedef multiset<int, std::greater<int> >            intSet;
//typedef multiset<int, std::greater<int> >::iterator  setIterator;
//
//void GetLeastNumbers_Solution2(const vector<int>& data, intSet& leastNumbers, int k)
//{
//    leastNumbers.clear();
//
//    if(k < 1 || data.size() < k)
//        return;
//
//    vector<int>::const_iterator iter = data.begin();
//    for(; iter != data.end(); ++ iter)
//    {
//        if((leastNumbers.size()) < k)
//            leastNumbers.insert(*iter);
//
//        else
//        {
//            setIterator iterGreatest = leastNumbers.begin();
//
//            if(*iter < *(leastNumbers.begin()))
//            {
//                leastNumbers.erase(iterGreatest);
//                leastNumbers.insert(*iter);
//            }
//        }
//    }
//}


};
