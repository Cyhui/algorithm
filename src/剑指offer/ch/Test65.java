package 剑指offer.ch;

/**
 * 题目：矩阵中的路径
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e
 * s f c s
 * a d e e
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * Created by Cyhui on 2018/1/10 0010.
 */
public class Test65 {

    /**
     * 使用回溯法  对使用过的字符进行标记后和处理后的去标记
     *
     * @param matrix 矩阵  使用一维数组模拟二维数组
     * @param rows   矩阵行数
     * @param cols   矩阵列数
     * @param str    目标字符串
     * @return 是否包含路径、
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows <= 0 || cols <= 0) {
            return false;
        }
        int[] arr = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (findPath(matrix, rows, cols, i, j, str, 0, arr)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findPath(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        int index = i * cols + j;
        if ((i < 0) || (i >= rows) || (j < 0) || (j >= cols) || (matrix[index] != str[k]) || (flag[index] == 1)){
            return false;
        }
        if (k == str.length - 1){
            return true;
        }
        flag[index] = 1;
        if (findPath(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                ||findPath(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                ||findPath(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                ||findPath(matrix, rows, cols, i, j + 1, str, k + 1, flag) ){
            return true;
        }
        flag[index] = 0;
        return false;
    }
}
