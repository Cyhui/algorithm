package 剑指offer.ch;

/**
 * 构建乘积数组
 *
 * 给定一个数组A[0,1,...,n-1],
 * 请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 * Created by Cyhui on 2018/1/11 0011.
 */
public class Test51 {

    /***
     * B[i]的值可以看作矩阵中每行的乘积
     *             -    -    -      -     -      -
     *   B(0)    |1   |A(1)|A(2)|  ... |A(N-2)|A(N-1))|
     *   B(1)    |A(0)|  1 |A(2)|  ... |A(N-2)|A(N-1))|
     *   B(2)    |A(0)|A(1)| 1  |  ... |A(N-2)|A(N-1))|
     *   ...     |A(0)|A(1)| ...|   1  |A(N-2)|A(N-1))|
     *   B(N-2)  |A(0)|A(1)| ...|A(N-3)|  1   |A(N-1))|
     *   B(N-1)  |A(0)|A(1)| ...|A(N-3)|A(N-2)|  1    |
     *             -    -    -     -      -      -
     *   下三角用连乘容易求得，上三角，从下到上也是连乘
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if(length != 0){
            B[0] = 1;
            // 计算下三角连乘
            for (int i = 1; i < length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            // 计算上三角连乘
            for (int i = length - 2; i >= 0; i--) {
                temp *= A[i + 1];
                B[i] *= temp;
            }
        }
        return B;
    }
}
