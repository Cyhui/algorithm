package nowcoder.ch08_bitoperation;

/**
 * 请编写一个算法，不用任何额外变量交换两个整数的值。
 * <p>
 * 给定一个数组num，其中包含两个值，请不用任何额外变量交换这两个值，并将交换后的数组返回。
 * <p>
 * 测试样例：
 * [1,2]
 * 返回：[2,1]
 * Created by Cyhui on 2017/8/29 0029.
 */
public class Problem_8_3_Swap {
    public int[] getSwap(int[] num) {
        /*
            a=a0 b=b0
            a=a^b  --> a=a0^b0  b=b0
            b=a^b  --> b=a0^b0^b0=a0  a=a0^b0
            a=a^b  --> a=a0^b0^a0=b0  b=b0
         */
        num[0] = num[0] ^ num[1];
        num[1] = num[0] ^ num[1];
        num[0] = num[0] ^ num[1];
        return num;
    }

    public static void main(String[] args) {
        Problem_8_3_Swap swap = new Problem_8_3_Swap();
        int[] num = {1, 2};
        swap.getSwap(num);
        for (int i : num) {
            System.out.println(i);
        }
    }
}
