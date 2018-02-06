<<<<<<< HEAD:test/src/main/java/utils/GreedyTest.java
package utils;

import java.util.ArrayList;

public class GreedyTest {
    static ArrayList<Integer> res = new ArrayList();

    public ArrayList<Integer> recursiveActivitySelector(int[] s, int[] f, int k, int
    n) {

        int m = k + 1;
        while (m < n && s[m] < f[k]) {
            m++;
        }
        if (m < n) {
            res.add(m);
            return recursiveActivitySelector(s, f, m, n);
        }
        return res;

    }
    public ArrayList<Integer> greedyActivitySelector(int[] s,int[] f){
        int n=s.length;
        int k=1;
        res.add(1);
        for(int i=2;i<n;i++){
            if(s[i]>=f[k]){
                res.add(i);
                k=i;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] s = {0,1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int[] f = {0,4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
        int n = 12;
        GreedyTest test = new GreedyTest();
        //test.recursiveActivitySelector(s, f, 0, n);
        test.greedyActivitySelector(s,f);
        for(int i:res){
            System.out.println(i);
        }

    }
}
=======
import java.util.ArrayList;

public class GreedyTest {
    static ArrayList<Integer> res = new ArrayList();

    public ArrayList<Integer> recursiveActivitySelector(int[] s, int[] f, int k, int
    n) {

        int m = k + 1;
        while (m < n && s[m] < f[k]) {
            m++;
        }
        if (m < n) {
            res.add(m);
            return recursiveActivitySelector(s, f, m, n);
        }
        return res;

    }
    public ArrayList<Integer> greedyActivitySelector(int[] s,int[] f){
        int n=s.length;
        int k=1;
        res.add(1);
        for(int i=2;i<n;i++){
            if(s[i]>=f[k]){
                res.add(i);
                k=i;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] s = {0,1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int[] f = {0,4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
        int n = 12;
        GreedyTest test = new GreedyTest();
        //test.recursiveActivitySelector(s, f, 0, n);
        test.greedyActivitySelector(s,f);
        for(int i:res){
            System.out.println(i);
        }

    }
}
>>>>>>> 29e5412baafe1c3e828bcc824210d0be06cdac0c:test/src/main/java/GreedyTest.java
