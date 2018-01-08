package 剑指offer.ch41_50;

/**
 * 面试题43：n个骰子的点数
 * 题目：把n个骰子扔在地上，所有骰子朝上一面的点数和为S
 * 输入n，打印出s的所有可能的值出现的概率
 * <p>
 * Created by Cyhui on 2018/1/4 0004.
 */
public class Test43 {
    /** **/
    int maxValue = 6;

    public void printProbability(int number) {
        if (number < 1) {
            return;
        }
        //定义一个长度为6n-n+1的数组，和为s的点数出现的次数保存在数组第s-n个元素里、
        int maxSum = number * maxValue;
        int[] probability = new int[maxSum - number + 1];
        for (int i = number; i <= maxSum; i++) {
            probability[i - number] = 0;
        }

        probability(number, probability);

        double total = Math.pow(maxValue, number);
        for (int i = number; i <= maxSum; i++) {
            double ratio = probability[i - number] / total;
            System.out.print(String.format("%d : %e\n", i, ratio));
        }
    }

    private void probability(int number, int[] probability) {
        for (int i = 1; i <= maxValue; i++) {
            probability(number, number, i, probability);
        }
    }

    private void probability(int original, int current, int sum, int[] probability) {
        if (current == 1) {
            probability[sum - original]++;
        } else {
            for (int i = 1; i <= maxValue; i++) {
                probability(original, current - 1, i + sum, probability);
            }
        }
    }

/******************   循环写法*********************************************/

    /**
     * 用两个数组保存
     * @param number
     */
    public void printProbability2(int number) {

    }
}
