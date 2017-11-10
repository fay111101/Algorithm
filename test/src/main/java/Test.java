import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class SingleTon {
    private static SingleTon singleTon = new SingleTon();
    public static int count1;
    public static int count2 = 0;

    private SingleTon() {
        count1++;
        count2++;
    }

    public static SingleTon getInstance() {
        return singleTon;
    }
}

public class Test {
    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
//        System.out.println("count1=" + singleTon.count1);
//        System.out.println("count2=" + singleTon.count2);
        int fast=4;
        int slow=3;
        fast = (slow^ fast) ^ (slow = fast);
        int a=4;
        int b=5;
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(fast);
    }
}
