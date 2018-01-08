package 剑指offer.ch41_50;

import java.util.Arrays;

/**
 * 面试题44: 扑克牌的顺子
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
 * Created by Cyhui on 2018/1/4 0004.
 */
public class Test44 {

    /**
     * 对数组排序
     * 计算所有相邻间隔的总数
     * 统计0的个数
     *
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length != 5){
            return false;
        }
        Arrays.sort(numbers);
        // 0 的个数
        int numberOfZero = 0;
        int numbersOfGap = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (0 == numbers[i]){
                numberOfZero++;
                continue;
            }
            // 有对子返回false
            if (numbers[i] == numbers[i + 1]){
                return false;
            }
            numbersOfGap += numbers[i + 1] - numbers[i] - 1;
        }
        if (numberOfZero >= numbersOfGap){
            return true;
        }
        return false;
    }
}
