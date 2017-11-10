package leetcode.string;
/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
For example,
"A man, a plan, a canal: Panama"is a palindrome.
"race a car"is not a palindrome.
Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.*/
public class isPalindrome {
    public boolean isPalindrome(String s) {
        if(s==null||s.length()==0){
            return false;
        }
        int len=s.length();
        int i=0,j=len-1;
        while(i<j){
            char lCh=s.charAt(i);
            char rCh=s.charAt(j);
            if(!Character.isLetterOrDigit(lCh)){
                i++;
            }else if(!Character.isLetterOrDigit(rCh)){
                j--;
            }else{
                if(Character.toLowerCase(lCh)!=Character.toLowerCase(rCh)){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;

    }
}
