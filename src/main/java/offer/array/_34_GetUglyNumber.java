package offer.array;

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class _34_GetUglyNumber {

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] res = new int[index];
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        res[0] = 1;
        int count = 1;
        while (count < index) {
            int tmp = Math.min(Math.min(res[i2] * 2, res[i3] * 3), res[i5] * 5);
            if (tmp == res[i2] * 2) i2++;
            if (tmp == res[i3] * 3) i3++;
            if (tmp == res[i5] * 5) i5++;
            res[count++] = tmp;
        }

        return res[index - 1];
    }



}
