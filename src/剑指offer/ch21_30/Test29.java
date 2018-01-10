package 剑指offer.ch21_30;

/**
 * 面试题29 ：数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 * Created by Cyhui on 2018/1/1 0001.
 */
public class Test29 {

    /**
     * 基于partition函数的O（n）算法  会修改数组的顺序
     *  数组中有一个数出现的次数超过了数组长度的一半。如果给这个数组排序，
     *  排序后位于数组中间的数字一定是那个出现次数超过数组长度一半的数字。
     *  即长度为n的数组中第n/2大的数字。
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length <= 0){
            return 0;
        }
        int mid = array.length >> 1;
        int start = 0;
        int end = array.length - 1;
        int index = Partition(array,start,end);
        return 1;
    }

    private int Partition(int[] array,int start,int end) {
        return 1;
    }

    /**
     * 思路：数组中有一个数出现的次数超过数组长度的一半，说明比其他数字出现次数之和大。
     * 在遍历数组时记录数组的值和 次数。如果下一个数组的值与保存的值相同 次数加1，否则-1.
     * 如果次数为0，保存下一个值，并设次数为1，最后一次设次数为1的值就是出现次数最多的数
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution1(int [] array) {
        if (array == null || array.length < 1){
            return 0;
        }
        // 记录数值
        int res = array[0];
        // 次数
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0){
                times = 1;
                res = array[i];
            }else if(res == array[i]){
                times++;
            }else {
                times--;
            }
        }
        if (checkMoreThanHalf(array,array.length,res)){
            return 0;
        }
        return res;
    }

    /**
     * 检查数字出现次数是否大于half
     * @param array      数组
     * @param length     数组长度
     * @param res        待检查的数
     * @return
     */
    private boolean checkMoreThanHalf(int[] array, int length, int res) {
        int times = 0;
        for (int i = 0; i < length; i++) {
            if (res == array[i]){
                times++;
            }
        }
        if ((times << 1) <= length){
            return false;
        }
        return true;
    }
}
