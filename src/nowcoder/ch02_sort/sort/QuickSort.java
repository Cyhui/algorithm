package nowcoder.ch02_sort.sort;

/**
 * 快速排序  时间复杂度为O(N*logN)
 * Created by Cyhui on 2017/8/3 0003.
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int left, int right) {
        if (left < right) {
            int random = left + (int) (Math.random() * (right - left + 1));
            swap(arr, random, right);
            int mid = partition(arr, left, right);
            process(arr, left, mid - 1);
            process(arr, mid + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = left - 1;
        int index = left;
        while (index <= right) {
            if (arr[index] <= arr[right]) {
                swap(arr, ++pivot, index);
            }
            index++;
        }
        return pivot;
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
