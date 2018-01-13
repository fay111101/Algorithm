package offer.array;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null){
            return;
        }
        int xor=0;
        for(int i=0;i<array.length;i++){
            xor^=array[i];
        }
        //找到为1的位
        int flag=1;
        while((xor&flag)==0)
            flag=flag<<1;
        for(int i=0;i<array.length;i++){
            if((array[i]&flag)!=0){
                num1[0]^=array[i];
            }else{
                num2[0]^=array[i];
            }
        }
    }
}
