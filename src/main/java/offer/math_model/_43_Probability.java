package offer.math_model;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为S。输入n，打印出S的所有可能的值出现的概率。
 */
public class _43_Probability {
    private static final int g_maxValue = 6;
    

    //基于递归求骰子点数，时间效率不高
    /**
     * 解法一：基于递归，时间效率不高
     * <p>
     * 递归的思想一般是分而治之，把n个骰子分为第一个和剩下的n-1个。先计算第一个骰子每个点数出现的次数，再计算剩余n-1个骰子出现的点数之和。
     * 求n-1个骰子的点数之的方法和前面讲的一样，即再次把n-1个骰子分成两堆------第一个和剩下的n-2个。n个骰子，每个骰子6个面，总共有6n个组合。
     * 这6n个组合之中肯定有重复的，我们知道其范围是n~6n,对于每种情况我们可以用缓存机制记录下来，每当其发生一次我们令其对应的单元加1。
     * 我们定义一个长度为6n-n+1的数组，和为s的点数出现的次数保存到数组第s-n个元素里。为什么是6n-n+1呢？因为n个骰子的和最少是n，最大是6n，
     * 介于这两者之间的每一个情况都可能会发生，总共6n-n+1种情况。
     *
     * @param number
     */
    public static void PrintProbability(int number) {
        if (number < 1) return;
        int maxSum = number * g_maxValue;
        int[] pProbabilities = new int[maxSum - number + 1];
        //初始化，开始统计之前都为0次
        for (int i = number; i <= maxSum; i++) {
            pProbabilities[i - number] = 0;
        }
        double total = Math.pow(g_maxValue, number);
        //probability(number,pProbabilities);这个函数计算n~6n每种情况出现的次数
        probability(number, pProbabilities);
        for (int i = number; i <= maxSum; i++) {
            double ratio = pProbabilities[i - number] / total;
            System.out.println("i: " + i + " ratio: " + ratio);
        }
    }

    public static void probability(int number, int[] pProbabilities) {
        for (int i = 1; i <= g_maxValue; i++) {//从第一个骰子开始
            probability(number, number, i, pProbabilities);
        }
    }

    //总共original个骰子，当前第 current个骰子，当前的和，贯穿始终的数组
    public static void probability(int original, int current, int sum, int[] pProbabilities) {
        if (current == 1) {
            pProbabilities[sum - original]++;
        } else {
            for (int i = 1; i <= g_maxValue; i++) {
                probability(original, current - 1, sum + i, pProbabilities);
            }
        }
    }


    //基于循环求骰子点数

    /**
     * 递归一般是自顶向下的分析求解，而基于循环的方法则是自底向上。基于循环的一般需要更少的空间和更少的时间，性能较好，但是一般代码比较难懂。
     *
     * @param number
     */
    public static void PrintProbability_1(int number) {
        if (number < 1) {
            return;
        }
        int[][] pProbabilities = new int[2][g_maxValue * number + 1];
        for (int i = 0; i < g_maxValue; i++) {//初始化数组
            pProbabilities[0][i] = 0;
            pProbabilities[1][i] = 0;
        }
        int flag = 0;
        for (int i = 1; i <= g_maxValue; i++) {//当第一次抛掷骰子时，有6种可能，每种可能出现一次
            pProbabilities[flag][i] = 1;
        }
        //从第二次开始掷骰子，假设第一个数组中的第n个数字表示骰子和为n出现的次数，
        //在下一循环中，我们加上一个新骰子，此时和为n的骰子出现次数应该等于上一次循环中骰子点数和为n-1,n-2,n-3,n-4,n-5，
        //n-6的次数总和，所以我们把另一个数组的第n个数字设为前一个数组对应的n-1,n-2,n-3,n-4,n-5，n-6之和
        for (int k = 2; k <= number; k++) {
            for (int i = 0; i < k; i++) {//第k次掷骰子，和最小为k，小于k的情况是不可能发生的！所以另不可能发生的次数设置为0！
                pProbabilities[1 - flag][i] = 0;
            }
            for (int i = k; i <= g_maxValue * k; i++) {//第k次掷骰子，和最小为k，最大为g_maxValue*k
                pProbabilities[1 - flag][i] = 0;//初始化，因为这个数组要重复使用，上一次的值要清0
                for (int j = 1; j <= i && j <= g_maxValue; j++) {
                    pProbabilities[1 - flag][i] += pProbabilities[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        double total = Math.pow(g_maxValue, number);
        for (int i = number; i <= g_maxValue * number; i++) {
            double ratio = pProbabilities[flag][i] / total;
            System.out.println("sum: " + i + " ratio: " + ratio);
        }
    }
}
