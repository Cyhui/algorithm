package nowcoder.ch02_sort.sort;

/**
 * 希尔排序 时间复杂度O(nlogn)～O(n²)
 * Created by Cyhui on 2017/8/8 0008.
 */
public class ShellSort {
    public static int[] shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        // 步长
        int feet = arr.length / 2;
        int index = 0;
        while (feet > 0) {
            for (int i = feet; i < arr.length; i++) {
                index = i;
                while (index >= feet) {
                    if (arr[index - feet] > arr[index]) {
                        swap(arr, index - feet, index);
                        index -= feet;
                    } else {
                        break;
                    }
                }
            }
            feet /= 2;
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
