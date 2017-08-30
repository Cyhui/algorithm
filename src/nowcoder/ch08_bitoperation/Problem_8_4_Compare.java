package nowcoder.ch08_bitoperation;

/**
 * 对于两个32位整数a和b，请设计一个算法返回a和b中较大的。但是不能用任何比较判断。若两数相同，返回任意一个。
 * <p>
 * 给定两个整数a和b，请返回较大的数。
 * <p>
 * 测试样例：
 * 1,2
 * 返回：2
 * <p>
 * Created by Cyhui on 2017/8/29 0029.
 */
public class Problem_8_4_Compare {

    /**
     * 如果n为1返回0，n为0返回1
     *
     * @param n
     * @return
     */
    public static int flip(int n) {
        return n ^ 1;
    }

    /**
     * 返回整数n的符号 正数和0返回1 负数返回0
     *
     * @param n
     * @return
     */
    public static int sign(int n) {
        return flip((n >> 31) & 1);
        //>> 系有符号右移，右移后，会保留最高位不变。 >>> 系无符号右移，右移后，最高位置0。
    }

    // 方法一：得到a-b的符号，根据该符号决定返回a或b
    // 当a-b溢出时，会发生错误
    public static int getMax1(int a, int b) {
        int c = a - b;
        int scA = sign(c);
        int scB = flip(scA);
        return a * scA + b * scB;
    }

    // 方法二：
    public static int getMax2(int a, int b) {
        int c = a - b;
        // a的符号，as==1表示a为非负,as==0表示a为负
        int as = sign(a);
        // b的符号，bs==1表示a为非负,bs==0表示a为负
        int bs = sign(b);
        // a-b的符号
        int cs = sign(c);
        // 表示a和b是否符号不相同，不相同为1，相同为0
        int difab = as ^ bs;
        // 表示a和b是否符号相同，相同为1，不相同为0
        int sameab = flip(difab);
        int returnA = difab * as + sameab * cs;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }
}
