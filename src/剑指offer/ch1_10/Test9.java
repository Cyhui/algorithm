package 剑指offer.ch1_10;

/**
 * 面试题9 ：斐波那契数列  使用递归效率低
 * Created by Cyhui on 2017/12/29 0029.
 */
public class Test9 {
    public int Fibonacci(int n) {
        // 输入非正整数
        if (n <= 0){
            return 0;
        }
        // 输入1或2的时候返回1
        if (n == 1 || n == 2){
            return 1;
        }
        // 记录前两个(第n-2个)的fiboncci数的值
        int prepre = 1;
        // 记录前两个(第n-1个)的fiboncci数的值
        int pre = 1;
        // 记录前两个(第n个)的fiboncci数的值
        int current = 2;

        // 求解第n个的fiboncci数的值
        for (int i = 3; i <= n; i++) {
            // 第i个的fiboncci数的值
            current = prepre + pre;
            prepre = pre;
            pre = current;
        }
        return current;
    }
}
