package offer.array;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public static void reOrderArray(int [] array) {
	     /*
	     int left=0;
	        int right=array.length-1;
	       不保证次序
	     while(left<right){
	            while((array[left]&1)==1&&(left<right)){
	                left++;
	            }
	            while((array[right]&1)==0&&(right>0)){
	                right--;
	            }
	            int temp=array[left];
	            array[left]=array[right];
	            array[right]=temp;
	            left++;
	            right--;
	        }
	        */
        int i=0;
        while(i<array.length){

            while((i<array.length)&&(array[i]&1)==1){
                i++;
            }
            int j=i+1;
            while((j<array.length)&&(array[j]&1)==0){
                j++;
            }
            if(j<array.length){
                int temp=array[j];

                for(int k=j-1;k>=i;k--){
                    array[k+1]=array[k];
                }
                array[i++]=temp;

            }else{
                break;
            }

        }

    }
}
