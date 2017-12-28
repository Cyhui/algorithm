package nowcoder.ch04;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 * 测试样例：[1,2,3,4,5]
 * 返回：[5,4,3,2,1]
 * Created by Cyhui on 2017/12/28 0028.
 */
public class Problem_4_6_TwoStacks {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        if (numbers == null || numbers.length == 0){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        // 使用一维数组模拟栈，向栈中填充数据时需要从后往前填充
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> help = new Stack<>();

        for (int i = numbers.length - 1; i >= 0 ; i--) {
            stack.push(numbers[i]);
        }

        //排序 将小数放在栈底
        while(!stack.empty()){
            int current = stack.pop();
            while (!help.empty() && help.peek() > current){
                stack.push(help.pop());
            }
            help.push(current);
        }

        while(!help.empty()){
            res.add(help.pop());
        }
        return res;
    }
}
