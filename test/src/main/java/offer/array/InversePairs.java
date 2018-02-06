package offer.array;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 输入描述:
 题目保证输入的数组中没有的相同的数字
 数据范围：
 对于%50的数据,size<=10^4
 对于%75的数据,size<=10^5
 对于%100的数据,size<=2*10^5
 示例1
 输入

 1,2,3,4,5,6,7,0
 输出

 7
 */
public class InversePairs {
    long count=0;
    public int InversePairs(int [] array) {
        if(array==null||array.length<2) return 0;
        int len=array.length;
        merge(array,0,len-1);
        return (int)(count%1000000007) ;
    }

    void merge(int[] array, int i,int j){
        if(i>=j) return ;
        int mid=(j-i)/2+i;
        merge(array,i,mid);
        merge(array,mid+1,j);
        mergesort(array,i,mid,j);

    }

    public void mergesort(int[] array,int i,int mid,int j){
        if(i==j) return ;
        int s=mid+1;
        int t=mid;
        int a[]=new int[j-i+1];
        int m=j-i;
        while(t>=i&&j>=s){
            if(array[j]<array[t]){
                a[m]=array[t];
                count+=(j-mid);
                t--;
            }else {
                a[m]=array[j];
                j--;
            }
            m--;
        }
        while(t>=i){
            a[m--]=array[t--];

        }

        while(j>=s)
            a[m--]=array[j--];

        for(int n=0;n<a.length;n++){
            array[i++]=a[n];
        }


    }
}
