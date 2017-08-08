package nowcoder.ch02_sort.sort;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 基数排序  时间复杂度O(n)
 * Created by Cyhui on 2017/8/8 0008.
 */
public class RadixSort {
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 存放负数的个数
        int negNum = 0;
        for (int i = 0; i < arr.length; i++) {
            negNum += arr[i] < 0 ? 1 : 0;
        }
        // 存放负数的绝对值
        int[] negArr = new int[negNum];
        // 存放正数
        int[] posArr = new int[arr.length - negNum];
        // 负数数组游标
        int negi = 0;
        // 正数数组游标
        int posi = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negArr[negi++] = -arr[i];
            } else {
                posArr[posi++] = arr[i];
            }
        }
        // 将负数绝对值排好序
        radixSortForPositive(negArr);
        // 将正数排好序
        radixSortForPositive(posArr);
        // 输出数组的游标
        int index = 0;
        for (int i = negArr.length - 1; i >= 0; i--) {
            arr[index++] = -negArr[i];
        }
        for (int i = 0; i < posArr.length; i++) {
            arr[index++] = posArr[i];
        }
    }

    // 对数组排序
    public static void radixSortForPositive(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 存放从个位开始到高位的输出序列
        ArrayList<LinkedList<Integer>> qArr1 = new ArrayList<>();
        ArrayList<LinkedList<Integer>> qArr2 = new ArrayList<>();
        // 0~9 10个桶每个桶是一个队列
        for (int i = 0; i < 10; i++) {
            qArr1.add(new LinkedList<Integer>());
            qArr2.add(new LinkedList<Integer>());
        }
        for (int i = 0; i < arr.length; i++) {
            qArr1.get(arr[i] % 10).offer(arr[i]);
        }
        long base = 10;
        while (base <= Integer.MAX_VALUE) {
            for (int i = 0; i < 10; i++) {
                LinkedList<Integer> queue = qArr1.get(i);
                while (!queue.isEmpty()) {
                    int value = queue.poll();
                    qArr2.get((int) (value / base) % 10).offer(value);
                }
            }
            ArrayList<LinkedList<Integer>> tmp = qArr1;
            qArr1 = qArr2;
            qArr2 = tmp;
            base *= 10;
        }
        int index = 0;
        // 输出队列到数组中
        for (int i = 0; i < 10; i++) {
            LinkedList<Integer> queue = qArr1.get(i);
            while (!queue.isEmpty()) {
                arr[index++] = queue.poll();
            }
        }
    }
}
