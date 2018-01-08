package 剑指offer.ch41_50;

import java.util.ArrayList;

/**
 * 面试题41：输入一个递增排序的数组和一个数字S，在数组中查找两个数，、
 * 是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:  对应每个测试案例，输出两个数，小的先输出。
 * Created by Cyhui on 2018/1/4 0004.
 */
public class Test41 {


    /**
     * 思路：从数组两边开始找
     * 分析 第一组是积最小
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>(2);
        if (array == null || array.length <= 0){
            return list;
        }
        int begin = 0;
        int end = array.length - 1;
        while(begin < end){
            if (array[begin] + array[end] == sum){
                list.add(array[begin]);
                list.add(array[end]);
                break;
            }else if (array[begin] + array[end] > sum){
                end--;
            }else{
                begin++;
            }
        }
        return list;
    }

}
