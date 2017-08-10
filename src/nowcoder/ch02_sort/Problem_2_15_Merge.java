package nowcoder.ch02_sort;

/**
 * *******有序数组合并练习题************
 * 有两个从小到大排序以后的数组A和B，其中A的末端有足够的缓冲空容纳B。请编写一个方法，将B合并入A并排序。
 * <p>
 * 给定两个有序int数组A和B，A中的缓冲空用0填充，同时给定A和B的真实大小int n和int m，请返回合并后的数组。
 * <p>
 * Created by Cyhui on 2017/8/9 0009.
 */
public class Problem_2_15_Merge {
    public int[] mergeAB(int[] A, int[] B, int n, int m) {
        while (m != 0) {
            if (n == 0) {
                A[m - 1] = B[m - 1];
                m--;
            } else {
                A[m + n - 1] = A[n - 1] > B[m - 1] ? A[--n] : B[--m];
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = { 1, 4, 5, 0, 0,0,0};
        int[] B = { 2, 3 };
        Problem_2_15_Merge merge = new Problem_2_15_Merge();
        merge.mergeAB(A, B, 3, 2);
        for (int i = 0; i < 5; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
