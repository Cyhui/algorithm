package nowcoder.ch04;

import java.util.Stack;

/**编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 * 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，
 * 保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 * 测试样例：
 * [1,2,3,0,4,0],6
 * 返回：[1,2]
 * Created by Cyhui on 2017/12/28 0028.
 */
public class Problem_4_4_TwoStack {

    public int[] twoStack(int[] ope, int n) {
        // write code here
        Stack<Integer> stackPush = new Stack<>();
        Stack<Integer> stackPop = new Stack<>();
        // 记录pop的次数
        int count = 0;
        int[] result;
        for (int i = 0; i < n; i++) {
            if (ope[i] != 0){
                stackPush.push(ope[i]);
            }else{
                count++;
            }
        }
        result = new int[count];
        while(!stackPush.empty()){
            stackPop.push(stackPush.pop());
        }
        int i = 0;
        while(count != 0){
            result[i++] = stackPop.pop();
            count--;
        }
        return result;
    }

    public static void main(String[] args){
        Problem_4_4_TwoStack twoStack = new Problem_4_4_TwoStack();
        int[] arr = {1,2,3,0,4,0};
        int[] a= twoStack.twoStack(arr,6);
        for (int i: a) {
            System.out.print(i + " ");
        }
    }
}
