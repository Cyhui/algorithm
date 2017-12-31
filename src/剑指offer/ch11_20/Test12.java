package 剑指offer.ch11_20;

import java.util.Arrays;

/**
 * 面试题12 ： 打印1到最大的n位数
 *
 * 不可行的方法：先求出最大的n位数，然后用一个循环从1开始打印。需要考虑大数问题
 *
 * 在字符串上模拟数字加法的解法。
 *    使用字符串或数组表示大数。
 *    思路：字符串中每个字符都是0-9之间的某个字符，用来表示数字中的一位。
 *        数字是n位的，需要n+1位的字符串（字符串最后一位是'\0'结束符）。
 *        数字不够n位是在字符串前补0
 * Created by Cyhui on 2017/12/29 0029.
 */
public class Test12 {

    public void printToMaxOfNDigits(int n){
        if (n <= 0){
            return;
        }
        char[] number = new char[n + 1];
        // 初始化字符数组
        number[n] = '\0';
        Arrays.fill(number,0,n - 1,'0');

        while (!increment(number)){
            printNumber(number);
        }
    }

    /**
     * 打印数组中表示的数，如果数组中表示的数字位数小于n，则不打印前面的0
     * 陷阱按照阅读习惯打印数字。
     * @param number 字符数组
     */
    private void printNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;

        for (int i = 0; i < nLength; i++) {
            if (isBeginning0 && number[i] != '0'){
                isBeginning0 = false;
            }
            if (!isBeginning0){
                System.out.print("%c");
            }
        }
    }

    /**
     * O(1)判断是否已经到了最大的n位数
     * 陷阱：如何在每一次增加1之后快速判断是不是到了最大的n位数
     *
     * @param number 字符数组
     * @return true false
     */
    private boolean increment(char[] number) {
        // 进位标识符
        boolean isOverFlow = false;
        // 进位的位数
        int nTakeOver = 0;
        int nLength = number.length;
        // 没有产生进位的+1,循环只运行1次，产生一个进位，循环多运行一次
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = number[i] - '0' + nTakeOver;
            if (i == nLength - 1){
                //最低位+1
                nSum++;
            }
            if (nSum >= 10){
                //最高位产生进位
                if (i == 0){
                    isOverFlow = true;
                }else{
                    //普通位产生进位
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char)('0' + nSum);
                }
            }else {
                // 普通位+1的结果保存到数组中，+1后程序退出循环
                number[i] =(char)('0' + nSum);
                break;
            }
        }
        return isOverFlow;
    }
}
