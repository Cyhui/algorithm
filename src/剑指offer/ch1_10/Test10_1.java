package 剑指offer.ch1_10;

/**
 * 用一条语句判断一个整数是不是2的整数次方。
 * 如果一个整数是2的整数次方，那么它的二进制表示中有且仅有一位是1，其余为0
 *
 * Created by Cyhui on 2017/12/29 0029.
 */
public class Test10_1 {
    public boolean powerOfTwo(int n){
        int count = 0;
        while(n != 0){
            count++ ;
            n = n & (n - 1);
        }
        if (count == 1){
            return true;
        }
        return false;
    }
}
