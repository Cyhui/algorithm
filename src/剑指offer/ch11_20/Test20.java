package 剑指offer.ch11_20;

import java.util.ArrayList;

/**
 * 面试题20 :顺序打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，
 * 如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字   1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * Created by Cyhui on 2017/12/30 0030.
 */
public class Test20 {

    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        // 每循环一次向内圈移动
        while(tR <= dR && tC <= dC){
            printEdge(matrix,tR++,tC++,dR--,dC--);
        }
        return list;
    }
    public void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        // 子矩阵只有一行时
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                list.add(matrix[tR][i]);
            }
        } else if (tC == dC) {
            // 子矩阵只有一列时
            for (int i = tR; i <= dR; i++) {
                list.add(matrix[i][tC]);
            }
        } else { // 一般情况
            int curC = tC;
            int curR = tR;
            //打印top边
            while (curC != dC) {
                list.add(matrix[tR][curC]);
                curC++;
            }
            //打印right边
            while (curR != dR) {
                list.add(matrix[curR][dC]);
                curR++;
            }
            //打印bottom边
            while (curC != tC) {
                list.add(matrix[dR][curC]);
                curC--;
            }
            //打印left边
            while (curR != tR) {
                list.add(matrix[curR][tC]);
                curR--;
            }
        }
    }
}
