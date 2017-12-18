

/**
 * 简单选择排序改良版：二元选择排序
 * 
 * 基本思想： </br>
 * 在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；</br>
 * 然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换， 依次类推，直到第n- 1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。
 * 
 * @author zby
 *
 *         ******************************** 对于数据头位最大值，数据尾最小值的情况貌似有问题 *
 * *******************************
 */
public class SelectSortImproved {

	public static void sort(int[] arr) {
		int minIndex, maxIndex;

		for (int i = 0; i < arr.length / 2; i++) {
			minIndex = maxIndex = i;
			for (int j = i + 1; j < arr.length - i; j++) {
				if (arr[j] > arr[maxIndex]) {
					maxIndex = j;
					continue;
				}
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			// 必须在交换前缓存最大值和最小值，否则交换最小值或最大值位置后都影响此轮的比较结果
			int minTmp = arr[minIndex];
			int maxTmp = arr[maxIndex];
			System.out.println("minTmp = " + minTmp + ", maxTmp = " + maxTmp + ", minIndex = " + minIndex
					+ ", maxIndex = " + maxIndex);

			arr[maxIndex] = arr[arr.length - i - 1];
			SortN.printArray();
			arr[minIndex] = arr[i];
			SortN.printArray();

			System.out.println("=======");

			arr[i] = minTmp;
			SortN.printArray();
			arr[arr.length - i - 1] = maxTmp;
			SortN.printArray();

			System.out.println("-----------------------------");
		}
	}

}
