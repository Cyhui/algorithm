package 剑指offer.ch31_40;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 面试题33：把数组排成最小的数、
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * Created by Cyhui on 2018/1/9 0009.
 */
public class Test33 {

    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0){
            return "";
        }
        StringBuilder str = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 解决大数问题的方法就是把数字转换成字符串，数字m和数字n拼成的mn和nm
                // 比较它们的大小只需要按照字符串大小比较。
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        for (int i : list) {
            str.append(i);
        }
        return str.toString();
    }
}
