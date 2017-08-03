package nowcoder.ch02_sort.sort;

/**
 * 归并排序
 * Created by Cyhui on 2017/8/3 0003.
 */
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        // 划分左右
        process(arr, left, mid);
        process(arr, mid + 1, right);
        // 归并左右
        merge(arr, left, mid, right);
    }

    // 合并左右两个子数组
    private static void merge(int[] arr, int left, int mid, int right) {
        // 临时数组
        int[] help = new int[right - left + 1];
        // 左侧游标
        int l = left;
        // 右侧游标
        int r = mid + 1;
        // 临时数组游标
        int index = 0;
        while(l <= mid && r <= right){
            // 临时数组选取左右数组较小值
            if (arr[l] <= arr[r]) {
                help[index++] = arr[l++];
            }else {
                help[index++] = arr[r++];
            }
        }
        // 若第一段序列还没扫描完，将其全部复制到合并序列
        while(l <= mid){
            help[index++] = arr[l++];
        }
        // 若第二段序列还没扫描完，将其全部复制到合并序列
        while(r <= right){
            help[index++] = arr[r++];
        }
        // 将临时数组中的数据放回原数组
        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }
}
