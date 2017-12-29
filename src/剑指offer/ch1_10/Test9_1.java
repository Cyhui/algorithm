package 剑指offer.ch1_10;

/**
 * 面试题9_1
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。2^(n-1)  1<<--n
 * Created by Cyhui on 2017/12/29 0029.
 */
public class Test9_1 {
    public int JumpFloor(int target) {
        if (target <= 0 ){
            return 0;
        }
        if (target == 1 || target == 2){
            return target;
        }
        int prepre = 1;
        int pre = 2;
        int current = 2;
        for (int i = 3; i <= target; i++) {
            current = prepre + pre;
            prepre = pre;
            pre = current;
        }
        return current;
    }
}
