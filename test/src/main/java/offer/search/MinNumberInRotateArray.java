package offer.search;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，
 * 输出旋转数组的 * 最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0||array==null){
            return 0;
        }
        int start=0;
        int end=array.length-1;
        int mid=start;
        while(array[start]>=array[end]){
            if(end-start==1){
                mid=end;
                break;
            }
            mid=(start+end)>>1;
            if(array[mid]>=array[end]){
                start=mid;
            }else if(array[mid]<=array[end]){
                end=mid;
            }
            //有重复出现的数字的情况
            int result=array[start];
            if((array[start]==array[mid])&&(array[end]==array[mid])){
                for(int i=start;i<=end;i++){
                    if(result>array[i]){
                        result=array[i];

                    }
                }
                return result;
            }
        }

        return array[mid];

    }
}
