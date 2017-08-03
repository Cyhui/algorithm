package nowcoder.ch02_sort.sort;

/**
 * 选择排序
 * Created by Cyhui on 2017/7/29 0029.
 */
public class SelectionSort {
    public static int[] selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        int mini = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            mini = i;
            for (int j = i + 1; j < arr.length; j++) {
                mini = arr[mini] > arr[j] ? j : mini;
            }
            swap(arr, i, mini);
        }
        return arr;
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
