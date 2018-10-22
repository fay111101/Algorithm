package leetcode.other;

import java.util.ArrayList;

/*Given numRows, generate the first numRows of Pascal's triangle.
For example, given numRows = 5,
Return
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
public class PascalsTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(numRows==0){
            return result;
        }
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> res=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    res.add(1);
                }else{
                    res.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }
            }
            result.add(res);
        }
        return result;
    }
}
