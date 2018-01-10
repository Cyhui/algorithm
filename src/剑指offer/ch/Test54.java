package 剑指offer.ch;

import java.util.LinkedHashMap;

/**
 * 题目：字符流中第一个不重复的字符
 * <p>
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * Created by Cyhui on 2018/1/10 0010.
 */
public class Test54 {

    int[] count = new int[256];
    int index = 1;

    /**
     * Insert one char from stringstream
     */
    public void Insert(char ch) {
        if (count[ch] == 0) {
            count[ch] = index++;
        } else {
            count[ch] = -1;
        }
    }

    /**
     * return the first appearence once char in current stringstream
     */
    public char FirstAppearingOnce() {
        int temp = Integer.MAX_VALUE;
        char ch = '#';
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0 && count[i] != -1 && count[i] < temp) {
                temp = count[i];
                ch = (char) i;
            }
        }
        return ch;
    }

    //********************************************************************
    /** 有序保存字符出现的次数*/
    LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
    /**
     * Insert one char from stringstream
     */
    public void insert(char ch) {
        if (map.containsKey(ch)){
            map.put(ch,map.get(ch) + 1);
        }else{
            map.put(ch,1);
        }
    }

    /**
     * return the first appearence once char in current stringstream
     */
    public char firstAppearingOnce() {
        char c = '#';
        for (Character key : map.keySet()) {
            if (map.get(key) == 1){
                c = key;
            }
        }
        return c;
    }
}
