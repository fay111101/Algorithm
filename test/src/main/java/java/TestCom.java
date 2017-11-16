import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
    private int sid;
    private String sname;
    private double score;

    public Student() {
    }

    public Student(int sid, String sname, double score) {
        this.sid = sid;
        this.sname = sname;
        this.score = score;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int compareTo(Student student) {
        if(this.score>student.getScore()){
            return 1;
        }
        else if(this.score<student.getScore()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
public class TestCom{
    public static void main(String[] args){
        Student s1=new Student(101,"a",89.3);
        Student s2=new Student(101,"b",89.5);
        Student s3=new Student(101,"c",69.3);
        List<Student> students=new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        System.out.println("-----------------------");
        for(Student s:students){
            System.out.println(s.getScore());
        }
        Collections.sort(students);
        System.out.println("-----------------------");
        for(Student s:students){
            System.out.println(s.getScore());
        }
    }
}