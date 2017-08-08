package nowcoder.ch02_sort.sort;

/**
 * 堆排序  时间复杂度为O(N*logN)
 * Created by Cyhui on 2017/8/3 0003.
 */
public class HeapSort {
    public static int[] heapSort(int[] a) {
        //建大根堆
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            heapAdjust(a, i, a.length - 1);
        }
        //排序
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);
            heapAdjust(a, 0, i - 1);
        }

        return a;
    }

    private static void heapAdjust(int[] a, int i, int m) {
        for (int k = 2 * i + 1; k <= m; k = 2 * i + 1) {
            /** 小根堆 输出为逆序
             * if (k < m && a[k] > a[k + 1]) {
             k++;
             }
             if (a[k] < a[i]) {
             swap(a, k, i);
             i = k;
             } else {
             break;
             }
             */
            if (k < m && a[k] < a[k + 1]) {
                k++;
            }
            if (a[k] > a[i]) {
                swap(a, k, i);
                i = k;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
