package offer.string;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        if(str==null||str.length()==0){
            return "";
        }
        if(str.trim().equals("")){
            return str;
        }
        str=reverse(str,0,str.length()-1);
        String[] arr=str.split(" ");
        for(int i=0;i<arr.length;i++){
            arr[i]=reverse(arr[i],0,arr[i].length()-1);
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
            if(i!=arr.length-1)
                sb.append(" ");

        }
        return sb.toString();


    }
    public String reverse(String str,int low,int high){
        char[] arr=str.toCharArray();
        StringBuffer sb=new StringBuffer();
        while(low<high){
            char temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        return sb.toString();


    }
}
