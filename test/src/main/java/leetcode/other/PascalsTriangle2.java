package leetcode.other;

import java.util.ArrayList;

/*Given an index k, return the k th row of the Pascal's triangle.
For example, given k = 3,
Return[1,3,3,1].
Note:
Could you optimize your algorithm to use only O(k) extra space?*/
public class PascalsTriangle2 {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row=new ArrayList<Integer>();
        rowIndex++;
        if(rowIndex==0)
            return row;
        row.add(1);
        for(int i=1;i<rowIndex;i++)
        {
            for(int j=i-1;j>0;j--)
            {
                row.set(j, row.get(j-1)+row.get(j));
            }
            row.add(1);
        }
        return row;
    }
    public  static void main(String[] args){
        PascalsTriangle2 test=new PascalsTriangle2();
        test.getRow(3);
    }
}
