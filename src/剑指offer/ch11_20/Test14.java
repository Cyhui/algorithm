package 剑指offer.ch11_20;

/**
 * 面试题14:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * Created by Cyhui on 2017/12/29 0029.
 */
public class Test14 {

    /* 不考虑时间复杂度 最简单的思路是从头扫描这个数组，
    *  每碰到一个偶数是，拿出这个数组，并将这个数字后面的所有数组往前挪一位。
    *  时间复杂度为O(n)*/

    /* 只完成基本功能的解法
    没有保证奇数和奇数，偶数和偶数之间的相对位置不变.
    *  思路：使用p1指向数组第一个数字，p2指向数组最后一个数字，
    *  如果p1指向偶数 p2指向奇数 交换这两个数字*/
    /**
     *使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分
     * 没有保证稳定性
     * @param array 待整理的数组
     */
    public void reOrderArray1(int [] array) {
        if(array == null || array.length == 0){
            return;
        }
        int p1 = 0;
        int p2 = array.length - 1;
        while(p1 < p2){
            // p1向后移动，直到指向偶数
            while((p1 < p2) && ((array[p1] & 1) != 0)){
                p1++;
            }
            // p2先前移动，直到指向奇数
            while((p1 < p2) && ((array[p2] & 1) == 0)){
                p2--;
            }
            if (p1 < p2){
                int temp = array[p1];
                array[p1] = array[p2];
                array[p2] = temp;
            }
        }
    }

    /*  考虑可扩展性的解法，秒杀offer
    *  新问题1: 数组中的数按照大小分为两部分，所有的数都在非负数前。
    *  新问题2: 数组中的数分为两部分，能被3整除的数都在不能被整除的数的前面。
    *  我们只需修改两处判断的标准，大的框架不变.
    * */

    /**
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分
     * 没有保证稳定性
     * @param array 待整理的数组
     */
    public void reOrderArray2(int [] array) {
        if(array == null || array.length == 0){
            return;
        }
        int p1 = 0;
        int p2 = array.length - 1;
        while(p1 < p2){
            // p1向后移动，直到指向偶数
            while((p1 < p2) && isEven(array[p1])){
                p1++;
            }
            // p2先前移动，直到指向奇数
            while((p1 < p2) && isEven(array[p2])){
                p2--;
            }
            if (p1 < p2){
                int temp = array[p1];
                array[p1] = array[p2];
                array[p2] = temp;
            }
        }
    }

    /**
     * 判断是否是偶数
     * @param n 整数
     * @return 偶数返回true
     */
    private boolean isEven(int n) {
        return (n & 1) == 0;
    }


    public static void main(String[] args){
        Test14 test14 = new Test14();
        int[] arr = {1,2,3,4,5,6,7};
        test14.reOrderArray1(arr);
        for (int x:arr) {
            System.out.print(x + " ");
        }
    }
}
