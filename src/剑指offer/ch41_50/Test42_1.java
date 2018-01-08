package 剑指offer.ch41_50;

import static zuochengyunbookcode.chapter_5_stringproblem.Problem_11_RotateString.reverse;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 * Created by Cyhui on 2018/1/4 0004.
 */
public class Test42_1 {
    public String LeftRotateString(String str,int n) {
        if(str == null || "".equals(str.trim())){
            return str;
        }
        char[] c = str.toCharArray();
        int fBegin = 0;
        int fEnd = n - 1;
        int sBegin = n;
        int sEnd = c.length - 1;

        reverse(c,fBegin,fEnd);
        reverse(c,sBegin,sEnd);
        reverse(c,fBegin,sEnd);
        return new String(c);
    }

}
