package 剑指offer.ch11_20;

/**
 * 面试题11：数值的整数次方
 * 题目描述:
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * Created by Cyhui on 2017/12/29 0029.
 */
public class Test11 {
    /*
     *剑指书中细节：
     *1.当底数为0且指数<0时会出现对0求倒数的情况，需进行错误处理，设置一个全局变量；
     *2.判断底数是否等于0
     *由于base为double型，不能直接用==判断
     *3.优化求幂函数
     *当n为偶数，a^n =（a^n/2）*（a^n/2）
     *当n为奇数，a^n = a^[(n-1)/2] * a^[(n-1)/2] * a
     *时间复杂度O(logn)
     */

    /**
     * 注意：计算机中不能直接用等号判断两个小数是否相等。
     * O（logn）时间内求fiboncci数列
     * a^n = a^(n/2)*a^(n/2) n为偶数
     * a^n = a^((n-1)/2)*a^((n-1)/2)*a n为奇数
     *
     * @param base
     * @param exponent
     * @return
     */
    public double power(double base, int exponent) throws Exception {
        double result = 0.0;
        if (equals(base, 0) && (exponent < 0)) {
            throw new Exception("0的负数次幂无意义");
        }
        if (exponent == 0) {
            return 1.0;
        }
        if (exponent < 0) {
            result = powerWithUnsignedExponent(base, -exponent);
        } else {
            result = powerWithUnsignedExponent(base, exponent);
        }
        return result;
    }

    private double powerWithUnsignedExponent(double base, int exponent) {
        double result = 1.0;
        for (int i = 1; i <= exponent; i++) {
            result = result * base;
        }
        return result;
    }

    /**
     * 由于计算机中表示小数都有误差，不能用等号判断两个小数是否相等。如果两个小数的差的绝对值很小
     * 我们就可以认为它们是相等的
     */
    private boolean equals(double number1, int number2) {
        if ((number1 - number2 > -0.00000001)
                && (number1 - number2) < 0.00000001) {
            return true;
        }
        return false;
    }

    public double Power(double base, int exponent) {
        double result = 0.0;
        // 指数和底数不能同时为0
        if (base == 0 && exponent == 0) {
            throw new RuntimeException("invalid input. base and exponent both are zero");
        }
        int n = Math.abs(exponent);
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        result = Power(base, n >> 1);
        result *= result;
        if ((n & 1) == 1) {
            result *= base;
        }
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }
}
