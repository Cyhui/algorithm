package 剑指offer.ch21_30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 面试题30 ：最小的k个数
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * Created by Cyhui on 2018/1/1 0001.
 */
public class Test30 {

    /**
     * 第一种解法： 先排序再取k个数
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k > input.length || k <= 0 || input.length <= 0) {
            return list;
        }
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }
/************************************************************************************/

    /**
     * 第二种解法：
     * O(n)的算法  只有在我们可以修改输入的数组时可以使用
     * 使用Partition函数。
     * 基于数组的第K个数字来调整，使比第k个数字小的所有数组都位于数组左边
     * 比第k个数字大的所有数组都为于数组右边
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k > input.length || k <= 0 || input.length <= 0) {
            return list;
        }
        if (k == input.length) {
            for (Integer i : input){
                list.add(i);
            }
            return list;
        }

        int start = 0;
        int end = input.length - 1;
        int index = partition(input,start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(input, start, end);
            } else {
                start = index + 1;
                index = partition(input, start, end);
            }
        }

        for (int i = 0;i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    private int partition(int[] input,int start, int end) {
        int low = start;
        int high = end;

        int pivot = input[low];
        while(low < high){
            while(low < high && pivot <= input[high]){
                high--;
            }
            input[low] = input[high];
            while(low < high && pivot >= input[low]){
                low++;
            }
            input[high] = input[low];
        }
        input[low] = pivot;
        return low;
    }
/************************************************************************************/

    /**
     * 第三种解法 使用堆
     */

}
