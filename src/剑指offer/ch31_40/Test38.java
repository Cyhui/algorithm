package 剑指offer.ch31_40;

import java.util.HashMap;

/**
 * 面试题38：数字在排序数组中出现的次数
 * Created by Cyhui on 2018/1/8 0008.
 */
public class Test38 {

    /**
     * 时间复杂度O（n）
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int[] array, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        if (map.containsKey(k)) {
            return map.get(k);
        } else {
            return 0;
        }
    }

    /**
     * 数组有序使用二分搜索 时间复杂度O（logn）
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK1(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int number = 0;
        // 使用二分搜索找到第一个key
        int first = getFirstKey(array, 0, array.length - 1, k);
        // 使用二分搜索找到最后一个key
        int last = getLastKey(array, 0, array.length - 1, k);
        if (first > -1 && last > -1){
            number = last - first + 1;
        }
        return number;
    }

    /**
     * 二分搜索递归写法
     * 找到第1个key
     *
     * @param array
     * @param start
     * @param end
     * @param key
     * @return
     */
    public int getFirstKey(int[] array, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (key == array[mid]) {
            // array[mid]是数组中第一个key
            // 注意mid-1可能越界
            if(mid == 0 || key != array[mid - 1]){
                return mid;
            }else{
                return getFirstKey(array, start, mid - 1, key);
            }
        } else if (key < array[mid]) {
            return getFirstKey(array, start, mid - 1, key);
        } else {
            return getFirstKey(array, mid + 1, end, key);
        }
    }

    /**
     * 二分搜索递归写法
     * 找到最后1个key
     *
     * @param array
     * @param start
     * @param end
     * @param key
     * @return
     */
    public int getLastKey(int[] array, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (key == array[mid]) {
                // array[mid]是数组中最后一个key
                // 注意mid+1可能越界
                if (mid == array.length - 1 || key != array[mid + 1]){
                    return mid;
                }else{
                    start = mid + 1;
                }
            } else if (key < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        return -1;
    }
}
