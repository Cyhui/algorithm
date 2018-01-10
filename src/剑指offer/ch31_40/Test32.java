package 剑指offer.ch31_40;

/**
 * 面试题32：从1到n整数中1出现的次数
 * Created by Cyhui on 2018/1/9 0009.
 */
public class Test32 {

    /***********************************************************/
    /**
     * 方法一：复杂度较高
     * @param num
     * @return
     */
    public int solution1(int num){
        if (num < 1){
            return 0;
        }
        int count = 0;
        for (int i = 1; i != num + 1 ; i++) {
            count += get1Nums(num);
        }
        return count;
    }
    public int get1Nums(int num){
        int res = 0;
        while(num != 0){
            if (num % 10 == 1){
                res++;
            }
            num /= 10;
        }
        return res;
    }
    /***********************************************************/
    /**
     * 方法二：分析1的规律
     *  1 ~ 21345  分成两段。1-1345 1346-21345
     *  1在10000-19999这10000个数字的万位中，一共出现10000(10²)个
     * @param num
     * @return
     */
    public int solution2(int num){
        if (num < 1){
            return 0;
        }
        int len = getLenOfNum(num);
        if (len == 1){
            return 1;
        }
        int tmp1 = powerBaseOf10(len);
        int first = num / tmp1;
        int firstOneNum = first == 1 ? num % tmp1 + 1: tmp1;
        int otherOneNum = first * (len - 1) * (tmp1 / 10);
        return firstOneNum + otherOneNum + solution2(num % tmp1);
    }
    public int getLenOfNum(int num){
        int len = 0;
        while(num != 0){
            len++;
            num /= 10;
        }
        return len;
    }
    public int powerBaseOf10(int base){
        return (int) Math.pow(10,base);
    }
}
