package 剑指offer.ch41_50;

/**
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * Created by Cyhui on 2018/1/4 0004.
 */
public class Test46 {

    /**
     * 使用递归。
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int result = n;
        boolean flag = (n > 0) && ((result += Sum_Solution(n--)) > 0);
        return result;
    }
}
