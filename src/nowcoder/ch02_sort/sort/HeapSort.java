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


    public static void heap_sort(int[] a) {
        build_max_heap(a);
        for (int i = a.length - 1; i >= 1; i--) {
            swap(a, 0, i);
            // 0~length(A)-1 的堆，重新建堆
            max_heapify(a, 0, i - 1);
        }
    }

    /**
     * 建堆
     *
     * @param a
     */
    public static void build_max_heap(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            max_heapify(a, i, a.length - 1);
        }
    }

    /**
     * 保持堆的性质
     *
     * @param a
     * @param i
     */
    public static void max_heapify(int[] a, int i, int end) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest;
        if (l <= end && a[l] > a[i]) {
            largest = l;
        }else{
            largest = i;
        }
        if (r <= end && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            max_heapify(a, largest, end);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
