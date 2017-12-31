package 剑指offer.ch11_20;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * Created by Cyhui on 2017/12/30 0030.
 */
public class Test14_1 {

    /**
     * 与书上的不同是要求数的相对位置不变
     * 解法1：类似冒泡排序 时间复杂度O(b^2)
     * 还可以类似插入排序
     * @param array 待整理的数组
     */
    public void reOrderArray1(int [] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if ((array[j - 1] & 1) == 0 && (array[j] & 1) == 1){
                    // 前后奇偶交换
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = array[j];
                }
            }
        }
    }

    /**
     * 时间复杂度O(n) 空间复杂度O(n)
     * @param array 待处理的数组
     */
    public void reOrderArray(int [] array) {
        if (array == null || array.length < 2){
            return;
        }

        //用空间换时间
        int newArray[] = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            // 奇数
            if ((array[i] & 1) == 1){
                newArray[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            // 偶数
            if ((array[i] & 1) == 0){
                newArray[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = newArray[i];
        }
    }
}
