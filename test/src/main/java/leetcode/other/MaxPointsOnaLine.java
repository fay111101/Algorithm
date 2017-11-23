package leetcode.other;
/*Given n points on a 2D plane, find the maximum number of points that lie on
the same straight line.
*/
//注意考虑特殊情况,无斜率垂直时,重合时.
import java.util.HashMap;

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

public class MaxPointsOnaLine {
    public int maxPoints(Point[] points) {
        if (points == null || points.length < 2) {
            return points.length;
        }
        int res=0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> map = new HashMap<>();
            int duplicates = 1;
            int chuizhi=0;
            Point a = points[i];
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                Point b=points[j];
                if(a.x==b.x){
                    if(a.y==b.y){
                        duplicates++;
                    }else{
                        chuizhi++;
                    }
                }else{
                    double slope=(double)(a.y-b.y)/(a.x-b.x);
                    map.put(slope,map.containsKey(slope)?map.get(slope)+1:1);
                }

            }
            int max=chuizhi;
            for (double key : map.keySet()) {
                max = Math.max(map.get(key), max);
            }
            res=Math.max(max+duplicates,res);
        }
        return res;
    }
}
