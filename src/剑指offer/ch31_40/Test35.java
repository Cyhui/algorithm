package 剑指offer.ch31_40;

import java.util.ArrayList;

/**
 * 面试题35：第一个只出现一次的字符
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * Created by Cyhui on 2018/1/4 0004.
 */
public class Test35 {

    /**
     * 一般做法O(n²)  从头开始扫描这个字符串的每个字符。当访问到某个字符是拿这个字符和后面的每个字符比较，
     * 如果没有重复的字符，这个字符就是只出现一次的字符
     * 不是面试官想要的
     *
     * O(n)的解法：使用hash表
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if (str == null){
            return -1;
        }
        int[] hash = new int[256];
        // 第一次遍历统计出每个字符出现的次数
        for (int i = 0; i < str.length(); i++) {
            hash[str.charAt(i)]++;
        }
        // 第二次遍历返回第一个只出现1次的字符
        for (int i = 0; i < str.length(); i++){
            if (hash[str.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }
}
