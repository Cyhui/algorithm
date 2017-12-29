package 剑指offer.ch1_10;

/**
 * 输入两个整数m和n,计算需要改变m的二进制表示中的多少位才能得到n。
 *
 * 思路：
 * 先求两个数的异或，再求异或中1的个数
 * Created by Cyhui on 2017/12/29 0029.
 */
public class Test10_2 {
    public static int test(int m,int n){
        int k = m ^ n;
        int count = 0;
        while(k != 0){
            count++;
            k = k & (k - 1);
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(test(8,2));
    }
}
