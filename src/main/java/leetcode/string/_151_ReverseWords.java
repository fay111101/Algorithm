package leetcode.string;

/**
 *
 */
public class _151_ReverseWords {

    public String reverseWords(String s) {
        if (s == null )
            return s;
        if(s.trim().length()==0){
            return s.trim();
        }
        char[] arr = s.toCharArray();
        int left = 0, right = s.length() - 1;
        // 完全翻转
        reverse(arr,left,right);
        //翻转单个单词
        reverseWord(arr);
        //空格处理
        return cleanSpaces(arr);
    }

    private String cleanSpaces(char[] arr) {
        int n=arr.length;
        int i=0,j=0;
        while(j<n){
            while(j<n&&arr[j]==' ')
                j++;
            while(j<n&&arr[j]!=' '){
                arr[i++]=arr[j++];
            }
            while(j<n&&arr[j]==' ')
                j++;
            if(j<n)
                arr[i++]=' ';
        }
        return new String(arr).substring(0,i);
    }

    private void reverseWord(char[] arr) {
        int n=arr.length,i=0,j=0;
        while(j<n){
            while(i<j||i<n&&arr[i]==' ')
                i++;
            while(j<i||j<n&&arr[j]!=' ')
                j++;
            reverse(arr,i,j-1);
        }
    }
    //翻转left到right间的字母
    private void reverse(char[] arr, int left, int right) {
        while(left<right){
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }


    public String reverseWords1(String s) {

        char[] array = s.toCharArray();
        if (array.length == 0)
            return s;
        char[] res = new char[array.length];
        int len = helper(array, array.length - 1, res, 0, 0);
        return new String(res, 0, len);

    }

    private int helper(char[] array, int r, char[] res, int l, int len) {
        while (r >= 0 && array[r] == ' ')
            r--;
        if (r < 0)
            return Math.max(0, len - 1);
        int right = r;
        while (r >= 0 && array[r] != ' ')
            r--;
        len += right - r + 1;
        for (int left = r + 1; left <= right; left++, l++)
            res[l] = array[left];
        if (l < res.length)
            res[l++] = ' ';
        return helper(array, r, res, l, len);
    }

    public static void main(String[] args) {
        String s=" 1";
        _151_ReverseWords test=new _151_ReverseWords();
        System.out.println(test.reverseWords(s));

    }
}
