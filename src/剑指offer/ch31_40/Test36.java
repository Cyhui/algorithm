package 剑指offer.ch31_40;

/**
 * 面试题36：数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * <p>
 * Created by Cyhui on 2018/1/4 0004.
 */
public class Test36 {

    /**
     * 思路：
     * 算法导论中提到 插入排序的运行时间与输入数组中逆序对的关系：
     * 逆序数与元素移动的数量相同。插入排序没移动元素将一个较大的数移动到较小的数后面，逆序对数量减一
     * 使用归并排序，最坏情况需要O（nlgn）
     *
     * @param array
     * @return
     */
    public int InversePairs(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        int num = inversion(array, 0, array.length - 1);
        return num;
    }

    /**
     * 归并排序
     * 统计逆序对的个数
     * @param array
     * @param start
     * @param end
     * @return 逆序对的个数
     */
    private int inversion(int[] array, int start, int end) {
        int number = 0;
        if (start < end) {
            int mid = start + (end - start) / 2;
            number += inversion(array, start, mid) % 1000000007;
            number += inversion(array, mid + 1, end) % 1000000007;
            number += merge(array, start, mid, end) % 1000000007;
        }
        return number % 1000000007;
    }

    /**
     * 合并过程
     * @param array
     * @param start
     * @param mid
     * @param end
     * @return 逆序对的个数
     */
    public int merge(int[] array, int start, int mid, int end) {
        // 临时数组
        int[] temp = new int[end - start + 1];
        // 左侧序列最后一个数字游标
        int n1 = mid;
        // 右侧序列最后一个数字游标
        int n2 = end;
        // 临时数组游标
        int index = temp.length - 1;
        int number = 0;
        while(n1 >= start && n2 >= mid + 1){
            // 左侧序列最后一个数大于右侧序列最后一个数
            if (array[n1] > array[n2]){
                temp[index--] = array[n1--];
                // 逆序对的数目等于右侧序列剩余数字的个数
                number += n2 - mid;
                // 牛客网上需要加取余
                if (number >= 1000000007){
                    number %= 1000000007;
                }
            }else{
                temp[index--] = array[n2--];
            }
        }
        while(n1 >= start){
            temp[index--] = array[n1--];
        }
        while(n2 >= mid + 1){
            temp[index--] = array[n2--];
        }
        for (int i = 0; i < temp.length; i++) {
             array[start+i] = temp[i];
        }
        return number % 1000000007;
    }

    public static void main(String[] args){
        int[] arr = {7,5,6,4};
        Test36 test36 = new Test36();
        System.out.println(test36.InversePairs(arr));
    }
}
