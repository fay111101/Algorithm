package offer.array;

import java.util.Arrays;

/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
 * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
 */
public class _44_isContinuous {

    /**
     * 思路：
     * <p>
     * 1、首先我们应该关注的是大小王等特殊字符，由于可以当成任意的数字，所有当成0处理。
     * 2、把数组排序，再统计数组中0的个数
     * 3、统计排序之后的数组中相邻数字之间的空缺总数。
     * 4、数组中的非0数字重复出现，则该数组是不连续的。
     * 5、如果空缺的总数小于或者等于0的个数，那么这个数组就是连续的，反之则不连续
     *
     * @param number
     * @return
     */
    private boolean isOrderly(int[] number) {
        //1、非空判断
        if (number == null) {
            return false;
        }

        //2、计算 0 的个数
        int zero = 0;
        for (int num : number) {
            if (num == 0) {
                zero++;
            }
        }

        //3、将数组排序
        Arrays.sort(number);

        //4、排序完成之后 从非零数据进行两两判断
        int small = zero;
        int big = small + 1;
        int numberGap = 0;

        //5、排除一种情况  相邻数据不相等情况
        //进行循环的基础条件
        while (big < number.length) {
            if (number[small] == number[big]) {
                return false;//有对子的存在
            }
            //统计相邻之间的空格
            numberGap += number[big] - number[small] - 1;
            //所有的数据进行后移一位
            small = big;
            big++;
        }
        //判断所有的间隔与0的个数 小于或者等于则是有序的 否则则是无序的
        return numberGap <= zero;
    }

    public boolean isContinuous(int[] numbers) {
        if (numbers == null)
            return false;
        Arrays.sort(numbers);
        int zero = 0, i = 0;
        for (; i < numbers.length && numbers[i] == 0; i++) {
            zero++;
        }
        for (; i < numbers.length - 1 && zero >= 0; i++) {
            //相邻两个数组中的数相等，即出现了对子
            if (numbers[i] == numbers[i + 1])
                return false;
            if (numbers[i] + 1 + zero >= numbers[i + 1]) {
                zero -= numbers[i + 1] - numbers[i] - 1;
            } else
                return false;
        }
        if (i == numbers.length - 1)
            return true;
        else
            return false;
    }
}
