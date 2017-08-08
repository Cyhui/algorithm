package nowcoder.ch02_sort.sort;

/**
 * 计数排序 时间复杂度O(n)
 * Created by Cyhui on 2017/8/8 0008.
 */
public class CountingSort {
    public static void countingSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        int[] countArr = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i] - min]++;
        }
        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
