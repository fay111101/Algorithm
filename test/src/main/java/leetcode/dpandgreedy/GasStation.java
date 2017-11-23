package leetcode.dpandgreedy;
/*There are N gas stations along a circular route, where the amount
of gas at station i isgas[i].
You have a car with an unlimited gas tank and it costscost[i]of gas
to travel from station i to its next station (i+1). You begin the
journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around
the circuit once, otherwise return -1.
Note:
The solution is guaranteed to be unique.
http://blog.csdn.net/kenden23/article/details/14106137
*/
public class GasStation {
    public int canCompleteCircuit(int[] gas,int[] cost){
        int total=0;
        int curSum=0;
        int start=0;
        for(int i=0;i<gas.length;i++){
            total+=gas[i]-cost[i];
            curSum+=gas[i]-cost[i];
            if(curSum<0){
                start=(i+1)%(gas.length);
                curSum=0;
            }
        }
        return total>=0?start:-1;
    }
}
