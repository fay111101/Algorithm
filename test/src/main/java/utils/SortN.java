<<<<<<< HEAD:test/src/main/java/utils/SortN.java
package utils;

import java.lang.reflect.Method;

/**
 * In-place sort（不占用额外内存或占用常数的内存）：插入排序、选择排序、冒泡排序、堆排序、快速排序。 Out-place
 * sort：归并排序、计数排序、基数排序、桶排序。
 * 
 * @author zby
 *
 */
public class SortN {

	static int[] array = new int[] { 99, 2, 47, 31, 72, 15, 9, 10, 34, 28, 1 };

	static Class[] sortMethodPool = new Class[] {  SelectSortImproved.class
			};

	static int methodIndex = sortMethodPool.length - 1;

	public static void main(String[] args) {
		String methodName = sortMethodPool[methodIndex].getName();
		String simpleMethodName = methodName.substring(methodName.lastIndexOf(".") + 1);
		System.out.print(
				"=============== start " + simpleMethodName + "(length = " + array.length + ") ================ ");
		printArray();
		Class<?> clazz;
		try {
			clazz = Class.forName(methodName);
			Method sortMethod = clazz.getMethod("sort", int[].class);
			sortMethod.invoke(null, array);
			System.out.print(simpleMethodName + " finish. ");
			validateSortResult(array);
			printArray();
		} catch (Exception e) {
			System.out.print(simpleMethodName + " failed. ");
			e.printStackTrace();
		}
	}

	public static void swap(int[] array, int i, int j) {
		if (i == j) {
			return;
		}
		System.out.println("swap " + i + " ~ "  + j);
		int a = array[i];
		array[i] = array[j];
		array[j] = a;
	}

	public static void printArray() {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1) {
				System.out.print(", ");
			} else {
				System.out.println("]");
			}
		}
	}

	public static void validateSortResult(int[] array) {
		boolean succ = true;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] >= array[i + 1]) {
				succ = false;
				break;
			}
		}
		System.out.print("(sort " + (succ ? "success" : "fail") + ") ");
	}
}
=======


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * In-place sort（不占用额外内存或占用常数的内存）：插入排序、选择排序、冒泡排序、堆排序、快速排序。 Out-place
 * sort：归并排序、计数排序、基数排序、桶排序。
 * 
 * @author zby
 *
 */
public class SortN {

	static int[] array = new int[] { 99, 2, 47, 31, 72, 15, 9, 10, 34, 28, 1 };

	static Class[] sortMethodPool = new Class[] {  SelectSortImproved.class
			};

	static int methodIndex = sortMethodPool.length - 1;

	public static void main(String[] args) {
		String methodName = sortMethodPool[methodIndex].getName();
		String simpleMethodName = methodName.substring(methodName.lastIndexOf(".") + 1);
		System.out.print(
				"=============== start " + simpleMethodName + "(length = " + array.length + ") ================ ");
		printArray();
		Class<?> clazz;
		try {
			clazz = Class.forName(methodName);
			Method sortMethod = clazz.getMethod("sort", int[].class);
			sortMethod.invoke(null, array);
			System.out.print(simpleMethodName + " finish. ");
			validateSortResult(array);
			printArray();
		} catch (Exception e) {
			System.out.print(simpleMethodName + " failed. ");
			e.printStackTrace();
		}
	}

	public static void swap(int[] array, int i, int j) {
		if (i == j) {
			return;
		}
		System.out.println("swap " + i + " ~ "  + j);
		int a = array[i];
		array[i] = array[j];
		array[j] = a;
	}

	public static void printArray() {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1) {
				System.out.print(", ");
			} else {
				System.out.println("]");
			}
		}
	}

	public static void validateSortResult(int[] array) {
		boolean succ = true;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] >= array[i + 1]) {
				succ = false;
				break;
			}
		}
		System.out.print("(sort " + (succ ? "success" : "fail") + ") ");
	}
}
>>>>>>> 29e5412baafe1c3e828bcc824210d0be06cdac0c:test/src/main/java/SortN.java
