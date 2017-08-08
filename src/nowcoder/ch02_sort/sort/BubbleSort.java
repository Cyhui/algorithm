package nowcoder.ch02_sort.sort;

/**
 * 冒泡排序  时间复杂度O(n²)
 * Created by Cyhui on 2017/7/29 0029.
 */
public class BubbleSort {
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    public static int[] bubbleSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        boolean flag = true;
        for (int i = arr.length - 1; i >= 0 && flag; i--) {
            flag = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
