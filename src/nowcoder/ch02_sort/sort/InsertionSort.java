package nowcoder.ch02_sort.sort;

/**
 * 插入排序 时间复杂度O(n²)
 * Created by Cyhui on 2017/8/3 0003.
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            index = i;
            while (index > 0) {
                if (arr[index - 1] > arr[index]) {
                    swap(arr, index - 1, index);
                    index--;
                } else {
                    break;
                }
            }
        }
    }

    public static void insertionSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while((j >= 0) && (arr[j] > key)){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
