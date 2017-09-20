package nowcoder.ch02_sort;

/**
 * 有序矩阵查找
 * <p>
 * 现在有一个行和列都排好序的矩阵，请设计一个高效算法，快速查找矩阵中是否含有值x。
 * <p>
 * 给定一个int矩阵mat，同时给定矩阵大小nxm及待查找的数x，请返回一个bool值，代表矩阵中是否存在x。所有矩阵中数字及x均为int范围内整数。保证n和m均小于等于1000。
 * <p>
 * 测试样例：
 * [[1,2,3],[4,5,6],[7,8,9]],3,3,10
 * 返回：false
 * Created by Cyhui on 2017/9/20 0020.
 */
public class Problem_2_18_Finder {
    public boolean findX(int[][] mat, int n, int m, int x) {
        if (m <= 0 || n <= 0) {
            return false;
        }
        int row = 0;    //第一行
        int col = m - 1; //最后一列

        while(row < n && col >= 0){
            if (mat[row][col] < x){
                // x大于这一行最大值   行标下移
                row++;
            }else if (mat[row][col] == x){
                // 找到x
                return true;
            }else{
                // x小于这一行最大值    列标左移
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Problem_2_18_Finder finder = new Problem_2_18_Finder();
        int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
        boolean b = finder.findX(mat,3,3,9);
        System.out.println(b);
    }
}
