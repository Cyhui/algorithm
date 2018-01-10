package 剑指offer.ch21_30;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 面试题28：字符串的排列
 * <p>
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * Created by Cyhui on 2018/1/1 0001.
 */
public class Test28 {

    public static void main(String[] args) {
        Test28 test28 = new Test28();
        String str = "aa";
        test28.Permutation(str);
    }

    /**
     * 递归解法
     * 回溯法。
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return res;
    }

    private void PermutationHelper(char[] chars, int i, ArrayList<String> res) {
        if (i == chars.length - 1) {
            String val = String.valueOf(chars);
            if (!res.contains(val)) {
                res.add(val);
            }
        } else {
            for (int j = i; j < chars.length; j++) {
                // 例abc  a与 a,b,c交换位置
                swap(chars, i, j);
                // 全排序后面的序列
                PermutationHelper(chars, i + 1, res);
                // 复位
                swap(chars, i, j);
            }
        }
    }

    private void swap(char[] chars, int i1, int i2) {
        if (i1 != i2) {
            char c = chars[i1];
            chars[i1] = chars[i2];
            chars[i2] = c;
        }
    }
}
