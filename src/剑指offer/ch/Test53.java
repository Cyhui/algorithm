package 剑指offer.ch;

/**
 * 题目：表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * Created by Cyhui on 2018/1/11 0011.
 */
public class Test53 {
    char arr[] = {'+','-','n','.','n','e','+','-','n'};
    int turn[][] = {
        //+  -  n  .  n  e  +  -  n
            {1, 1, 1, 0, 0, 0, 0, 0, 0},// # start
            {0, 0, 1, 1, 0, 0, 0, 0, 0},// +
            {0, 0, 1, 1, 0, 0, 0, 0, 0},// -
            {0, 0, 1, 1, 0, 1, 0, 0, 0},// n
            {0, 0, 0, 0, 1, 0, 0, 0, 0},// .
            {0, 0, 0, 0, 1, 1, 0, 0, 0},// n
            {0, 0, 0, 0, 0, 0, 1, 1, 1},// e
            {0, 0, 0, 0, 0, 0, 0, 0, 1},// +
            {0, 0, 0, 0, 0, 0, 0, 0, 1},// -
            {0, 0, 0, 0, 0, 0, 0, 0, 1} // n
    };
    public boolean isNumeric(char[] string) {
        int cur = 0;
        for(int j, i = 0; i < string.length; i++) {
            for(j = 0; j < 9; j++) {
                if(turn[cur][j] == 1) {
                    if(('0' <= string[i] && string[i] <= '9' && arr[j] == 'n') || (string[i] == 'E' && arr[j] == 'e')||
                        string[i] == arr[j]) {
                        cur = j + 1;
                        break;
                    }
                }
            }
            if(j == 9) {
                return false;
            }
        }
        if(cur == 3 || cur == 4 || cur == 5 || cur == 9){
            return true;
        }
        return false;
    }
}
