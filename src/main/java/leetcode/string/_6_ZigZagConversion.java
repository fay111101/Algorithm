package leetcode.string;
/* The string"PAYPALISHIRING"is written in a zigzag pattern on a given number of
rows like this: (you may want to display this pattern in a fixed font for better
legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line:"PAHNAPLSIIGYIR"


Write the code that will take a string and make this conversion given a number
of rows:

string convert(string text, int nRows);

convert("PAYPALISHIRING", 3)should return"PAHNAPLSIIGYIR". */
public class _6_ZigZagConversion {

    public String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows < 0) {
            return s;
        }
        StringBuffer[] resulttemp = new StringBuffer[nRows];
        for (int i = 0; i < nRows; i++) {
            resulttemp[i] = new StringBuffer();
        }
        StringBuffer result = new StringBuffer("");
        int size = s.length();
        int i = 0;
        while (i < size) {
            for (int j = 0; j < nRows && i < size; j++) {
                resulttemp[j].append(s.charAt(i++));
            }
            for (int j = nRows - 2; j >=1 && i < size; j--) {
                resulttemp[j].append(s.charAt(i++));
            }
        }
        for (StringBuffer temp : resulttemp) {
            result.append(temp);
        }
        return result.toString();
    }

    public static void main(String[] args){
        String s="PAYPALISHIRING";
        _6_ZigZagConversion test=new _6_ZigZagConversion();
        System.out.println(test.convert(s,3));
    }
}
