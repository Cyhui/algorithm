package 剑指offer.ch1_10;

/**有两个排序的数组A1和A2,内存在A1的末尾有足够多的空余空间容纳A2.
 * 请实现一个函数，把A2中所有的数字插入到A1中并且数子是排序的
 * Created by Cyhui on 2017/12/29 0029.
 */
public class Test4_1 {
    /**
     *
     * @param A1  A1
     * @param A2  A2
     * @param n  A1的有效长度
     * @param m  B1的有效长度
     * @return   合并后的数组
     */
    public int[] mergeAB(int[] A1, int[] A2, int n ,int m) {
        while(m != 0){
            if (n == 0){
                A1[m - 1] = A2[m - 1];
                m--;
            }else {
                A1[m + n - 1] = A1[n-1] > A2[m-1] ? A1[--n]: A2[--m];
            }
        }
        return A1;
    }
}
