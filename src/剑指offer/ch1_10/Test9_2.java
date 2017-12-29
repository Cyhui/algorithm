package 剑指offer.ch1_10;

/**
 * 用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形 共有多少种方法。
 *
 * f(8) = f(7) + f(6)
 * Created by Cyhui on 2017/12/29 0029.
 */
public class Test9_2 {
    public int RectCover(int target) {
        if(target == 0){
            return 0;
        }
        if(target == 1 || target == 2){
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
    public static void main(String[] args){
        Test9_2 test9_2 = new Test9_2();
        System.out.println(test9_2.RectCover(3));
    }
}
