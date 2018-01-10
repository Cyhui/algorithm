package 剑指offer.ch31_40;

import java.util.LinkedList;

/**
 * 面试题34：丑数
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * Created by Cyhui on 2018/1/10 0010.
 */
public class Test34 {
    /*
    《参考程序员面试金典》伪代码如下
    1）初始化array和队列：Q2 Q3 Q5
    2）将1插入array
    3）分别将1*2、1*3 、1*5插入Q2 Q3 Q5
    4)令x为Q2 Q3 Q5中的最小值，将x添加至array尾部
    5）若x存在于：
        Q2：将 x * 2、x * 3、x*5 分别放入Q2 Q3 Q5，从Q2中移除x
        Q3：将 x * 3、x*5 分别放入Q3 Q5，从Q3中移除x
        Q5：将 x * 5放入Q5，从Q5中移除x
    6）重复步骤4~6，知道找到第k个元素
     */

    /**
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index < 1) {
            return -1;
        }
        int minVal = 0;
        LinkedList<Integer> q2 = new LinkedList<>();
        LinkedList<Integer> q3 = new LinkedList<>();
        LinkedList<Integer> q5 = new LinkedList<>();
        q2.offer(1);

        for (int i = 0; i < index; i++) {
            int val2 = q2.isEmpty() ? Integer.MAX_VALUE : q2.peek();
            int val3 = q3.isEmpty() ? Integer.MAX_VALUE : q3.peek();
            int val5 = q5.isEmpty() ? Integer.MAX_VALUE : q5.peek();

            minVal = Math.min(val2, Math.min(val3, val5));

            if (minVal == val2) {
                q2.poll();
                q2.offer(2 * minVal);
                q3.offer(3 * minVal);
            } else if (minVal == val3) {
                q3.poll();
                q3.offer(3 * minVal);
            } else {
                q5.poll();
            }
            q5.offer(5 * minVal);
        }
        return minVal;
    }


    /**
     * 这种思路的关键在于怎样确定数组里面的丑数是排序好的。
     * 假设数组中已经有若干个丑数排好后存放在数组中，并且把已有的最大的丑数记作M，我们接下来分析如何生成下一个丑数。
     * 该丑数肯定是前面某个丑数乘以2，3，5的结果。所以我们首先考虑把已有的每个丑数乘以2.在乘以2的时候，
     * 能得到若干个小于或等于M的结果。由于是按照顺序生成的，小于或者等于M肯定已经在数组中了，我们不需要再次考虑；
     * 还会得到若干个大于M的结果，但我们只需要第一个大于M的结果，因为我们希望丑数是指按从小到大的顺序生成的，
     * 其他更大的结果以后再说。我们把得到的第一个乘以2后大于M的结果即为M2.
     * 同样，我们把已有的每一个丑数乘以3，5，能得到第一个大于M的结果M3和M5.
     * 那么下一个丑数应该是M2,M3,M5。这3个数的最小者。
     * 前面分析的时候，提到把已有的每个丑数分别都乘以2，3，5.事实上这不是必须的，
     * 因为已有的丑数都是按顺序存放在数组中的。
     * 对乘以2而言，肯定存在某一个丑数T2，排在它之前的每一个丑数乘以2得到的结果都会小于已有的最大丑数，
     * 在它之后的每一个丑数乘以2得到的结果都会太大。
     * 我们只需记下这个丑数的位置，同时每次生成新的丑数的时候，去更新这个T2.对乘以3和5而言，也存在这同样的T3和T5.
     * @param index
     * @return
     */
    public int getUglyNumber_Solution2(int index) {
        if (index < 0){
            return 0;
        }
        int[] uglyArray = new int[index];
        uglyArray[0] = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;
        for (int i = 1; i < index; i++) {
            // 下一个丑数为M2，M3,M5中的最小值
            int min = min(uglyArray[multiply2] * 2, uglyArray[multiply3] * 3, uglyArray[multiply5] * 5);
            uglyArray[i] = min;
            while (uglyArray[multiply2] * 2 == uglyArray[i]) {
                multiply2++;
            }
            while (uglyArray[multiply3] * 3 == uglyArray[i]) {
                multiply3++;
            }
            while (uglyArray[multiply5] * 5 == uglyArray[i]) {
                multiply5++;
            }
        }
        return uglyArray[index - 1];
    }

    public int min(int number1, int number2, int number3) {
        int min = (number1 < number2) ? number1 : number2;
        return min < number3 ? min : number3;
    }
}
