package 剑指offer.ch1_10;

/**面试题3：二维数组中的查找
 *
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * Created by Cyhui on 2017/12/29 0029.
 */
public class Test3 {
    /**
     * 数组中是否含有该整数
     * <p>
     * 规律：首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束：
     * 如果该数字大于要查找的数字，剔除这个数字所在的列：
     * 如果该数字小于要查找的数字，剔除这个数字所在的行。
     * 也就是说如果要查找的数字不在数组的右上角，则每－次都在数组的查找范围中剔除）行或者一列，
     * 这样每一步都可以缩小查找的范围，直到找到要查找的数字，或者查找范围为空。
     * @param target  目标数
     * @param array   待查找的数组
     * @return 数组中是否含有该整数
     */
    public boolean find(int target, int [][] array) {
        if (array == null || array.length < 1 || array[0].length < 1){
            return false;
        }
        // 数组的行数
        int rows = array.length;
        // 数组的列数
        int cols = array[0].length;

        //开始的行号
        int row = 0;
        //开始的列号
        int col = cols - 1;
        //在数组内部查找
        while(row >= 0 && row < rows && col >= 0 && col < cols){
            if (target == array[row][col]){
                return true;
            }else if (target > array[row][col]){
                // 目标数大于找到的数，向下移动
                row++;
            }else{
                // 目标数小于找到的数，向左移动
                col--;
            }
        }

        return false;
    }
}
