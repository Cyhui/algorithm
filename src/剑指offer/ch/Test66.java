package 剑指offer.ch;

/**
 * 题目：机器人的运动范围
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 * Created by Cyhui on 2018/1/10 0010.
 */
public class Test66 {

    /**
     *
     核心思路：
     1.从(0,0)开始走，每成功走一步标记当前位置为true,然后从当前位置往四个方向探索，
     返回1 + 4 个方向的探索值之和。
     2.探索时，判断当前节点是否可达的标准为：
     1）当前节点在矩阵内；
     2）当前节点未被访问过；
     3）当前节点满足limit限制。
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        // 记录是否已经访问
        int[][] flag = new int[rows][cols];
        return helper(0, 0, rows, cols, flag, threshold);
    }

    /**
     *
     * @param x                   横坐标
     * @param y                   纵坐标
     * @param rows                行数
     * @param cols                列数
     * @param flag                访问标记
     * @param threshold          最大目标数k
     * @return
     */
    private int helper(int x, int y, int rows, int cols, int[][] flag, int threshold) {
        if (x < 0 || x >= rows || y < 0 || y >= cols ||
                numSum(x) + numSum(y) > threshold || flag[x][y] == 1) {
            return 0;
        }
        // 标记不需要复原
        flag[x][y] = 1;
        return 1 + helper(x - 1, y, rows, cols, flag, threshold)
                + helper(x + 1, y, rows, cols, flag, threshold)
                + helper(x, y - 1, rows, cols, flag, threshold)
                + helper(x, y + 1, rows, cols, flag, threshold);
    }

    private int numSum(int x) {
        int sum = 0;
        while(x != 0){
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
