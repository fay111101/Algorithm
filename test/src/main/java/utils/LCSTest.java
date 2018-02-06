<<<<<<< HEAD:test/src/main/java/utils/LCSTest.java
package utils;

public class LCSTest {
    public static char[][] LCSLength(char[] x,char[] y){
        int m=x.length;
        int n=y.length;
        int[][] c=new int[m][n];
        char[][] b=new char[m][n];
        for(int i=0;i<m;i++){
            c[i][0]=0;
        }
        for(int j=0;j<n;j++){
            c[0][j]=0;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(x[i]==y[j]){
                    c[i][j]=c[i-1][j-1]+1;
                    b[i][j]='x';
                }else if(c[i-1][j]>=c[i][j-1]){
                    c[i][j]=c[i-1][j];
                    b[i][j]='u';
                }else{
                    c[i][j]=c[i][j-1];
                    b[i][j]='l';
                }
            }
        }
        return b;
    }
    public static void printLCSRec(char[][] b,char[] x,int i,int j){
        if(i==0||j==0){
            return;
        }
        if(b[i][j]=='x'){
            printLCSRec(b,x,i-1,j-1);
            System.out.println(x[i]);
        }else if(b[i][j]=='u'){
            printLCSRec(b,x,i-1,j);
        }else{
            printLCSRec(b,x,i,j-1);
        }
    }
    public int[][] LCSLengthS(char[] x,char[] y){
        int m=x.length+1;
        int n=y.length+1;
        int[][] c=new int[m][n];
        char[][] b=new char[m][n];
        for(int i=0;i<m;i++){
            c[i][0]=0;
        }
        for(int j=0;j<n;j++){
            c[0][j]=0;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(x[i]==y[j]){
                    c[i][j]=c[i-1][j-1]+1;
                    b[i][j]='x';
                }else if(c[i-1][j]>=c[i][j-1]){
                    c[i][j]=c[i-1][j];
                    b[i][j]='u';
                }else{
                    c[i][j]=c[i][j-1];
                    b[i][j]='l';
                }
            }
        }
        return c;
    }
    public void printLCSS(int[][] c,char[] x,int i,int j){
        int k=c[i][j];
        char[] res=new char[k];
        while(k>0){
            if(c[i][j]==c[i-1][j]){
                i--;
            }else if(c[i][j]==c[i][j-1]){
                j--;
            }else{
                res[--k]=x[i-1];
                i--;
                j--;
            }
            System.out.println(res.toString());
        }

    }
    public static void main(String[] args){
        String x = "0ABCBDAB";
        String y = "0BDCABA";
        int m=x.length()-1;
        int n=y.length()-1;
        char[][] res=LCSLength(x.toCharArray(),y.toCharArray());
        printLCSRec(res,x.toCharArray(),m,n);

    }
}
=======
public class LCSTest {
    public static char[][] LCSLength(char[] x,char[] y){
        int m=x.length;
        int n=y.length;
        int[][] c=new int[m][n];
        char[][] b=new char[m][n];
        for(int i=0;i<m;i++){
            c[i][0]=0;
        }
        for(int j=0;j<n;j++){
            c[0][j]=0;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(x[i]==y[j]){
                    c[i][j]=c[i-1][j-1]+1;
                    b[i][j]='x';
                }else if(c[i-1][j]>=c[i][j-1]){
                    c[i][j]=c[i-1][j];
                    b[i][j]='u';
                }else{
                    c[i][j]=c[i][j-1];
                    b[i][j]='l';
                }
            }
        }
        return b;
    }
    public static void printLCSRec(char[][] b,char[] x,int i,int j){
        if(i==0||j==0){
            return;
        }
        if(b[i][j]=='x'){
            printLCSRec(b,x,i-1,j-1);
            System.out.println(x[i]);
        }else if(b[i][j]=='u'){
            printLCSRec(b,x,i-1,j);
        }else{
            printLCSRec(b,x,i,j-1);
        }
    }
    public int[][] LCSLengthS(char[] x,char[] y){
        int m=x.length+1;
        int n=y.length+1;
        int[][] c=new int[m][n];
        char[][] b=new char[m][n];
        for(int i=0;i<m;i++){
            c[i][0]=0;
        }
        for(int j=0;j<n;j++){
            c[0][j]=0;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(x[i]==y[j]){
                    c[i][j]=c[i-1][j-1]+1;
                    b[i][j]='x';
                }else if(c[i-1][j]>=c[i][j-1]){
                    c[i][j]=c[i-1][j];
                    b[i][j]='u';
                }else{
                    c[i][j]=c[i][j-1];
                    b[i][j]='l';
                }
            }
        }
        return c;
    }
    public void printLCSS(int[][] c,char[] x,int i,int j){
        int k=c[i][j];
        char[] res=new char[k];
        while(k>0){
            if(c[i][j]==c[i-1][j]){
                i--;
            }else if(c[i][j]==c[i][j-1]){
                j--;
            }else{
                res[--k]=x[i-1];
                i--;
                j--;
            }
            System.out.println(res.toString());
        }

    }
    public static void main(String[] args){
        String x = "0ABCBDAB";
        String y = "0BDCABA";
        int m=x.length()-1;
        int n=y.length()-1;
        char[][] res=LCSLength(x.toCharArray(),y.toCharArray());
        printLCSRec(res,x.toCharArray(),m,n);

    }
}
>>>>>>> 29e5412baafe1c3e828bcc824210d0be06cdac0c:test/src/main/java/LCSTest.java
