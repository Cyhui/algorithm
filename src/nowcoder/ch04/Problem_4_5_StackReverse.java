package nowcoder.ch04;

import java.util.Stack;

/**
 *实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
 * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
 * 测试样例：
 * [4,3,2,1],4
 * 返回：[1,2,3,4]
 * Created by Cyhui on 2017/12/28 0028.
 */
public class Problem_4_5_StackReverse {
    public int[] reverseStack(int[] A, int n) {
        // write code here
        if (A == null || n == 0){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0 ; i--) {
            stack.push(A[i]);
        }
        reverse(stack);
        int i = 0;
        int[] res = new int[n];
        while(!stack.empty()){
            res[i++] = stack.pop();
        }
        return res;
    }

    public int get(Stack<Integer> stack){
        int current = stack.pop();
        if (stack.empty()){
            return current;
        }else {
            int last = get(stack);
            stack.push(current);
            return last;
        }
    }

    public void reverse(Stack<Integer> stack){
        if (stack.empty()){
            return;
        }
        int i = get(stack);
        reverse(stack);
        stack.push(i);
    }
}
