package 剑指offer.ch31_40;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O（n），空间复杂度是O(1)
 * Created by Cyhui on 2018/1/8 0008.
 */
public class Test40 {

    /**
     * 思路：除了这两个数外其他数成对出现。 一个数异或它自己结果是0
     *  两个数异或结果不为0，说明二进制个位上一定有1.
     * @param array
     * @param num1  长度为1的数组。传出参数  num1[0]返回结果
     * @param num2  长度为1的数组。传出参数  num2[0]返回结果
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int length = array.length;
        if (array.length == 2) {
            num1[0] = array[0];
            num1[1] = array[1];
        }
        int bitResult = 0;
        for (int i = 0; i < array.length; i++) {
            bitResult ^= array[i];
        }
        // 找到结果二进制中最右边是1的位
        int index = findFirstBitIs1(bitResult);
        for (int i = 0; i < length; i++) {
            //判断在target的二进制表示中从右边数index位是不是1
            if (isBit1(array[i],index)){
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }
    }

    /**
     * 找到结果二进制中最右边是1的位
     *
     * @param bitResult
     * @return
     */
    private int findFirstBitIs1(int bitResult) {
        int index = 0;
        while ((index < 32) && ((bitResult & 1) == 0)) {
            bitResult >>= 1;
            index++;
        }
        return index;
    }

    /**
     * 判断在target的二进制表示中从右边数index位是不是1
     * @param target
     * @param index
     * @return
     */
    private boolean isBit1(int target,int index){
        return ((target >> index) & 1) == 1;
    }
}
