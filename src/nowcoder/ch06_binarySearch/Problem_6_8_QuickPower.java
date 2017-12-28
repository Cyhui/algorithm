package nowcoder.ch06_binarySearch;

import java.math.BigInteger;

/**
 * 如果更快的求一个整数k的n次方。
 * 如果两个整数相乘并得到结果的时间复杂度为O(1)，得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。
 给定k和n，请返回k的n次方，为了防止溢出，请返回结果Mod 1000000007的值。
 测试样例：
 2,3
 返回：8
 * Created by Cyhui on 2017/12/21 0021.
 */
public class Problem_6_8_QuickPower {
    public static int getPower(int k, int N) {
        // write code here
        if (N == 0){
            return 1;
        }
       String binN = Integer.toBinaryString(N);
        int len = binN.length();

        long res = 1;
        long cur = k;

        for (int i = len - 1; i >= 0 ; i--) {
            if (binN.charAt(i) == '1'){
                res = res * cur;
            }
            cur = (cur * cur) % 1000000007;
            res = res % 1000000007;
        }
        return (int)res;
    }

    public static void main(String[] args){

    }
}
