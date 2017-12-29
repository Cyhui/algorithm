package 剑指offer.ch1_10;

/**
 * 面试题8 ：旋转数组的最小数字
 *
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * Created by Cyhui on 2017/12/29 0029.
 */
public class Test8 {

    /**
     *
     * @param array 待旋转的数组
     * @return 返回数组的最小元素，如果数组大小为0，返回0
     */
    public static int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }

        //指向第一个位置
        int index1 = 0;
        //指向最后一个位置
        int index2 = array.length - 1;
        // 设置初始值
        int mid = index1;

        //保证index1在前一个排好序的部分，index2在排好序的后一个部分
        while(array[index1] >= array[index2]){
            if (index2 - index1 == 1){
                return array[index2];
            }
            //取中间值
            mid = index1 + (index2 - index1) / 2;

            //如果三个数相等，需要进行顺序处理，从头到位找最小的值
            if (array[mid] == array[index1] && array[index2] == array[index1]){
                return minInOrder(array,index1,index2);
            }
            if (array[mid] >= array[index1]){
                //
                index1 = mid;
            }else if (array[mid] <= array[index2]){
                index2 = mid;
            }
        }
        return array[mid];
    }

    /**
     * 从index1到index2顺序查找最小值
     * @param arr  待查找的数组
     * @param index1  开始下标
     * @param index2  结束下标
     * @return      返回最小值
     */
    private static int minInOrder(int[] arr,int index1,int index2){
        int result = arr[index1];
        for (int i = index1 + 1; i < index2; i++) {
            if (result > arr[i]){
                result = arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        // 典型输入，单调升序的数组的一个旋转
        int[] array1 = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(array1));

        // 有重复数字，并且重复的数字刚好的最小的数字
        int[] array2 = {3, 4, 5, 1, 1, 2};
        System.out.println(minNumberInRotateArray(array2));

        // 有重复数字，但重复的数字不是第一个数字和最后一个数字
        int[] array3 = {3, 4, 5, 1, 2, 2};
        System.out.println(minNumberInRotateArray(array3));

        // 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
        int[] array4 = {1, 0, 1, 1, 1};
        System.out.println(minNumberInRotateArray(array4));

        // 单调升序数组，旋转0个元素，也就是单调升序数组本身
        int[] array5 = {1, 2, 3, 4, 5};
        System.out.println(minNumberInRotateArray(array5));

        // 数组中只有一个数字
        int[] array6 = {2};
        System.out.println(minNumberInRotateArray(array6));

        // 数组中数字都相同
        int[] array7 = {1, 1, 1, 1, 1, 1, 1};
        System.out.println(minNumberInRotateArray(array7));

        // 输入NULL
        System.out.println(minNumberInRotateArray(null));
    }
}
