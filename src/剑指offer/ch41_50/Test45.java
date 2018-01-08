package 剑指offer.ch41_50;

import java.util.*;

/**
 * 面试题45：圆圈中最后剩下的数字
 * 题目：0,1，。。。，n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个
 * 数字，求剩下的最后一个数字。
 * 两种解法：
 * 1.用环形链表模拟圆圈
 * 2.使用数字的规律直接计算
 * Created by Cyhui on 2018/1/4 0004.
 */
public class Test45 {

    public static void main(String[] args) {
        Test45 test45 = new Test45();
        test45.LastRemaining_Solution1(5, 3);
        System.out.println(test45.getResult(5));
    }

    /**
     * 模拟
     *
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution1(int n, int m) {
        //输入不合法
        if (n < 1 || m < 1) {
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int listSize = n;
        Iterator<Integer> it = list.iterator();
        while (list.size() > 1) {
            for (int i = 1; i <= m; i++) {
                if (it.hasNext()) {
                    it.next();
                } else {
                    //当迭代器扫描到链表尾部时，需要把迭代器移动到链表的头部
                    it = list.iterator();
                    it.next();
                }
            }
            it.remove();
            listSize--;
        }
        it = list.iterator();
        return it.next();
    }

    /**
     * 使用数学规律计算
     *
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }

    /**
     * 约瑟夫环2：
     * @param n
     * @return
     */
    public int getResult(int n) {
        // write code here
        if (n <= 2) {
            return 1;
        }

        LinkedList<Integer> list = new LinkedList<>();
        // 初始化
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        // 初始步长
        int m = 2;
        while (list.size() > 1) {
            for (int i = 0; i < list.size(); i++) {
                if ((i + 1) % m != 1) {
                    list.set(i, -1);
                }
            }
            int i = 0;
            Iterator<Integer> it = list.iterator();
            while(it.hasNext()){
                if (it.next() == -1){
                    it.remove();
                }
            }
            //取出最后一个元素放到链表前面
            int last = list.removeLast();
            list.addFirst(last);

            m++;

        }
        return list.remove(0);
    }
}
